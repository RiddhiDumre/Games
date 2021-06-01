import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu implements ActionListener {
    JFrame frame = new JFrame("~~~~~~~~~~~~~Menu~~~~~~~~~~~C022-RIDDHI DUMRE~~~~~~~~~~~");
    JTextArea info = new JTextArea();
    JLabel head = new JLabel();
    JButton tictactoe = new JButton("TIC-TAC-TOE");
    JButton collision = new JButton("COLLISION");
    JButton endbButton = new JButton("CLOSE");

    public static void main(String[] args) {

        new Menu();
        // new TicTacToe();
        // new MyFrame();
    }

    Menu() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 750);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BorderLayout());
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridLayout(6, 1, 0, 20));
        frame.add(head, BorderLayout.NORTH);
        frame.add(info, BorderLayout.CENTER);

        head.setBackground(Color.black);
        head.setForeground(new Color(156, 255, 233));
        head.setFont(new Font("Ariel", Font.BOLD, 50));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setText("MENU");
        head.setOpaque(true);

        frame.add(tictactoe);
        frame.add(collision);
        frame.add(endbButton);

        tictactoe.setBackground(new Color(156, 255, 233));
        tictactoe.setForeground(Color.black);
        tictactoe.setFont(new Font("Ariel", Font.BOLD, 50));
        tictactoe.setFocusable(false);
        tictactoe.addActionListener(this);

        collision.setBackground(new Color(156, 255, 233));
        collision.setForeground(Color.black);
        collision.setFont(new Font("Ariel", Font.BOLD, 50));
        collision.setFocusable(false);
        collision.addActionListener(this);

        endbButton.setBackground(new Color(201, 46, 80));
        endbButton.setForeground(Color.black);
        endbButton.setFont(new Font("Ariel", Font.BOLD, 50));
        endbButton.setFocusable(false);
        endbButton.addActionListener(this);

        info.setBackground(Color.black);
        info.setForeground(new Color(156, 255, 233));
        info.setFont(new Font("Ariel", Font.PLAIN, 20));
        // info.setHorizontalAlignment(JLabel.CENTER);
        info.setText(
                "                    WELCOME TO THE GAME THE MENU!!\n        CLICK ON THE GAME YOU WOULD LIKE TO PLAY!!\n\n                                OR CLOSE THE MENU");
        info.setOpaque(true);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tictactoe) {

            frame.dispose();
            new TicTacToe();
        }
        if (e.getSource() == collision) {

            frame.dispose();
            new MyFrame();
        }

        if (e.getSource() == endbButton) {

            int a = JOptionPane.showConfirmDialog(frame, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {

                System.exit(0);
            }

            else if (a == JOptionPane.NO_OPTION) {
                frame.dispose();
                new Menu();
            }

            else {
                System.exit(0);
            }

        }

    }
}
