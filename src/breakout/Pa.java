/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Pa extends JPanel {

    private int numbersOfBricksforEachLevel = 15;
    private BallThread thread;
    private PlayerRectangle player;
    private ArrayList<RectanglesToBreak> bricks = new ArrayList<RectanglesToBreak>();
    private int row = 250;
    private Rectangle ballRec = new Rectangle(100, 200, 20, 20);

    public Pa() {
        this.setSize(500, 600);


        this.setFocusable(false);
        intialize(numbersOfBricksforEachLevel);
        ballRec.x = 100;
        ballRec.y = 200;
        thread = new BallThread(this);
        thread.start();
        player = new PlayerRectangle(thread);
        player.x = 250;
    }

    public int getNumbersOfBricksforEachLevel() {
        return numbersOfBricksforEachLevel;
    }

    public void setNumbersOfBricksforEachLevel(int numbersOfBricksforEachLevel) {
        this.numbersOfBricksforEachLevel = numbersOfBricksforEachLevel;
    }

    public int getRow() {
        return row;
    }

    public Rectangle getBallRec() {
        return ballRec;
    }

    public void setBallRec(Rectangle ballRec) {
        this.ballRec = ballRec;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public PlayerRectangle getPlayer() {
        return player;
    }

    public void setPlayer(PlayerRectangle player) {
        this.player = player;
    }

    public ArrayList getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList bricks) {
        this.bricks = bricks;
    }

    public void intialize(int numbersOfBrick) {
        for (int i = 0; i < numbersOfBrick; i++) {
            addToRectanglesToBreak(i);
        }
    }

    public void addToRectanglesToBreak(int num) {
        RectanglesToBreak rtb = new RectanglesToBreak(num);

        bricks.add(rtb);
        rtb = null;
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setColor(Color.BLUE);
        player.setSize(this.getWidth() / 6, this.getHeight() / 35);
        player.setLocation(player.x, this.getHeight() - 50);
        g.fill(player);
        for (int i = 0; i < bricks.size(); i++) {
            bricks.get(i).putRecInSpace(this.getWidth(), this.getHeight());
            g.setColor(bricks.get(i).getColor()[ bricks.get(i).getChooseColor()]);
            g.fill(bricks.get(i));

            g.setColor(Color.black);

            g.drawLine(bricks.get(i).getLocation().x, bricks.get(i).getLocation().y, bricks.get(i).getLocation().x, bricks.get(i).getLocation().y + (int) bricks.get(i).getHeight());
            g.drawLine(bricks.get(i).getLocation().x + (int) bricks.get(i).getWidth(), bricks.get(i).getLocation().y, bricks.get(i).getLocation().x + (int) bricks.get(i).getWidth(), bricks.get(i).getLocation().y + (int) bricks.get(i).getHeight());

        }
        g.setColor(Color.black);
        g.fillOval(ballRec.x, ballRec.y, 20, 20);
//        g.drawString("P", player.x + (player.width) / 2 + (player.width) / 5, player.y);
//        g.drawString("P", player.x + player.width / 2 - (player.width) / 5, player.y);
        // g.draw(ballRec);
    }
}
