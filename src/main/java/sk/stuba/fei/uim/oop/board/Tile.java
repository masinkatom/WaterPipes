package sk.stuba.fei.uim.oop.board;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Tile extends JPanel{

    public Tile() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
    }
    
}
