import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreBoard extends JFrame {

	// variables needed 
	private JPanel mainPanel;
	private JTextField winnerTitle;
	private JTextField roundsTitle;
	
	public static int rounds; 
	public static String winner; 
	private JButton newgameBtn; 
	private JButton exitBtn;  
	
	static String mode; 
	private JTextField roundsText;
	private JTextField winnerText;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoard frame = new ScoreBoard(rounds, winner, mode);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// method to change components to different colours if dark mode is selected 
	void darkMode()
	{
		if(mode == "Dark Mode")
		{
			mainPanel.setBackground(Color.BLACK);
			roundsTitle.setBackground(Color.GRAY);
			winnerTitle.setBackground(Color.GRAY);
			roundsTitle.setForeground(Color.WHITE);
			winnerTitle.setForeground(Color.WHITE);
			newgameBtn.setBackground(Color.LIGHT_GRAY); 
			exitBtn.setBackground(Color.LIGHT_GRAY); 
			//newgameBtn.setForeground(Color.WHITE);
			//exitBtn.setForeground(Color.WHITE);
			
			roundsText.setBackground(Color.LIGHT_GRAY);
			winnerText.setBackground(Color.LIGHT_GRAY);

		}
	}
	/**
	 * Create the frame.
	 */
	public ScoreBoard(int rounds, String winner, String mode) {
		
		ScoreBoard.mode = mode; 
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 188);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setPreferredSize(new Dimension(500, 750)); 
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		// create panel to contain components related to buttons 
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(10, 11, 414, 37);
		mainPanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(1, 0, 0, 2));

		// create button to play another game 
		newgameBtn = new JButton("New Game");
		newgameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {  
			// go back to HomeScreen
				setVisible(false); 
				new HomeScreen(); 		
			}
		});
		newgameBtn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		buttonsPanel.add(newgameBtn);
		
		// create button to exit application 
		exitBtn = new JButton("Exit");
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		buttonsPanel.add(exitBtn);
		
		// create panel for results header 
		JPanel headerPane = new JPanel();
		headerPane.setBounds(10, 59, 414, 22);
		mainPanel.add(headerPane);
		headerPane.setLayout(new GridLayout(1, 0, 0, 2));
		
		// create textfield to display the header
		roundsTitle = new JTextField();
		roundsTitle.setText("# of Rounds");
		roundsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		roundsTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		headerPane.add(roundsTitle);
		roundsTitle.setColumns(10);
		
		// create textfield to display the header
		winnerTitle = new JTextField();
		winnerTitle.setText("Winner");
		winnerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		winnerTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		headerPane.add(winnerTitle);
		winnerTitle.setColumns(10);
		
		// textField to display number of rounds played 
		roundsText = new JTextField();
		roundsText.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		roundsText.setHorizontalAlignment(SwingConstants.CENTER);
		// set text to the number of rounds played 
		roundsText.setText(Integer.toString(rounds));
		roundsText.setBounds(10, 81, 207, 57);
		mainPanel.add(roundsText);
		roundsText.setColumns(10);
		
		// // create textfield to display who won the game (depending on rounds won) or if it was a tie 
		winnerText = new JTextField();
		winnerText.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		winnerText.setHorizontalAlignment(SwingConstants.CENTER);
		// set text to the winner 
		winnerText.setText(winner);
		winnerText.setColumns(10);
		winnerText.setBounds(217, 81, 207, 57);
		mainPanel.add(winnerText);
		
		// set the frame so it's visible, check if dark mode was selected 
		setVisible(true);
		darkMode(); 
		
	}
}
