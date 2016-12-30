package com.anderson.risk.Battle;

import javax.swing.*;
import java.awt.*;

import static com.anderson.risk.Util.FileUtil.iconFromImagesFile;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class RollWindow {

    private final JPanel attackPanel;
    private final JPanel defendPanel;

    private final JPanel panel;

    RollWindow() {
        this.panel = new JPanel(new GridBagLayout());
        this.attackPanel = new JPanel();
        attackPanel.setLayout(new BoxLayout(attackPanel, BoxLayout.PAGE_AXIS));
        this.defendPanel = new JPanel();
        defendPanel.setLayout(new BoxLayout(defendPanel, BoxLayout.PAGE_AXIS));
    }

    void display(int numAttackingLost, int numDefendingLost) {
        JFrame frame = new JFrame("Roll");
        setPanelLayout(numAttackingLost, numDefendingLost);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setSize(400, 600);
    }

    private void setPanelLayout(int numAttackingLost, int numDefendingLost) {
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel attackerLabel = new JLabel("Attacker");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(attackerLabel, constraints);

        JLabel blankLabel = new JLabel("                \n");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(blankLabel, constraints);

        constraints = new GridBagConstraints();
        JLabel defenderLabel = new JLabel("Defender");
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(defenderLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(attackPanel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(defendPanel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("The attacker loses: " + numAttackingLost), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(new JLabel("The defender loses: " + numDefendingLost), constraints);
    }

    void addAttackerDie(int value) {
        Icon icon = iconFromImagesFile("die" + value);
        attackPanel.add(new JLabel("        "));
        attackPanel.add(new JLabel(icon));
    }

    void addDefenderDie(int value) {
        Icon icon = iconFromImagesFile("die" + value);
        defendPanel.add(new JLabel("        "));
        defendPanel.add(new JLabel(icon));
    }

}
