package com.epam.auto.utils;

import java.util.Random;

/**
 * Created by ekaterinabut on 11/11/15.
 */
public class StringUtils {

    private static final String AZ09 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    public static String getRandomString(int len)
    {
        StringBuilder sb = new StringBuilder(len);
        for (int i=0; i<len; i++)
        {
            sb.append(AZ09.charAt(rnd.nextInt(AZ09.length())));
        }
        return sb.toString();
    }
}