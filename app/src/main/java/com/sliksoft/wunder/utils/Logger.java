package com.sliksoft.wunder.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Osama Slik on 31/08/2018.
 */
public class Logger {
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");

    public static void d(String message)
    {
        Log.d(getTag(),message);
    }
    public static void i(String message)
    {
        Log.i(getTag(),message);
    }
    public static void i(Throwable message)
    {
        Log.i(getTag(),message.getMessage());
    }
    public static void d(Throwable message)
    {
        Log.d(getTag(),message.getMessage());
    }


    private static String getTag() {
        String className = Thread.currentThread().getStackTrace()[5].getClassName();
        Matcher m = ANONYMOUS_CLASS.matcher(className);
        if (m != null && m.find()) {
            className = m.replaceAll("");
        }
        return className.substring(className.lastIndexOf('.') + 1);
    }
}
