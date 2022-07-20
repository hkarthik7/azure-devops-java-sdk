package org.azd.helpers;

import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.AzDException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamHelper {
    private static int DEFAULT_BYTE_ARRAY_SIZE = 8192;

    public static int getDefaultByteArraySize() {
        return DEFAULT_BYTE_ARRAY_SIZE;
    }

    public static void setDefaultByteArraySize(int defaultByteArraySize) {
        DEFAULT_BYTE_ARRAY_SIZE = defaultByteArraySize;
    }

    public static void download(String fileName, InputStream responseStream) throws AzDException {
        try (FileOutputStream outputStream = new FileOutputStream(fileName, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BYTE_ARRAY_SIZE];
            while ((read = responseStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }

    public static String convertToString(InputStream responseStream) throws AzDException {
        try {
            return new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }

    public static InputStream convertToStream(File file) throws AzDException {
        try {
            return new DataInputStream(new FileInputStream(file));
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }

    public static InputStream convertToStream(String content) throws AzDException {
        try {
            return new ByteArrayInputStream(content.getBytes());
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }
}
