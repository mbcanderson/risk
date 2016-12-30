package com.anderson.risk.Battle;

import com.anderson.risk.Player;
import com.anderson.risk.Territory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthewanderson on 12/30/16.
 */
public class BattleManagerTest {

    @Test
    public void integrationTest() {
        Territory attackingTerritory = new Territory();
        Territory defendingTerritoy = new Territory();
        attackingTerritory.setOccupant(new Player("attacker"), 10);
        defendingTerritoy.setOccupant(new Player("defender"), 6);
        BattleManager battleManager = new BattleManager(attackingTerritory, defendingTerritoy);
        battleManager.startBattle();
    }
}