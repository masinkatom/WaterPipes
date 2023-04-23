package sk.stuba.fei.uim.oop.board.pipes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import sk.stuba.fei.uim.oop.board.Tile;

public class StartPipe extends Tile{
    
    public StartPipe(int x, int y, int facing){
        super(x, y);
        try {
            setPicture(ImageIO.read(StartPipe.class.getResourceAsStream("/pipe-start.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getFacing().add(0, facing);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).rotate(Math.toRadians(getAngle()), getWidth() /2, getHeight() / 2);
        g.drawImage(getPicture(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void rotate() {
        
    }

    @Override
    public int getAngle(){
        switch(this.getFacing().get(0)){
            case 1: return 270;
            case 4: return 180;
            case 3: return 90;
            default: return 0;
        }
    }

    
}
