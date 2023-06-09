package celeste.GUI.Drawables;

/*
 * Contains information and methods for the background of the GUI.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import celeste.GUI.GlobalState;

public class Background extends Drawable {
    private Graphics2D g2;

    static int STAR_COUNT = 500;
    static int[] STAR_SIZES = new int[500];
    static int[][] starPositions = new int[STAR_COUNT][3];
    static { // Creates stars at specific positions
        for (int i = 0; i < STAR_COUNT; i++) {
            starPositions[i][0] = (int) (Math.random() * GlobalState.FRAME_WIDTH);
            starPositions[i][1] = (int) (Math.random() * GlobalState.FRAME_HEIGHT);
            starPositions[i][2] = (int) (Math.random() * 200);

            STAR_SIZES[i] = (int) (Math.random() * 2 + 2 + starPositions[i][2] / 255 * 2);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        this.g2 = (Graphics2D) g;

        this.draw(g2);
    }

    public void draw(Graphics2D g2) {
        drawSpace();
        drawStars();
    }

    // Draws the color of the background of the GUI
    public void drawSpace() {
        // set HEX color
        g2.setColor(Color.decode("#000"));
        g2.fillRect(0, 0, GlobalState.FRAME_WIDTH, GlobalState.FRAME_HEIGHT);
    }

    // Draws the stars in the bacground of the GUI
    public void drawStars() {
        // set HEX color
        for (int i = 0; i < STAR_COUNT; i++) {
            g2.setColor(new Color(255, 255, 255, starPositions[i][2]));
            g2.fillOval(starPositions[i][0], starPositions[i][1], STAR_SIZES[i], STAR_SIZES[i]);
        }
    }
}
