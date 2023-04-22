package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class StartPipe extends Tile{
    
    public StartPipe(int facing){
        try {
            setPicture(ImageIO.read(StartPipe.class.getResourceAsStream("/pipe-start.png")));
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
        
    }

    @Override
    public BufferedImage rotateImg() {
        return null;
    }

    
}
