package com.completeTimeFlow.security.util;

public class Utils {

    public static boolean isNull(Object... objects) {
        for (Object object : objects) {
            if (isNull(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotNull(Object... values) {
        return !isNull(values);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

}
