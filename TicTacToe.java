import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = -2833724320363093774L;
	// TicTacToe game;
	Random random = new Random();
	JFrame frame = new JFrame("~~~~~~~~~~~~~~~~~~~~~CO22-RIDDHI DUMRE-TICTACTOE~~~~~~~~");
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel reset_panel = new JPanel();
	JLabel textfield = new JLabel();
	JLabel titlefield = new JLabel();
	JLabel playerfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton reset;
	JButton end;
	JButton Menu;
	boolean player1_turn;
	int ctr = 0;
	int i, n = 0;
	String p1;
	String p2;
	boolean flag = true;

	public static void main(String[] args) {

		new TicTacToe();

	}

	public void enter1() {

		p1 = JOptionPane.showInputDialog("ENTER PLAYER 1 NAME", "PLAYER 1");

		if (p1.isEmpty()) {
			JOptionPane.showMessageDialog(TicTacToe.this, "PLS ADD PLAYER 1's NAME");
			enter1();
			// System.exit(0);
		}
	}

	public void enter2() {

		p2 = JOptionPane.showInputDialog("ENTER PLAYER 2 NAME", "PLAYER 2");
		if (p2.isEmpty()) {
			JOptionPane.showMessageDialog(TicTacToe.this, "PLS ADD PLAYER 2's NAME");
			enter2();
			// System.exit(0);
		}

	}

	public void restart() {
		JOptionPane.showMessageDialog(TicTacToe.this, "GAME IS RESTARTED :)");
		frame.dispose();
		new TicTacToe();
	}

	public void EndGame() {
		int a = JOptionPane.showConfirmDialog(TicTacToe.this, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(TicTacToe.this, "GOOD GAME!! -BYEEE!! :(");
			System.exit(0);
		}

		else if (a == JOptionPane.NO_OPTION) {
			restart();
		}

		else {
			System.exit(0);
		}

	}

	TicTacToe() {

		enter1();
		enter2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 750);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		textfield.setBackground(new Color(38, 115, 103));
		textfield.setForeground(new Color(156, 255, 233));
		textfield.setFont(new Font("Ariel", Font.BOLD, 20));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);

		titlefield.setBackground(Color.black);
		titlefield.setForeground(new Color(156, 255, 233));
		titlefield.setFont(new Font("Ariel", Font.BOLD, 50));
		titlefield.setHorizontalAlignment(JLabel.CENTER);
		titlefield.setText("Tic-Tac-Toe");
		titlefield.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);

		button_panel.setLayout(new GridLayout(3, 3, 5, 5));
		button_panel.setBackground(Color.black);

		for (i = 0; i < 9; i++) {

			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setBackground(new Color(156, 255, 233));
			buttons[i].setFont(new Font("Ariel", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		Menu = new JButton("MENU");
		end = new JButton("END GAME");
		// end.setBounds(100, 350, 100, 50);
		// frame.add(end);

		end.setBackground(Color.black);
		end.setForeground(new Color(156, 255, 233));
		end.setFont(new Font("Ariel", Font.BOLD, 20));
		end.setFocusable(false);
		end.addActionListener(this);
		end.setSize(new Dimension(50, 10));

		// end_panel.setLayout(new BorderLayout());
		// end_panel.setBounds(0, 0, 800, 100);
		// end_panel.add(end);

		reset = new JButton("RESTART");

		reset_panel.setLayout(new BorderLayout());
		// reset.setBounds(100, 350, 100, 50);
		// frame.add(reset);
		reset_panel.add(reset, BorderLayout.NORTH);
		reset_panel.add(end, BorderLayout.CENTER);
		reset_panel.add(Menu, BorderLayout.SOUTH);
		frame.add(reset_panel, BorderLayout.SOUTH);
		reset.setBackground(Color.black);
		reset_panel.setBackground(Color.black);
		reset.setForeground(new Color(156, 255, 233));
		reset.setFont(new Font("Ariel", Font.BOLD, 20));
		reset.setFocusable(false);
		reset.addActionListener(this);

		Menu.setSize(new Dimension(50, 10));
		Menu.setBackground(Color.black);
		Menu.setForeground(new Color(156, 255, 233));
		Menu.setFont(new Font("Ariel", Font.BOLD, 20));
		Menu.setFocusable(false);
		Menu.addActionListener(this);
		Menu.setSize(new Dimension(50, 10));
		// // reset_panel.setLayout(new BorderLayout());
		// reset_panel.setBounds(0, 0, 0, 0);
		// reset_panel.add(reset);

		title_panel.add(textfield, BorderLayout.SOUTH);
		title_panel.add(titlefield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		firstTurn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == reset) {

			restart();
		}

		else if (e.getSource() == end) {

			EndGame();
		} else if (e.getSource() == Menu) {

			frame.dispose();
			new Menu();
		}

		else {
			for (i = 0; i < 9; i++) {
				if (e.getSource() == buttons[i]) {
					if (player1_turn) {
						if (buttons[i].getText() == "") {
							buttons[i].setForeground(new Color(201, 46, 80));
							buttons[i].setText("X");
							player1_turn = false;
							textfield.setText(p1 + "'s TURN");
							check();
						}
					} else {
						if (buttons[i].getText() == "") {

							buttons[i].setForeground(Color.black);
							buttons[i].setText("O");
							player1_turn = true;
							textfield.setText(p2 + "'s TURN");
							check();
						}
					}
					ctr++;
					// System.out.println(ctr);
				}
			}

		}
		if (ctr == 9) {
			Draw();
		}

	}

	public void firstTurn() {

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText(p2 + "'s TURN");
		} else {
			player1_turn = false;
			textfield.setText(p1 + "'s TURN");
		}
	}

	public void check() {
		// check X win conditions
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		// check O win conditions
		if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}

	}

	public void xWins(int a, int b, int c) {

		buttons[a].setBackground(new Color(102, 255, 156));
		buttons[b].setBackground(new Color(102, 255, 156));
		buttons[c].setBackground(new Color(102, 255, 156));

		for (i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText(p2 + " WINS!!");

		JOptionPane.showMessageDialog(TicTacToe.this, p2 + " !!! WON !!! \nCLICK RESET OR END GAME");
		flag = false;
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(new Color(102, 255, 156));
		buttons[b].setBackground(new Color(102, 255, 156));
		buttons[c].setBackground(new Color(102, 255, 156));

		for (i = 0; i < 9; i++) {

			buttons[i].setEnabled(false);
		}
		textfield.setText(p1 + " WINS!!");

		JOptionPane.showMessageDialog(TicTacToe.this, p1 + " !!! WON !!! \nCLICK RESET OR END GAME");
		flag = false;
	}

	public void Draw() {

		if (flag) {
			for (i = 0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("IT'S A DRAW!!");
			JOptionPane.showMessageDialog(TicTacToe.this, "!!! IT'S A DRAW !!! \nCLICK RESET OR END GAME");
		}

	}

}
