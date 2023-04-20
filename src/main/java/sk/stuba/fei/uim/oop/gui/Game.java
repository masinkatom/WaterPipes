package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;

import sk.stuba.fei.uim.oop.board.Field;
import sk.stuba.fei.uim.oop.controls.GameLogic;

import java.awt.*;

public class Game {

    public Game() {
        Window mainFrame = new Window("Water Pipes");

        GameLogic gameLogic = new GameLogic();
        mainFrame.addKeyListener(gameLogic);
        
        Field tileField = new Field(8);

        JButton btnReset = new JButton("Reset");
        btnReset.setBackground(Color.white);

        JButton btnRoute = new JButton("Check route");
        btnRoute.setBackground(Color.white);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8, 16, 8);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(2);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.addChangeListener(null);

        JTextField level = new JTextField();
        level.setText("AHOJ !!!!");
        level.setEditable(false);
        level.setBorder(null);
        level.setHorizontalAlignment(JTextField.CENTER);
        level.setFont(new Font("Serif", Font.PLAIN, 20));

        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new GridLayout(2, 2));
        sideMenu.add(btnReset);
        sideMenu.add(btnRoute);
        sideMenu.add(slider);
        sideMenu.add(level);

        mainFrame.add(sideMenu, BorderLayout.WEST);
        mainFrame.add(tileField);
        mainFrame.setVisible(true);
    }
    
}
