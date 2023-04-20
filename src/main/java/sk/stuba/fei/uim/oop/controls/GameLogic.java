package sk.stuba.fei.uim.oop.controls;

import java.awt.event.KeyEvent;

public class GameLogic extends UniversalAdapter{

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                System.out.println("ESC");
                break;

            
        }
    }
    
    


}
