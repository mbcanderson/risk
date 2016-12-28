package com.anderson.risk.DiceSimulator;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class RandomNumberDiceSimulator implements DiceSimulator {

    public int roll() {
        return (int) (Math.random()*6) + 1;
    }

}
