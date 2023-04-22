package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class StraightPipe extends Tile{

    BufferedImage pic;
    
    public StraightPipe(){
        try {
            this.pic = ImageIO.read(StraightPipe.class.getResourceAsStream("/pipe-straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.pic, 0, 0, getWidth(), getHeight(), this);
    }
    
}
