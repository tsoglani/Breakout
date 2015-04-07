/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class RectanglesToBreak extends Rectangle {

    private int chooseColor;
    int numberOfRec;
    private Color[] color = {Color.red, Color.ORANGE, Color.WHITE, Color.YELLOW, Color.CYAN};

    public Color[] getColor() {
        return color;
    }

    public int getChooseColor() {
        return chooseColor;
    }

    public void setChooseColor(int chooseColor) {
        this.chooseColor = chooseColor;
    }

    public void setColor(Color[] color) {
        this.color = color;
    }

    public RectanglesToBreak() {
        super();

        chooseColor = (int) (Math.random() * color.length);

    }

    public RectanglesToBreak(int number) {
        super();
        numberOfRec = number;

        chooseColor = (int) (Math.random() * color.length);

    }

    public void putRecInSpace(int width, int height) {
        if (numberOfRec < 6) {
            this.setLocation((numberOfRec) * width / 6, 50);
        } else if (numberOfRec < 12) {

            int putting = numberOfRec - 6;
            this.setLocation(putting * width / 6, 100);
        } else if (numberOfRec < 18) {
            int putting = numberOfRec - 12;
            this.setLocation(putting * width / 6, 150);
        } else if (numberOfRec < 24) {
            int putting = numberOfRec - 18;
            this.setLocation(putting * width / 6, 200);
        } else {

            System.out.println("Game Is Over");
        }

        this.setSize(width / 7, height / 40);


    }
}
