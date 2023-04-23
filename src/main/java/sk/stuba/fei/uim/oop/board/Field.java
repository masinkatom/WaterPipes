package sk.stuba.fei.uim.oop.board;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.pipes.CurvedPipe;
import sk.stuba.fei.uim.oop.board.pipes.EndPipe;
import sk.stuba.fei.uim.oop.board.pipes.StartPipe;
import sk.stuba.fei.uim.oop.board.pipes.StraightPipe;

public class Field extends JPanel{

    @Getter @Setter
    private int fieldSize;
    private ArrayList<ArrayList<Tile>> tiles;
    private int[] startXY;
    private int[] endXY;
    private static final int NORTH = 2;
    private static final int SOUTH = 4;
    private static final int EAST = 3;
    private static final int WEST = 1;
    private Random ran;
    private boolean foundEnd = false;
    private Tile prevPipe;
    int k = 0;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        ran = new Random();
        this.createField();
        this.generateRoute();
        this.addTiles();
    }
    
    private void createField(){
        this.tiles = new ArrayList<ArrayList<Tile>>();
        this.setLayout(new GridLayout(fieldSize, fieldSize));

        for (int i = 0; i < this.fieldSize; i++) {
            this.tiles.add(new ArrayList<Tile>());

            for (int j = 0; j < this.fieldSize; j++) {
                this.tiles.get(i).add(new Tile(j, i));
                
                this.add(this.tiles.get(i).get(j));
            }
        }
        
        this.getStartEndXY();

        //this.tiles.get(0).set(5, new CurvedPipe(5, 0, WEST));
        this.tiles.get(this.endXY[1]).set(this.endXY[0], new EndPipe(this.endXY[0], this.endXY[1], EAST));
        this.tiles.get(this.startXY[1]).set(this.startXY[0], new StartPipe(this.startXY[0], this.startXY[1], EAST));

        
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
        if (coordinate == EAST){
            startXY[0] = this.fieldSize-1;
            startXY[1] = (int)(Math.random() * (this.fieldSize));
            endXY[0] = 0;
            endXY[1] = (int)(Math.random() * (this.fieldSize));
        }
        else if (coordinate == SOUTH){
            startXY[0] = (int)(Math.random() * (this.fieldSize));
            startXY[1] = this.fieldSize-1;
            endXY[0] = (int)(Math.random() * (this.fieldSize));
            endXY[1] = 0;
        }
        else if (coordinate == WEST){
            startXY[0] = 0;
            startXY[1] = (int)(Math.random() * (this.fieldSize));
            endXY[0] = this.fieldSize-1;
            endXY[1] = (int)(Math.random() * (this.fieldSize));
        }
        else if (coordinate == NORTH){
            startXY[0] = (int)(Math.random() * (this.fieldSize));
            startXY[1] = 0;
            endXY[0] = (int)(Math.random() * (this.fieldSize));
            endXY[1] = this.fieldSize-1;
        }
    }

    private void generateRoute() {
        Tile start = tiles.get(startXY[1]).get(startXY[0]);

        rdfs(start);
        if (this.foundEnd != true){
            //createField();
            //generateRoute();
        }
        
    }

    private void rdfs(Tile currentTile) {
        k++;
        currentTile.setVisited(true);
        Tile nextTile = getUnvisitedNeighbor(currentTile);
        
        while (nextTile != null) {
            if (foundEnd == true){
                break;
            }
            
            //currentTile.getLabel().setText(currentTile.getXPos()+":::"+currentTile.getYPos() + ">" + k);
            this.foundEnd = this.connectPipe(currentTile, nextTile);
            //currentTile.setBackground(Color.yellow);
            
            rdfs(nextTile);
            if (nextTile.isVisited()){
                nextTile = getUnvisitedNeighbor(currentTile);
            }
        }
        
        
    }

    private boolean connectPipe(Tile currentTile, Tile nextTile){
        int x = currentTile.getXPos();
        int y = currentTile.getYPos();
        if (currentTile instanceof StartPipe){
            ((StartPipe) currentTile).getFacing().add(0, getDirection(currentTile, nextTile));
            ((StartPipe) currentTile).getFacing().add(0, getDirection(currentTile, nextTile));
            prevPipe = currentTile;
            return false;
        }
        else if (currentTile instanceof EndPipe){
            ((EndPipe) currentTile).getFacing().add(0, getDirection(currentTile, prevPipe));
            ((EndPipe) currentTile).getFacing().add(0, getDirection(currentTile, prevPipe));
            return true;
            
        }
        
        else {
            int facingPrev = getDirection(currentTile, prevPipe);
            int facingNext = getDirection(currentTile, nextTile);
            System.out.println("currPos " + currentTile.getXPos() + ":" + currentTile.getYPos());
            System.out.println("prev:" +facingPrev+ " next: " +facingNext);
            if (Math.abs(facingPrev - facingNext) == 2 && facingPrev != 0){
                StraightPipe sp = new StraightPipe(x, y, facingNext);
                sp.getFacing().add(facingPrev);
                this.tiles.get(y).set(x, sp);
            }
            else {
                CurvedPipe cp = new CurvedPipe(x, y, facingNext);
                cp.getFacing().add(facingPrev);
                this.tiles.get(y).set(x, cp);
                
            }
            
        }
        prevPipe = this.tiles.get(y).get(x);
        
        return false;
    }

    private Tile getUnvisitedNeighbor(Tile tile) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        int y = tile.getXPos();
        int x = tile.getYPos();

        if (x > 0 && !tiles.get(x-1).get(y).isVisited()) {
            neighbors.add(tiles.get(x-1).get(y));
        }
        if (x < fieldSize - 1 && !tiles.get(x+1).get(y).isVisited()) {
            neighbors.add(tiles.get(x+1).get(y));
        }
        if (y > 0 && !tiles.get(x).get(y-1).isVisited()) {
            neighbors.add(tiles.get(x).get(y-1));
        }
        if (y < fieldSize - 1 && !tiles.get(x).get(y+1).isVisited()) {
            neighbors.add(tiles.get(x).get(y+1));
        }

        for (Tile tile2 : neighbors) {
            if (tile2 instanceof EndPipe){
                return tile2;
            }
        }

        if (neighbors.isEmpty()){
            return null;
        }

        Collections.shuffle(neighbors, ran);
        return neighbors.get(0);
    }

    private int getDirection(Tile currentTile, Tile nextTile){
        int nextX = nextTile.getXPos();
        int nextY = nextTile.getYPos();
        int currX = currentTile.getXPos();
        int currY = currentTile.getYPos();

        if (nextX < currX && nextY == currY){
            return WEST;
        }
        if (nextX == currX && nextY < currY){
            return NORTH;
        } 
        if (nextX > currX && nextY == currY){
            return EAST;
        } 
        if (nextX == currX && nextY > currY){
            return SOUTH;
        } 
        return 0;
    }

    public boolean checkRoute(){
        Tile start = tiles.get(startXY[1]).get(startXY[0]);
        Tile nextTile = findConnected(start);
        while (!(nextTile instanceof EndPipe)){
            Tile currTile = nextTile;
            if (currTile == null){
                return false;
            }
            nextTile = findConnected(currTile);

        }
        return true;
    }

    private Tile findConnected(Tile currTile){
        int to;
        int x = currTile.getXPos();
        int y = currTile.getYPos();

        to = currTile.getFacing().get(0);

        switch (to){
            case WEST:
                x --;
                break;
            case NORTH:
                y --;
                break;
            case EAST:
                x ++;
                break;
            case SOUTH:
                y ++;
                break;
        }
        if (x == fieldSize || y == fieldSize || x < 0 || y < 0){
            return null;
        }
        this.tiles.get(y).get(x).setBackground(Color.BLUE);
        return this.tiles.get(y).get(x);

        
    }


    


}
