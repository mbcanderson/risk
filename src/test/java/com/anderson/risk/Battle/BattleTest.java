package com.anderson.risk.Battle;

import com.anderson.risk.Player;
import com.anderson.risk.Territory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class BattleTest {

    private Territory territory(String playerName, int numArmies) {
        Territory territory = new Territory();
        territory.setOccupant(new Player(playerName), numArmies);
        return territory;
    }

    private Battle battle(int numAttackingArmies, int numDefendingArmies) {
       return new Battle(territory("Attacker", numAttackingArmies), territory("Defender", numDefendingArmies));
    }

    @Test
    public void showAttackingDialog() {
        Battle battle = battle(5, 3);
        battle.showAttackingDialog();
    }

    @Test
    public void showDefendingDialog() {
        Battle battle = battle(5, 3);
        battle.showDefendingDialog();
    }

    @Test
    public void integrationTest() throws InterruptedException {
        Battle battle = battle(5, 3);
        battle.roll();
        Thread.sleep(100000);
    }
}