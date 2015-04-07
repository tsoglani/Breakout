/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class PlayerRectangle extends Rectangle {

    BallThread thread;
    private int windowWidth;
    private int windowHeight;

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public PlayerRectangle(int windowWidth, int windowHeightn, BallThread thread) {
        this.thread = thread;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.x = 250;
    }

    public PlayerRectangle(BallThread thread) {
        this.x = 250;
        this.thread = thread;
    }
// koitazei se poio simeio tha xtypisei kai tha kanei analogi troxia

    public int whereToGO() {
        int speed = 1;

        if (this.x + width / 2 - width / 5 < BallThread.findBallAtPlayerRectangleX && BallThread.findBallAtPlayerRectangleX < this.x + (this.width) / 2 + (this.width) / 5) {
            speed = 0;
            System.out.println("center");
        } else if (this.x + width / 2 - width / 5 > BallThread.findBallAtPlayerRectangleX) {
            thread.setGoLeft(true);
            thread.setGoRight(false);
        } else if (BallThread.findBallAtPlayerRectangleX > this.x + (this.width) / 2 + (this.width) / 5) {
            thread.setGoLeft(false);
            thread.setGoRight(true);
        }
        return speed;
    }
}
