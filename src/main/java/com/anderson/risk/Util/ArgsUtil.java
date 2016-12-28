package com.anderson.risk.Util;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class ArgsUtil {

    public static void requireThat(boolean conditionChecked, String exceptionMessage) {
        if (!conditionChecked) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void requireThat(boolean conditionChecked) {
        requireThat(conditionChecked, "");
    }
}
