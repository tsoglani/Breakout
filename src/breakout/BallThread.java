/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class BallThread extends Thread {

    private Pa panel;
    private int sleepingBall = 8;
    private boolean goUp;
    private boolean goRight;
    private boolean goLeft = true;
    private boolean findAtTheSideOfRectangle = false;
    private int goWhere = 1;
    static int findBallAtPlayerRectangleX = 0;

    public boolean isGoLeft() {
        return goLeft;
    }

    public void setGoLeft(boolean goLeft) {
        this.goLeft = goLeft;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    public boolean isGoUp() {
        return goUp;
    }

    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }

    public BallThread(Pa panel) {
        this.panel = panel;
    }

    public int getSleepingBall() {
        return sleepingBall;
    }

    public void setSleepingBall(int sleepingBall) {
        this.sleepingBall = sleepingBall;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.sleep(sleepingBall);
                if (panel.getBallRec().intersects(panel.getPlayer())) {
                    goUp = true;
                    findBallAtPlayerRectangleX = panel.getBallRec().x + 5;

                    goWhere = panel.getPlayer().whereToGO();
                }
                if (panel.getBallRec().y <= 0) {
                    goUp = false;
                }
                if (panel.getBallRec().x <= 0) {
                    goLeft = false;
                    goRight = true;
                }
                if (panel.getBallRec().x >= panel.getWidth() - 20) {
                    goRight = false;
                    goLeft = true;

                }


                for (int i = 0; i < panel.getBricks().size(); i++) {
                    if (panel.getBallRec().intersects((Rectangle) panel.getBricks().get(i))) {
                        RectanglesToBreak bricks = (RectanglesToBreak) panel.getBricks().get(i);

                        if (panel.getBallRec().intersectsLine(bricks.getLocation().x, bricks.getLocation().y, bricks.getLocation().x, bricks.getLocation().y + (int) bricks.getHeight()) || panel.getBallRec().intersectsLine(bricks.getLocation().x + (int) bricks.getWidth(), bricks.getLocation().y, bricks.getLocation().x + (int) bricks.getWidth(), bricks.getLocation().y + (int) bricks.getHeight())) {
                            goLeft = !goLeft;
                            goRight = !goRight;

                        } else {
                            goUp = !goUp;
                        }
                        panel.getBricks().remove(i);

                    }
                }


                if (panel.getBallRec().y > panel.getHeight()) {
                    panel.getBallRec().y = 210;
                    panel.getBallRec().x = 200;
                    goUp = false;
                    goRight = true;
                    goLeft = false;
                    System.out.println("you lose 1 life ");
                }

                if (goUp) {
                    panel.getBallRec().y--;

                } else {
                    panel.getBallRec().y++;

                }
                if (goRight) {
                    panel.getBallRec().x += goWhere;
                }
                if (goLeft) {
                    panel.getBallRec().x -= goWhere;
                }
                if (panel.getBricks().isEmpty()) {
                    panel.setNumbersOfBricksforEachLevel(panel.getNumbersOfBricksforEachLevel() + 1);
                    panel.intialize(panel.getNumbersOfBricksforEachLevel());
                }

                panel.repaint();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
