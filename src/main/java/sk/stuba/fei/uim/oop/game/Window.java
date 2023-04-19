package sk.stuba.fei.uim.oop.game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
    
    public Window(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,500);
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(0, 2, 20, 0));
    }
}
