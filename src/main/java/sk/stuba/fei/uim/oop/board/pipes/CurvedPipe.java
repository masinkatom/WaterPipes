package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class CurvedPipe extends Tile{
    
    public CurvedPipe(int facing){
        try {
            setPicture(ImageIO.read(CurvedPipe.class.getResourceAsStream("/pipe-angled.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setFacing(facing);
    }

    @Override
    public void rotate() {
        System.out.println("ahoj curved pipe");
        this.setToRotate(true);
        this.changeFacing();
        this.rotateImg();
        super.rotate();
    }

    @Override
    public BufferedImage rotateImg() {
        if (this.isToRotate()){
            this.setToRotate(false);
            return super.rotateImg();
        }
        return this.getPicture();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).rotate(Math.toRadians(getAngle()), getWidth() /2, getHeight() / 2);
        g.drawImage(rotateImg(), 0, 0, getWidth(), getHeight(), this);

    }

    private int getAngle(){
        switch(this.getFacing()){
            case 2: return 270;
            case 1: return 180;
            case 4: return 90;
            default: return 0;
        }
    }
    
}
