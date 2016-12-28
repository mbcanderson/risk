package com.anderson.risk;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class TerritoryTest {

    private Territory territory;

    @Before
    public void setup() {
        territory = new Territory();
    }

    @Test
    public void addAndRemoveArmies() {
        territory.setOccupant(new Player("test"), 1);
        assertTrue(territory.hasOccupanyingArmies());
        territory.addArmies(5);
        assertEquals(6, territory.numOccupyingArmies());
        territory.removeArmies(3);
        assertEquals(3, territory.numOccupyingArmies());
        territory.removeArmies(1);
        assertEquals(2, territory.numOccupyingArmies());
        territory.removeArmies(2);
        assertEquals(0, territory.numOccupyingArmies());
        assertFalse(territory.hasOccupanyingArmies());
    }

    @Test(expected = Exception.class)
    public void cantSetOccupantWithZeroArmies() {
        territory.setOccupant(new Player("test"), 0);
    }

    @Test(expected = Exception.class)
    public void cantSetOccupantWithNegativeArmies() {
        territory.setOccupant(new Player("test"), -3);
    }
}