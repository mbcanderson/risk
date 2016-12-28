package com.anderson.risk;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class DiceSimulator {

    public int roll() {
        return (int) (Math.random()*6) + 1;
    }

}
