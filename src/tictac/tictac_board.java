package tictac;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class tictac_board extends JPanel{
	static JFrame frame;
	JButton buttons[] = new JButton[9];
	int turn = 0;
	
	public tictac_board() {
		init();
	}
	
	public void init() {
		for(int i = 0; i != 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(75,75));
			buttons[i].setText("CLICK");
			buttons[i].addActionListener(new button());
			add(buttons[i]);
		}
	}
	
	public class button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton click = (JButton)e.getSource();
			if(turn % 2 == 0 && click.getText() != "O") {
				click.setText("X");
			}
			else if(turn % 2 != 0 && click.getText() != "X"){
				click.setText("O");
			}
			else {
				turn--;
			}
			
			
			if(turn >= 4) {
				boolean winner = win();
				if(winner == true){
					if(turn % 2 == 0) {
						System.out.println("Player 1 WINS");
					}
					else {
						System.out.println("Player 2 WINS");
					}
				}
			}
			if(turn == 8 && win() == false) {
				System.out.println("TIE");
			}
			turn++;
		}
		
	}
	public boolean win() {
		//check vertical
		if(check(0,3) && check (0,6)) {
			return true;
		}
		else if(check(1,4) && check (1,7)) {
			return true;
		}
		else if(check(2,5) && check (2,8)) {
			return true;
		}
		
		//check horizontal
		if(check(0,1) && check (0,2)) {
			return true;
		}
		else if(check(3,4) && check(3,5)) {
			return true;
		}
		else if(check(6,7) && check(6,8)) {
			return true;
		}
		
		//check diagonal
		if(check(0,4) && check (0,8)) {
			return true;
		}
		else if(check(2,4) && check(2,6)) {
			return true;
		}
		
		
		return false;
	}
	
	public boolean check(int i, int j) {
		if(buttons[i].getText() == buttons[j].getText() && buttons[i].getText() != "CLICK" && buttons[j].getText() != "CLICK") {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		frame = new JFrame("TIC TAC TOE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500,400,300,300);
		frame.setVisible(true);
		frame.add(new tictac_board());
	}
}