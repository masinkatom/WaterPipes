package sk.stuba.fei.uim.oop.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tile extends JPanel {

    private boolean toHighlight;
    private boolean toRotate;
    private int facing;
    private BufferedImage picture;

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

    public void rotate(){
    }

    public BufferedImage rotateImg(){
        int width = picture.getWidth();
        int height = picture.getHeight();

        BufferedImage newImage = new BufferedImage(picture.getWidth(), picture.getHeight(), picture.getType());

        //Graphics2D g2 = newImage.createGraphics();

        //g2.rotate(Math.toRadians(90), width / 2, height / 2);
        //g2.drawImage(picture, null, 0, 0);

        return newImage;
    }
    
    public void changeFacing(){
        if (this.facing >= 4){
            this.facing = 1;
        }
        else this.facing ++;
        
    }
}
