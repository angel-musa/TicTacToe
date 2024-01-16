import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class gameBoard extends JFrame {

	// create variables 
	private JPanel contentPane;
	private JTextField Xboard;
	private JTextField Oboard;
	private JTextField playerXdisplay;
	private JTextField playerOdisplay;
	private JButton btn1; 
	private JButton btn2; 
	private JButton btn3; 
	private JButton btn4; 
	private JButton btn5; 
	private JButton btn6; 
	private JButton btn7; 
	private JButton btn8; 
	private JButton btn9; 
	private JLabel roundLabel; 
	
	public static String startGame = "X";
	public static int rounds;
	public static Color playerXColour; 
	public static Color playerOColour; 
	static String mode; 
	
	int roundsCounter = 1; 
	boolean [] btnFlag = new boolean [9];
	int [] [] winCheck = new int [2][9];
	private int tieCheck = 0; 
	private int XScore; 
	private int OScore; 
	
	public static String winner; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameBoard frame = new gameBoard(startGame, rounds, mode, playerXColour, playerOColour);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	// void method to choose which player has to go at any instance (after player X, its O's turn) 
	void choosePlayer()
	{
		// this.startGame = starterPlayer; 
		if(startGame.equalsIgnoreCase("X"))
		{
			startGame = "O";
		} else
		{
			startGame = "X";
		}

	}

	// method to change the score board at the top of the frame to give player X a point 
	void changeXScore ()
	{
		Xboard.setText(Integer.toString(XScore)); 
		roundsCounter++; 
		clearBoard();  
		gameOverChecker(); 

	}
	
	// method to change the score board at the top of the frame to give player O a point 
	void changeOScore ()
	{
		Oboard.setText(Integer.toString(OScore)); 
		roundsCounter++;
		clearBoard(); 
		gameOverChecker(); 
	}
	
	// method to clear the game board after it's full 
	void clearBoard()
	{
		
		btn1.setText(""); 
		btn2.setText(""); 
		btn3.setText(""); 
		btn4.setText(""); 
		btn5.setText(""); 
		btn6.setText(""); 
		btn7.setText(""); 
		btn8.setText(""); 
		btn9.setText(""); 
		
		resetVariables(); 
	
	}
	
	// resetting necessary variables after the board has been cleared 
	void resetVariables()
	{
		for (int i = 0; i < 9; i++)
		{
			btnFlag[i] = true;
		}

		for(int k = 0; k < 2; k++)
		{
			for (int l = 0; l < 9; l++)
			{
				winCheck[k][l] = 10;
			}
		}
		
		tieCheck = 0; 
		roundLabel.setText("Round " + roundsCounter);
	}
	
	// checks if the game is over (the user has played indicated number of rounds) 
	void gameOverChecker()
	{
		if(roundsCounter >  rounds)
		{
			JOptionPane.showMessageDialog(contentPane, "Game Over!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			if(XScore > OScore)
			{
				winner = "Player X"; 
			}else if (OScore > XScore)
			{
				winner = "Player O"; 
			} else 
			{
				winner = "Tie"; 
			}
			// if the game is over, open the scoreboard 
			new ScoreBoard(rounds, winner, mode); 
			
		}
	}
	
	// method to check for winning sequences after every player goes 
	void ifWinning ()
	{
			// for player x only 
			if(winCheck[0][0] == 0 && winCheck[0][1] == 0 && winCheck[0][2] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

			}
			else if(winCheck[0][3] == 0 && winCheck[0][4] == 0 && winCheck[0][5] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 
			}
			else if(winCheck[0][6] == 0 && winCheck[0][7] == 0 && winCheck[0][8] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 
			}
			else if(winCheck[0][0] == 0 && winCheck[0][3] == 0 && winCheck[0][6] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

				}
			else if(winCheck[0][1] == 0 && winCheck[0][4] == 0 && winCheck[0][7] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

				}
			else if(winCheck[0][2] == 0 && winCheck[0][5] == 0 && winCheck[0][8] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

				}
			else if(winCheck[0][0] == 0 && winCheck[0][4] == 0 && winCheck[0][8] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

				}
			else if(winCheck[0][2] == 0 && winCheck[0][4] == 0 && winCheck[0][6] == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				XScore++; 
				changeXScore (); 

				}
			
			// for player o only 
			else if(winCheck[1][0] == 1 && winCheck[1][1] == 1 && winCheck[1][2] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
			}
			else if(winCheck[1][3] == 1 && winCheck[1][4] == 1 && winCheck[1][5] == 1)
			{
				JOptionPane.showMessageDialog(contentPane,"Player O Wins!" , "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
			}
			else if(winCheck[1][6] == 1 && winCheck[1][7] == 1 && winCheck[1][8] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++;
				changeOScore (); 
			}
			else if(winCheck[1][0] == 1 && winCheck[1][3] == 1 && winCheck[1][6] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
				}
			else if(winCheck[1][1] == 1 && winCheck[1][4] == 1 && winCheck[1][7] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
				}
			else if(winCheck[1][2] == 1 && winCheck[1][5] == 1 && winCheck[1][8] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
				}
			else if(winCheck[1][0] == 1 && winCheck[1][4] == 1 && winCheck[1][8] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
				}
			else if(winCheck[1][2] == 1 && winCheck[1][4] == 1 && winCheck[1][6] == 1)
			{
				JOptionPane.showMessageDialog(contentPane, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				OScore++; 
				changeOScore (); 
			} else if (tieCheck == 9)
			{
				// if there is a tie, clear the board, check if the game is over, and reset variables 
				JOptionPane.showMessageDialog(contentPane, "Tie.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				clearBoard(); 
				gameOverChecker(); 
				resetVariables(); 
			}

	}
	
	// method to change colours of components if user selected dark mode
	void darkMode()
	{
		if (mode == "Dark Mode")
		{
			btn1.setBackground(Color.BLACK); 
			btn2.setBackground(Color.BLACK); 
			btn3.setBackground(Color.BLACK); 
			btn4.setBackground(Color.BLACK); 
			btn5.setBackground(Color.BLACK); 
			btn6.setBackground(Color.BLACK); 
			btn7.setBackground(Color.BLACK); 
			btn8.setBackground(Color.BLACK); 
			btn9.setBackground(Color.BLACK); 
			
			btn1.setForeground(Color.PINK);
			btn2.setForeground(Color.PINK);
			btn3.setForeground(Color.PINK);
			btn4.setForeground(Color.PINK);
			btn5.setForeground(Color.PINK);
			btn6.setForeground(Color.PINK);
			btn7.setForeground(Color.PINK);
			btn8.setForeground(Color.PINK);
			btn9.setForeground(Color.PINK);
			
			Xboard.setBackground(Color.DARK_GRAY); 
			Xboard.setForeground(Color.WHITE); 
			Oboard.setBackground(Color.DARK_GRAY);
			Oboard.setForeground(Color.WHITE); 
			
			playerXdisplay.setBackground(Color.GRAY);
			playerOdisplay.setBackground(Color.GRAY);
			
			roundLabel.setBackground(Color.BLACK);

		}
	} 
	

	/**
	 * Create the frame.
	 */
	public gameBoard(String starterPlayer, int spinnerValue, String mode, Color playerXColour, Color playerOColour) {
		
		gameBoard.startGame = starterPlayer; 
		gameBoard.rounds = spinnerValue; 
		gameBoard.mode = mode; 
		gameBoard.playerXColour = playerXColour; 
		gameBoard.playerOColour = playerOColour; 

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		// create panel to contain components related to rounds 
		JPanel roundsTracker = new JPanel();
		roundsTracker.setBounds(0, 0, 534, 43);
		contentPane.add(roundsTracker);
		roundsTracker.setLayout(new GridLayout(1, 0, 0, 0));
		
		// create label to show which round # is being played at the moment 
		roundLabel = new JLabel("");
		roundLabel.setText("Round " + (roundsCounter));
		roundLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roundsTracker.add(roundLabel);
		
		// panel to contain components relating to the score 
		JPanel scoreBoard = new JPanel();
		scoreBoard.setBounds(0, 43, 584, 89);
		contentPane.add(scoreBoard);
		scoreBoard.setLayout(null); 
		
		// create textfield as player X's score header
		Xboard = new JTextField();
		Xboard.setEditable(false);
		Xboard.setBackground(new Color(250, 240, 230));
		Xboard.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 50));
		Xboard.setHorizontalAlignment(SwingConstants.CENTER);
		Xboard.setBounds(0, 34, 266, 55);
		scoreBoard.add(Xboard);
		Xboard.setColumns(10);
		
		// create textfield as Player O's Score header 
		Oboard = new JTextField();
		Oboard.setEditable(false);
		Oboard.setBackground(new Color(250, 240, 230));
		Oboard.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 50));
		Oboard.setHorizontalAlignment(SwingConstants.CENTER);
		Oboard.setColumns(10);
		Oboard.setBounds(266, 34, 266, 55);
		scoreBoard.add(Oboard);
		
		// create textfield to display player X's score 
		playerXdisplay = new JTextField();
		playerXdisplay.setEditable(false);
		playerXdisplay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		playerXdisplay.setText("PLAYER X");
		playerXdisplay.setHorizontalAlignment(SwingConstants.CENTER);
		playerXdisplay.setBounds(0, 0, 266, 33);
		scoreBoard.add(playerXdisplay);
		playerXdisplay.setColumns(10);
		
		// create textfield to display player X's score 
		playerOdisplay = new JTextField();
		playerOdisplay.setEditable(false);
		playerOdisplay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		playerOdisplay.setHorizontalAlignment(SwingConstants.CENTER);
		playerOdisplay.setText("PLAYER O");
		playerOdisplay.setColumns(10);
		playerOdisplay.setBounds(266, 0, 266, 33);
		scoreBoard.add(playerOdisplay);
		
		// overall panel for the game board 
		JPanel gameBoard = new JPanel();
		gameBoard.setBounds(0, 131, 534, 380);
		contentPane.add(gameBoard);
		gameBoard.setLayout(null);
		
		// setting necessary variables to respective values 
		for (int i = 0; i < 9; i++)
		{
			btnFlag[i] = true;
		}

		for(int k = 0; k < 2; k++)
		{
			for (int l = 0; l < 9; l++)
			{
				// the value of winCheck can't be 0 or 1 bc those are the designated values for player X and player O (respectively) 
				winCheck[k][l] = 2;
			}
		}
		
		// create button 1 
		btn1 = new JButton("");
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(0, 1, 178, 126);
		btn1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn1);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// if this button's flag is true, meaning that it hasn't been clicked, execute the following code 
			if (btnFlag[0])
			{
				// player X went 
				if(startGame.equalsIgnoreCase("X"))
				{
					/*
					 *  set the label's text, change colour to what user indicated
					 *  set the flag to false so the button's contents cannot be changed if clicked again 
					 *  set necessary variables to check game outcome 
					 */
					btn1.setText("X");
					btn1.setForeground(playerXColour);
					btnFlag[0] = false;
					winCheck[0][0] = 0;
					tieCheck++;
				}else
				{
					btn1.setText("O");
					btn1.setForeground(playerOColour);
					btnFlag[0] = false;
					winCheck[1][0] = 1;
					tieCheck++;
				}

				// change to the next player, and check if there's a winning sequence 
				choosePlayer();
				ifWinning();
		
			}
			} 
		});
		
		// button 2 
		btn2 = new JButton("");
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(178, 1, 178, 126);
		btn2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn2); 
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[1])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn2.setText("X");
						btn2.setForeground(playerXColour);
						btnFlag[1] = false;
						winCheck[0][1] = 0;
						tieCheck++;
					}else
					{
						btn2.setText("O");
						btn2.setForeground(playerOColour);
						btnFlag[1] = false;
						winCheck[1][1] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
					
				}
			}
		}); 

		// create third button 
		btn3 = new JButton("");
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(356, 1, 178, 126);
		btn3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn3); 
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[2])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn3.setText("X");
						btn3.setForeground(playerXColour); 
						btnFlag[2] = false;
						winCheck[0][2] = 0;
						tieCheck++;
					}else
					{
						btn3.setText("O");
						btn3.setForeground(playerOColour);
						btnFlag[2] = false;
						winCheck[1][2] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();

				}
			}
		});
		
		btn4 = new JButton("");
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(0, 127, 178, 126);
		btn4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn4);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[3])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn4.setText("X");
						btn4.setForeground(playerXColour);
						btnFlag[3] = false;
						winCheck[0][3] = 0;
						tieCheck++;
					}else
					{
						btn4.setText("O");
						btn4.setForeground(playerOColour);
						btnFlag[3] = false;
						winCheck[1][3] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
				}
			}
		});
		
		btn5 = new JButton("");
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(178, 127, 178, 126);
		btn5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn5);
		btn5.addActionListener(new ActionListener() {
			@Override
			/*
			 *  set the label's text, change colour to what user indicated
			 *  set the flag to false so the button's contents cannot be changed if clicked again 
			 *  set necessary variables to check game outcome 
			 */
			public void actionPerformed(ActionEvent e) {
				if (btnFlag[4])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn5.setText("X");
						btn5.setForeground(playerXColour);
						btnFlag[4] = false;
						winCheck[0][4] = 0;
						tieCheck++;
					}else
					{
						btn5.setText("O");
						btn5.setForeground(playerOColour);
						btnFlag[4] = false;
						winCheck[1][4] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
	
				}
			}
		});
		
		btn6 = new JButton("");
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(356, 127, 178, 126);
		btn6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn6);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[5])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn6.setText("X");
						btn6.setForeground(playerXColour);
						btnFlag[5] = false;
						winCheck[0][5] = 0;
						tieCheck++;
					}else
					{
						btn6.setText("O");
						btn6.setForeground(playerOColour);
						btnFlag[5] = false;
						winCheck[1][5] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
				}
			}
		});
		
		btn7 = new JButton("");
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(0, 253, 178, 126);
		btn7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn7); 
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[6])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn7.setText("X");
						btn7.setForeground(playerXColour);
						btnFlag[6] = false;
						winCheck[0][6] = 0;
						tieCheck++;
					}else
					{
						btn7.setText("O");
						btn7.setForeground(playerOColour);
						btnFlag[6] = false;
						winCheck[1][6] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
				}
			}
		});
		
		btn8 = new JButton("");
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(178, 253, 178, 126);
		btn8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn8);
		//darkMode(); 
		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[7])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn8.setText("X");
						btn8.setForeground(playerXColour);
						btnFlag[7] = false;
						winCheck[0][7] = 0;
						tieCheck++;
					}else
					{
						btn8.setText("O");
						btn8.setForeground(playerOColour);
						btnFlag[7] = false;
						winCheck[1][7] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
					
				}
			}
		});
		
		btn9 = new JButton("");
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(356, 253, 178, 126);
		btn9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		gameBoard.add(btn9);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *  set the label's text, change colour to what user indicated
				 *  set the flag to false so the button's contents cannot be changed if clicked again 
				 *  set necessary variables to check game outcome 
				 */
				if (btnFlag[8])
				{
					if(startGame.equalsIgnoreCase("X"))
					{
						btn9.setText("X");
						btn9.setForeground(playerXColour);
						btnFlag[8] = false;
						winCheck[0][8] = 0;
						tieCheck++;
					}else
					{
						btn9.setText("O");
						btn9.setForeground(playerOColour);
						btnFlag[8] = false;
						winCheck[1][8] = 1;
						tieCheck++;
					}
					// change to the next player, and check if there's a winning sequence 
					choosePlayer();
					ifWinning();
				}
			}
		});
		
		
		// makes the frame visible, calls method to check if dark mode is selected 
		setVisible(true);
		darkMode(); 
	
	}
}
