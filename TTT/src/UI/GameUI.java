package UI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import PD.Board;
import PD.Game;
import PD.Position;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	*/
	private static int currButtonID = 0;
	private static boolean userPlayed = false;
	private static boolean gameStarted = false;
	private static boolean exit = false;
	
	private static String player = "";
	private static JButton[][] buttons;
	private  static JButton computerbtn;
	private static JButton userbtn;
	private static JButton exitbtn;
	private static JPanel boardPanel;

	public static void play() {
		JPanel choicePanel;
		JLabel choiceLabel;
		
		JPanel mainPanel;
		
		JFrame frame;
		
		JButton button1;
		JButton button2;
		JButton button3;
		JButton button4;
		JButton button5;
		JButton button6;
		JButton button7;
		JButton button8;
		JButton button9;
		
		frame = new JFrame("Tic Tac Toe Game");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		choicePanel = new JPanel();
		choicePanel.setPreferredSize(new Dimension(500, 50));
		choicePanel.setBackground(Color.LIGHT_GRAY);
	
		choiceLabel = new JLabel("Who Goes First?");
		choiceLabel.setFont(new Font ("Serif", Font.PLAIN, 14));
		computerbtn = new JButton("Computer-X");
		computerbtn.setEnabled(true);
		userbtn = new JButton("Computer-O");
		userbtn.setEnabled(true);
		exitbtn=new JButton("Exit");
		exitbtn.setEnabled(true);
		exitbtn.setBackground(Color.RED);
		
		GridBagConstraints contraints = new GridBagConstraints();
		contraints.gridx = 0;
		contraints.gridy = 0;
		choicePanel.add(choiceLabel, contraints);
		contraints.gridx = 0;
		contraints.gridy = 1;
		choicePanel.add(computerbtn, contraints);
		contraints.gridx = 0;
		contraints.gridy = 2;
		choicePanel.add(userbtn, contraints);
		contraints.gridx = 0;
		contraints.gridy = 3;
		choicePanel.add(exitbtn, contraints);
		
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout (3,3));
		boardPanel.setPreferredSize(new Dimension(350,350));
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Tic Tac Toe Game Board");
		title.setTitleJustification(TitledBorder.CENTER);
		boardPanel.setBorder(title);
		
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		
		buttons = new JButton[][]{{button1, button2,button3}, {button4, button5, button6}, {button7, button8, button9} };
        initialize();
		
		
		mainPanel.add(choicePanel);
		mainPanel.add(boardPanel);
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
	
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 1;
				System.out.println("Button" + currButtonID);
				button1.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 2;
				System.out.println("Button" + currButtonID);
				button2.setEnabled(false);
				
				userPlayed = true;
				
			}
		});
		
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 3;
				System.out.println("Button" + currButtonID);
				button3.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 4;
				System.out.println("Button" + currButtonID);
				button4.setEnabled(false);
				
				userPlayed = true;
			}
		});
		button5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 5;
				System.out.println("Button" + currButtonID);
				button5.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 6;
				System.out.println("Button" + currButtonID);
				button6.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button7.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 7;
				System.out.println("Button" + currButtonID);
				button7.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 8;
				System.out.println("Button" + currButtonID);
				button8.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		button9.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				currButtonID = 9;
				System.out.println("Button" + currButtonID);
				button9.setEnabled(false);
				
				userPlayed = true;
			}
		});
		
		computerbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				computerbtn.setEnabled(false);
				userbtn.setEnabled(false);
				
				for (int row = 0; row < 3; row++)
				{
					for (int col = 0; col < 3; col++)
					{
						boardPanel.add(buttons[row][col]);
						buttons[row][col].setEnabled(true);
					}
				}	
				
				player = "X";
				gameStarted = true;
			}
		});
		
		userbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				player = "O";
				gameStarted = true;
				
				computerbtn.setEnabled(false);
				userbtn.setEnabled(false);
				
				for (int row = 0; row < 3; row++)
				{
					for (int col = 0; col < 3; col++)
					{
						boardPanel.add(buttons[row][col]);
						buttons[row][col].setEnabled(true);
					}
				}	
			}
		});
		exitbtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exit = true;
				System.exit(0);
			}
		});
		while (!exit)
		{
			
			while(!gameStarted) {
				System.out.print("");
				
			}
			Board board= new Board(player);
			Position move=new Position(-1,-1);
			Random random=new Random();
			if(player=="X") {
				move.x=random.nextInt(3);
				move.y=random.nextInt(3);
				board.play(move.x,move.y , "X");
				buttons[move.x][move.y].setEnabled(false);
				buttons[move.x][move.y].setText("X");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			while(!board.gameOver()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(board.getMark()=="O") {
					/*while(!userPlayed) {
						System.out.println("");
					}
					userPlayed=false;*/
					//move=detectClick();
					move=board.evaluate();
					board.play(move.x,move.y, "O");
					buttons[move.x][move.y].setEnabled(false);
					buttons[move.x][move.y].setText("O");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(board.gameOver()) break;
			
				move=board.evaluate();
				board.play(move.x,move.y , "X");
				buttons[move.x][move.y].setEnabled(false);
				buttons[move.x][move.y].setText("X");
				

			
			
			
		}
		board.showTheWinner();
		if(board.isWinner("O")) {

        	System.out.println("User win!"); //Can't happen
        	JOptionPane.showMessageDialog(null, "Game Over, and User won!");
        	initialize();
		}
		else if(board.isWinner("X")) {

        	System.out.println("AI win!"); //Can't happen
        	JOptionPane.showMessageDialog(null, "Game Over, and AI won!");
        	initialize();
		}
		else {

        	System.out.println("It's a draw!"); //Can't happen
        	JOptionPane.showMessageDialog(null, "Game Over, and it's a draw!");
        	initialize();
		}
		}
	}
/**
 * 
 */
	public static void initialize() {
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				boardPanel.add(buttons[row][col]);
				buttons[row][col].setEnabled(false);
				buttons[row][col].setText("");
				buttons[row][col].setFont(new Font ("Courrier", Font.BOLD, 80));
			}
		}
		currButtonID=0;
		gameStarted=false;
		userPlayed=false;
		computerbtn.setEnabled(true);
		userbtn.setEnabled(true);
		player="";
		
	}
	public static Position detectClick()
	{
		Position temp = new Position(-1, -1);
		
		switch(currButtonID)
		{
		case 1:
			temp.x = 0;
			temp.y = 0;
			break;
		case 2:
			temp.x = 0;
			temp.y = 1;
			break;
		case 3:
			temp.x = 0;
			temp.y = 2;
			break;
		case 4:
			temp.x = 1;
			temp.y = 0;
			break;
		case 5:
			temp.x = 1;
			temp.y = 1;
			break;
		case 6:
			temp.x = 1;
			temp.y = 2;
			break;
		case 7:
			temp.x = 2;
			temp.y = 0;
			break;
		case 8:
			temp.x = 2;
			temp.y = 1;
			break;
		case 9:
			temp.x = 2;
			temp.y = 2;
			break;
		}
		return temp;
	}
		
		
}
