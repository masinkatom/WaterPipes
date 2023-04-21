package sk.stuba.fei.uim.oop.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
    
    public Window(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,500);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setFocusable(true);
        this.setLayout(new GridLayout(1, 2, 10, 0));
    }
}
