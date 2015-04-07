/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Fr extends JFrame {

    Pa panel;

    public Fr() {
        super();


        this.setSize(500, 600);

        this.addKeyListener(key);
        this.setFocusable(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel = new Pa();
        
        this.add(panel, BorderLayout.CENTER);
      
        this.setVisible(true);
    }
    KeyListener key = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (panel.getPlayer().x + 5 < panel.getWidth() - 75) {
                    panel.getPlayer().x += 5;
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                if (panel.getPlayer().x - 5 >= 0) {
                    panel.getPlayer().x -= 5;
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                panel.getPlayer().y++;
            }
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                panel.getPlayer().y++;
            }

            panel.repaint();
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };
}
