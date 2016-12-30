package com.anderson.risk.Util;

import javax.swing.*;
import java.util.function.Predicate;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class UIUtil {

    public static int userInputWindowForInt(String message, Predicate<Integer> validityCheck, String errorMessage) {
        String result = JOptionPane.showInputDialog(message);
        try {
            int i = Integer.parseInt(result);
            if (!validityCheck.test(i)) {
                showError(errorMessage);
            } else {
                return i;
            }
        } catch (NumberFormatException e) {
            showError("must input an int");
        }
        return userInputWindowForInt(message, validityCheck, errorMessage);

    }

    private static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(new JFrame(),
                errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

}
