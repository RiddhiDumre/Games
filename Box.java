import java.awt.*;
import java.awt.event.*;

public class Box extends Rectangle {

    /**
     *
     */
    private static final long serialVersionUID = -7345584782743894712L;
    Color color;

    Box(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.y = y - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.y = y + 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.x = x - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.x = x + 10;
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}