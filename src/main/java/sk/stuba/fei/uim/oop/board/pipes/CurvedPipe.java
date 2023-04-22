package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class CurvedPipe extends Tile{

    BufferedImage pic;
    
    public CurvedPipe(){
        try {
            this.pic = ImageIO.read(CurvedPipe.class.getResourceAsStream("/pipe-angled.png"));
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
