package sk.stuba.fei.uim.oop.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tile extends JPanel {

    private boolean toHighlight;
    private boolean toRotate;
    private ArrayList<Integer> facing;
    private BufferedImage picture;
    private boolean visited;
    private int xPos;
    private int yPos;

    private JLabel label;

    public Tile(int x, int y) {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        this.visited = false;
        facing = new ArrayList<Integer>();
        this.xPos = x;
        this.yPos = y;
        label = new JLabel();
        this.add(label);
        label.setVisible(true);
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

    public void rotate(){
    }
    
    public void changeFacing(){
        int i = 0;
        for (Integer face : facing) {
            if (face >= 4){
                face = 1;
            }
            else {
                face ++;
            }
            this.facing.set(i, face);
            i++;
        }
       
        
    }

    public int getAngle(){
        switch(this.getFacing().get(0)){
            case 2: return 270;
            case 1: return 180;
            case 4: return 90;
            default: return 0;
        }
    }
    
}
