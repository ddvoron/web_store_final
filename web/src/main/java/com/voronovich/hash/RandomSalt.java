package com.voronovich.hash;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Class for generating secure string objects
 *
 * @author Dmitry V
 * @version 1.0
 */
public final class RandomSalt {

    private static char[] VALID_CHARACTERS =
            ResourceBundle.getBundle("data").getString("charMassive").toCharArray();

    /**
     * Method-generator of string objects
     *
     * @param numChars number of symbols in line
     * @return generated String object
     */
    public static String csRandomAlphaNumericString(int numChars) {
        SecureRandom secureRandom = new SecureRandom();
        Random rand = new Random();
        char[] buff = new char[numChars];

        for (int i = 0; i < numChars; ++i) {
            if ((i % 10) == 0) {
                rand.setSeed(secureRandom.nextLong());
            }
            buff[i] = VALID_CHARACTERS[rand.nextInt(VALID_CHARACTERS.length)];
        }
        return new String(buff);
    }
}