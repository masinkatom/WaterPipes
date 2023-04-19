package sk.stuba.fei.uim.oop.game;

import javax.swing.*;

import sk.stuba.fei.uim.oop.board.Field;

import java.awt.*;

public class Game {

    public Game() {
        JFrame mainFrame = new JFrame("Water Pipes");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(900,500);
        mainFrame.setResizable(false);
        mainFrame.setBackground(Color.white);
        
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

        mainFrame.setLayout(new GridLayout(0, 2, 20, 0));
        mainFrame.add(sideMenu, BorderLayout.WEST);
        mainFrame.add(tileField);
        mainFrame.setVisible(true);
    }
    
}
