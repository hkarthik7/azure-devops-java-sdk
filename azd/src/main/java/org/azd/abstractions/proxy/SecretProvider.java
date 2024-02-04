package org.azd.abstractions.proxy;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class SecretProvider {
    public static String readTaskLibSecrets(String lookupKey) throws Exception {
        // This is copied from the sdk implementation for Node
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
