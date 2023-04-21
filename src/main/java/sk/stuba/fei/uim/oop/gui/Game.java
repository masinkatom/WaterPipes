package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;

import java.awt.*;

import sk.stuba.fei.uim.oop.controls.GameLogic;

public class Game {
    

    public Game() {
        Window mainFrame = new Window("Water Pipes");

        GameLogic gameLogic = new GameLogic(mainFrame);
        mainFrame.addKeyListener(gameLogic);

        gameLogic.getBtnReset().setBackground(Color.white);
        gameLogic.getBtnReset().addActionListener(gameLogic);
        gameLogic.getBtnReset().setFocusable(false);

        gameLogic.getBtnRoute().setBackground(Color.WHITE);
        gameLogic.getBtnRoute().addActionListener(gameLogic);
        gameLogic.getBtnRoute().setFocusable(false);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8, 12, 8);
        slider.setMajorTickSpacing(2);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.setBackground(Color.WHITE);
        slider.addChangeListener(gameLogic);

        gameLogic.getLevel().setEditable(false);
        gameLogic.getLevel().setBorder(null);
        gameLogic.getLevel().setHorizontalAlignment(JTextField.CENTER);
        gameLogic.getLevel().setFocusable(false);
        gameLogic.getLevel().setBackground(Color.WHITE);
        gameLogic.getLevel().setFont(new Font("Monospaced", Font.BOLD, 30));

        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new GridLayout(4, 1));
        sideMenu.add(gameLogic.getBtnReset());
        sideMenu.add(gameLogic.getBtnRoute());
        sideMenu.add(slider);
        sideMenu.add(gameLogic.getLevel());

        mainFrame.add(sideMenu);
        mainFrame.add(gameLogic.getPlayField());
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }
    
}
