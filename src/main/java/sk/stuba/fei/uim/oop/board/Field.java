package sk.stuba.fei.uim.oop.board;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.pipes.CurvedPipe;
import sk.stuba.fei.uim.oop.board.pipes.EndPipe;
import sk.stuba.fei.uim.oop.board.pipes.StartPipe;

public class Field extends JPanel{

    @Getter @Setter
    private int fieldSize;
    private ArrayList<ArrayList<Tile>> tiles;
    private int[] startXY;
    private int[] endXY;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        this.createField();
    }
    
    private void createField(){
        this.tiles = new ArrayList<ArrayList<Tile>>();
        this.setLayout(new GridLayout(fieldSize, fieldSize));

        for (int i = 0; i < this.fieldSize; i++) {
            this.tiles.add(new ArrayList<Tile>());

            for (int j = 0; j < this.fieldSize; j++) {
                this.tiles.get(i).add(new Tile());
                this.add(this.tiles.get(i).get(j));
            }
        }
        
        this.getStartEndXY();

        this.tiles.get(0).set(5, new CurvedPipe());
        this.tiles.get(this.endXY[1]).set(this.endXY[0], new EndPipe());
        this.tiles.get(this.startXY[1]).set(this.startXY[0], new StartPipe());

        this.addTiles();
    }

    private void addTiles(){
        this.removeAll();
        for (int i = 0; i < this.fieldSize; i++) {

            for (int j = 0; j < this.fieldSize; j++) {
                this.add(this.tiles.get(i).get(j));
            }
        }
    }

    private void getStartEndXY(){
        this.startXY = new int[2];
        this.endXY = new int[2];
        int coordinate = (int)(Math.random() * 4) + 1;
        if (coordinate == 1){
            startXY[0] = this.fieldSize-1;
            startXY[1] = (int)(Math.random() * (this.fieldSize));
            endXY[0] = 0;
            endXY[1] = (int)(Math.random() * (this.fieldSize));
        }
        else if (coordinate == 2){
            startXY[0] = (int)(Math.random() * (this.fieldSize));
            startXY[1] = this.fieldSize-1;
            endXY[0] = (int)(Math.random() * (this.fieldSize));
            endXY[1] = 0;
        }
        else if (coordinate == 3){
            startXY[0] = 0;
            startXY[1] = (int)(Math.random() * (this.fieldSize));
            endXY[0] = this.fieldSize-1;
            endXY[1] = (int)(Math.random() * (this.fieldSize));
        }
        else if (coordinate == 4){
            startXY[0] = (int)(Math.random() * (this.fieldSize));
            startXY[1] = 0;
            endXY[0] = (int)(Math.random() * (this.fieldSize));
            endXY[1] = this.fieldSize-1;
        }
    }


}
