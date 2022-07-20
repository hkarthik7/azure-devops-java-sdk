package org.azd.helpers;

import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.AzDException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamHelper {
    /**
     * Default size of byte array
     */
    private static int DEFAULT_BYTE_ARRAY_SIZE = 8192;

    /**
     * Returns the default byte array size
     *
     * @return Default byte array size
     */
    public static int getDefaultByteArraySize() {
        return DEFAULT_BYTE_ARRAY_SIZE;
    }

    /**
     * Sets the byte array size
     *
     * @param defaultByteArraySize Size of the byte array to set
     */
    public static void setDefaultByteArraySize(int defaultByteArraySize) {
        DEFAULT_BYTE_ARRAY_SIZE = defaultByteArraySize;
    }

    /**
     * Downloads the contents from InputStream and saves it in a file.
     *
     * @param fileName       Pass the full path with file name to save the contents.
     * @param responseStream Input response stream from Api or from a file.
     * @throws AzDException Default exception handler
     */
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

    /**
     * Convert the InputStream stream to string
     *
     * @param responseStream Input response stream from Api or from a file.
     * @return String content
     * @throws AzDException Default exception handler
     */
    public static String convertToString(InputStream responseStream) throws AzDException {
        try {
            return new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }

    /**
     * Convert the file contents to input stream
     *
     * @param file File object specified with complete path
     * @return Input stream
     * @throws AzDException Default exception handler
     */
    public static InputStream convertToStream(File file) throws AzDException {
        try {
            return new DataInputStream(new FileInputStream(file));
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }

    /**
     * Convert the string content to input stream
     *
     * @param content String content to convert
     * @return Input stream
     * @throws AzDException Default exception handler
     */
    public static InputStream convertToStream(String content) throws AzDException {
        try {
            if (content.isEmpty()) throw new AzDException("Content cannot be empty.");
            return new ByteArrayInputStream(content.getBytes());
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), e.getMessage());
        }
    }
}
