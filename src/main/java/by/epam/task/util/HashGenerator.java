package by.epam.task.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    private static final Logger logger = LogManager.getLogger();

    private static final String PASSWORD_ALGORITHM_SHA256 = "SHA-256";

    private static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String generatePassword(String stringToEncrypt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(PASSWORD_ALGORITHM_SHA256);
            messageDigest.update(stringToEncrypt.getBytes());
            return byteArray2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error in hash generation: ", e);
        }
        return stringToEncrypt;
    }

    private static String byteArray2Hex(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for(final byte b : bytes) {
            sb.append(hex[(b & 0xF0) >> 4]);
            sb.append(hex[b & 0x0F]);
        }
        return sb.toString();
    }
}
