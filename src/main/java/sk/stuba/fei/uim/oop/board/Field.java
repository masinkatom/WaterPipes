package sk.stuba.fei.uim.oop.board;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

public class Field extends JPanel{

    @Getter @Setter
    private int fieldSize;
    private ArrayList<ArrayList<Tile>> tiles;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        this.createField();

    }
    
    private void createField(){
        tiles = new ArrayList<ArrayList<Tile>>();
        this.setLayout(new GridLayout(fieldSize, fieldSize));
        for (int i = 0; i < this.fieldSize; i++) {
            this.tiles.add(new ArrayList<Tile>());
            for (int j = 0; j < this.fieldSize; j++) {
                this.tiles.get(i).add(new Tile());
                this.add(this.tiles.get(i).get(j));
            }
        }
    }
}
