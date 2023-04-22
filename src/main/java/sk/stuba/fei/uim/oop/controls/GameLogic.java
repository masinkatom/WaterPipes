package sk.stuba.fei.uim.oop.controls;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.Field;
import sk.stuba.fei.uim.oop.board.Tile;

public class GameLogic extends UniversalAdapter{

    private Window mainFrame;
    @Getter
    private Field playField;
    private int fieldSize;
    @Getter
    JButton btnReset;
    @Getter
    JButton btnRoute;
    @Getter
    JTextField level;
    @Getter @Setter
    private int levelCount;

    public GameLogic(Window mainFrame) {
        this.mainFrame = mainFrame;
        this.fieldSize = 8;
        this.btnReset = new JButton("Reset");
        this.btnRoute = new JButton("Check route");
        this.level = new JTextField("Level: ");
        this.gameRestart();
    }

    private void gameRestart() {
        if (this.playField != null){
            this.mainFrame.remove(this.playField);
        }
        this.initField();
        this.levelCount = 1;
        this.updateLevelCount();
        this.mainFrame.add(this.playField);
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
        
    }

    private void initField(){
        this.playField = new Field(this.fieldSize);
        this.playField.addMouseMotionListener(this);
        this.playField.addMouseListener(this);
    }

    private void updateLevelCount(){
        level.setText("Level: " + this.levelCount + " (" + this.fieldSize + "x" + this.fieldSize + ")");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                System.out.println("ESC");
                mainFrame.dispose();
                System.exit(0);

            case KeyEvent.VK_R:
                System.out.println("R");
                this.gameRestart();
                break;

            case KeyEvent.VK_ENTER:
                System.out.println("ENTER");
                // TODO kontrola cesty
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnReset){
            System.out.println("Reset");
            this.gameRestart();
        }
        else {
            System.out.println("Route");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(((JSlider)(e.getSource())).getValue());
        this.fieldSize = ((JSlider)(e.getSource())).getValue();
        this.gameRestart();    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Component currComponent = this.playField.getComponentAt(e.getPoint());
        if (currComponent instanceof Tile){
            ((Tile) currComponent).setToHighlight(true);
        }
        this.playField.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component currComponent = this.playField.getComponentAt(e.getPoint());
        
        if (currComponent instanceof Tile){
            ((Tile) currComponent).rotate();
        }
        
        this.playField.revalidate();
        this.playField.repaint();
    }

    
    
    


    
    


}
