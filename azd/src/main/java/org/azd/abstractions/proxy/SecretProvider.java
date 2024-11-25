package org.azd.abstractions.proxy;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Java implementation of azure-devops-node-api sdk's task library secrets method.
 */
public class SecretProvider {
    /**
     * Determines the secrets for given lookup key.
     * @param lookupKey base64encoded(keyFilePath):base64encoded(encryptedContent).
     * @return Decrypted secret value.
     * @throws Exception default.
     */
    public static String readTaskLibSecrets(String lookupKey) throws Exception {
        // This is the java implementation of azure-devops-node-api sdk's `readTaskLibSecrets` method.
        // The lookupKey should have the following format:
        // base64encoded<keyFilePath>:base64encoded<encryptedContent>
        if (lookupKey != null && lookupKey.contains(":")) {
            var lookupInfo = lookupKey.split(":", 2);

            // File contains encryption key
            var keyFilePath = new String(Base64.getDecoder().decode(lookupInfo[0]), StandardCharsets.UTF_8);
            var encryptKeyBytes = Files.readAllBytes(Paths.get(keyFilePath));
            var encryptKey = new SecretKeySpec(encryptKeyBytes, "AES");

            var encryptedContent = new String(Base64.getDecoder().decode(lookupInfo[1]), StandardCharsets.UTF_8);

            var decipher = Cipher.getInstance("AES/CTR/NoPadding");
            decipher.init(Cipher.DECRYPT_MODE, encryptKey, new IvParameterSpec(new byte[16]));

            var decryptedContentBytes = decipher.doFinal(hexStringToByteArray(encryptedContent));
            return new String(decryptedContentBytes, StandardCharsets.UTF_8);
        }

        return null;
    }

    /**
     * Converts the given hex string to byte array.
     * @param hex Hex string to convert.
     * @return Byte array of converted hex string.
     */
    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
