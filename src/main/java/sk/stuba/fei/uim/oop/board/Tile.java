package sk.stuba.fei.uim.oop.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tile extends JPanel {

    private boolean toHighlight;
    private int north;
    private int south;
    private int east;
    private int west;

    public Tile() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.toHighlight){
            g.setColor(Color.RED);
            ((Graphics2D) g).setStroke(new BasicStroke(8));
            g.drawRect(0, 0, this.getWidth(), this.getHeight());
            this.toHighlight = false;
        }
    }

    
    
}
