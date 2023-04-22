package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class StraightPipe extends Tile{

    public StraightPipe(int facing){
        try {
            setPicture(ImageIO.read(StraightPipe.class.getResourceAsStream("/pipe-straight.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setFacing(facing);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getPicture(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void rotate() {
        this.setToRotate(true);
        this.changeFacing();
        this.rotateImg();
    }

    @Override
    public BufferedImage rotateImg() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
