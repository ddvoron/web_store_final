package com.voronovich.hash;

import java.security.MessageDigest;

/**
 * Class designed for encoding data using Sha256
 *
 * @author Dmitry V
 * @version 1.0
 */
public class Sha256 {

    /**
     * Method encodes String object with sha256
     *
     * @param base String parameter
     * @return String encoded object
     */
    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}