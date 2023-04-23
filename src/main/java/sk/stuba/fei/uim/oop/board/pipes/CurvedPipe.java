package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class CurvedPipe extends Tile{
    
    public CurvedPipe(int x, int y, int facing){
        super(x, y);
        try {
            setPicture(ImageIO.read(CurvedPipe.class.getResourceAsStream("/pipe-angled.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisited(true);
        this.getFacing().add(0, facing);
    }

    @Override
    public void rotate() {
        System.out.println("ahoj curved pipe");
        this.setToRotate(true);
        this.changeFacing();
        super.rotate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).rotate(Math.toRadians(getAngle()), getWidth() /2, getHeight() / 2);
        g.drawImage(getPicture(), 0, 0, getWidth(), getHeight(), this);

    }
    
}
