import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -7345584782743894712L;

    Image image;
    // JPanel gamePanel = new JPanel();
    JFrame frame = new JFrame("~~~~~~~~~~~~~~~~~~~COLLISION-GAME~~~~~~~~~~~~~~~~~~");
    Graphics graphics;
    Box player;
    Box enemy;
    Box enemy1;
    Box enemy2;
    Box enemy3;
    Box enemy4;
    Box enemy5;
    Box enemy6;
    Box enemy7;
    Box win;
    // Box enemy9;
    boolean gameOver, wingame;

    MyFrame() {

        player = new Box(100, 600, 50, 50, new Color(201, 46, 80));
        enemy = new Box(0, 20, 700, 50, Color.black);
        enemy1 = new Box(0, 0, 50, 800, Color.black);
        enemy2 = new Box(0, 700, 750, 50, Color.black);
        enemy3 = new Box(460, 0, 150, 300, Color.black);
        enemy4 = new Box(540, 450, 60, 350, Color.black);
        enemy5 = new Box(200, 150, 50, 700, Color.black);
        enemy6 = new Box(350, 0, 50, 600, Color.black);
        enemy7 = new Box(470, 350, 70, 350, Color.black);
        win = new Box(540, 400, 60, 50, new Color(51, 199, 46));
        // enemy9 = new Box(200,150,50,700,Color.black);
        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new AL());
        this.setBackground(new Color(156, 255, 233));
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this);

        player.draw(g);
        enemy.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        enemy3.draw(g);
        enemy4.draw(g);
        enemy5.draw(g);
        enemy6.draw(g);
        enemy7.draw(g);
        win.draw(g);
        // enemy9.draw(g);

        if (gameOver) {

            g.setColor(Color.RED);
            g.setFont(new Font("ARIEL", Font.BOLD, 100));
            g.drawString("GAME OVER!", 0, 300);
            // int a = JOptionPane.showConfirmDialog(MyFrame.this, "Are you sure?");
            // if (a == JOptionPane.YES_OPTION) {
            // JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
            // System.exit(0);
            // }
            String[] options = { "RESTART", "END GAME", "MENU" };

            int x = JOptionPane.showOptionDialog(null, "GAME OVER!!!", "Click a button", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            System.out.println(x);

            if (x == 0) {
                this.dispose();
                new MyFrame();
            }

            if (x == 1) {
                JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
                System.exit(0);
            }

            if (x == 2) {
                JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
                this.dispose();
                new Menu();

            }
        }

        if (wingame) {

            g.setColor(Color.green);
            g.setFont(new Font("ARIEL", Font.BOLD, 100));
            g.drawString("YOU WON!!", 30, 300);
            // int a = JOptionPane.showConfirmDialog(MyFrame.this, "Are you sure?");
            // if (a == JOptionPane.YES_OPTION) {
            // JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
            // System.exit(0);
            // }
            String[] options = { "RESTART", "END GAME", "MENU" };

            int x = JOptionPane.showOptionDialog(null, "YOU WON!!!", "Click a button", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            System.out.println(x);

            if (x == 0) {
                this.dispose();
                new MyFrame();
            }

            if (x == 1) {
                JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
                System.exit(0);
            }

            if (x == 2) {
                JOptionPane.showMessageDialog(MyFrame.this, "GOOD GAME!! -BYEEE!! :(");
                this.dispose();
                new Menu();
            }
        }

    }

    public void checkCollision() {
        if (player.intersects(enemy)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy1)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy2)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy3)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy4)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy5)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy6)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(enemy7)) {
            gameOver = true;
            // System.out.println("GAME OVER!");
        }
        if (player.intersects(win)) {
            wingame = true;

        }
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            checkCollision();
            repaint();
        }
    }
}