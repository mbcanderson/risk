package com.anderson.risk.Util;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class UIUtilTest {

    @Ignore
    public void testInputDialogBox() {
        int input = UIUtil.userInputWindowForInt("testInput", i -> i == 3, "Nope! You must input 3");
        assertEquals(3, input);
    }
}