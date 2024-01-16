import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;

public class HomeScreen extends JFrame {

	// initialize variables 
	private JFrame frame;
	public String starterPlayer = "";
	public JRadioButton playerOrbt; 
	public JRadioButton playerXrbt;
	public JButton startButton; 
	public String [] Colours = {"Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Pink"}; 
	public Color playerXColour; 
	public Color playerOColour; 
	public String selectedXColour = "Red"; 
	public String selectedOColour = "Red"; 
	public boolean isSelected = false; 
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// method to return a colour depending on what is selected from the drop down menu 
	// for player X
	private Color textColourX ()
	{
	
			if(selectedXColour.equals("Red"))
			{
				return Color.RED; 
			} else if(selectedXColour.equals("Orange"))
			{
				return Color.ORANGE; 
			}  else if(selectedXColour.equals("Yellow"))
			{
				return Color.YELLOW; 
			}  else if(selectedXColour.equals("Green"))
			{
				return Color.GREEN; 
			}  else if(selectedXColour.equals("Blue"))
			{
				return Color.BLUE; 
			}  else if(selectedXColour.equals("Magenta"))
			{
				return Color.MAGENTA; 
			} else 
			{
				return Color.PINK; 
			} 
	}
	
	// method to return a colour depending on what is selected from the drop down menu 
		// for player O
	private Color textColourO ()
	{
	
			if(selectedOColour.equals("Red"))
			{
				return Color.RED; 
			} else if(selectedOColour.equals("Orange"))
			{
				return Color.ORANGE; 
			}  else if(selectedOColour.equals("Yellow"))
			{
				return Color.YELLOW; 
			}  else if(selectedOColour.equals("Green"))
			{
				return Color.GREEN; 
			}  else if(selectedOColour.equals("Blue"))
			{
				return Color.BLUE; 
			}  else if(selectedOColour.equals("Magenta"))
			{
				return Color.MAGENTA; 
			} else 
			{
				return Color.PINK; 
			} 
	}

	/**
	 * Create the application.
	 */
	public HomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */ 

	public void initialize() {
		
		// create frame 
		frame = new JFrame();
		frame.setResizable(false);
		JPanel panel = new JPanel (); 
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(500, 700)); 
		
		// create scrollpane
		JScrollPane jScrollPane = new JScrollPane(panel);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setPreferredSize(new Dimension(500, 300));
		panel.setLayout(null);
		frame.getContentPane().add(jScrollPane);
		
		// create titleLabel 
		JLabel titleLabel = new JLabel("TIC TAC TOE");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 50));
		titleLabel.setBounds(65, 22, 348, 81);
		panel.add(titleLabel);
		
		// create panel to contain components relating to game rules 
		JPanel rulesPanel = new JPanel();
		rulesPanel.setBounds(54, 89, 371, 141);
		panel.add(rulesPanel);
		rulesPanel.setLayout(null);
		
		// create label for "rules" title 
		JLabel rulesLabel = new JLabel("Rules:");
		rulesLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rulesLabel.setBounds(10, 0, 97, 32);
		rulesPanel.add(rulesLabel);
		
		// create label for rule number 1 
		JLabel ruleLabel1 = new JLabel("1. The game is played on a grid that's 3 squares by 3 squares");
		ruleLabel1.setBounds(20, 28, 347, 21);
		rulesPanel.add(ruleLabel1);
		ruleLabel1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		// create label for rule 2
		JLabel ruleLabel2 = new JLabel("2. Choose who goes first: Player X or Player O");
		ruleLabel2.setBounds(20, 52, 347, 16);
		rulesPanel.add(ruleLabel2);
		ruleLabel2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		// create label for rule 3 
		JLabel ruleLabel3 = new JLabel("3. First player to get 3 marks in a winning sequence wins a point");
		ruleLabel3.setBounds(20, 73, 347, 21);
		rulesPanel.add(ruleLabel3);
		ruleLabel3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		// create label for rule 4
		JLabel ruleLabel4 = new JLabel("4. When all 9 squares are full, the round is over");
		ruleLabel4.setBounds(20, 97, 347, 21);
		rulesPanel.add(ruleLabel4);
		ruleLabel4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		// create panel to contain components relating to settings
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(54, 241, 371, 104);
		panel.add(settingsPanel);
		settingsPanel.setLayout(null);
		
		// create label for "Starting Player" 
		JLabel playerSettingsLabel = new JLabel("Starting Player? ");
		playerSettingsLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		playerSettingsLabel.setBounds(10, 11, 140, 24);
		settingsPanel.add(playerSettingsLabel);
		
		// radio button to choose player X as starting player 
		playerXrbt = new JRadioButton("Player X");
		playerXrbt.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		playerXrbt.addMouseListener(new MouseAdapter() {
			@Override
			// if button is clicked, store respective data into starterPlayer variable 
			public void mouseClicked(MouseEvent e) {
				starterPlayer = "X"; 
				
			}
		});
		playerXrbt.setBounds(20, 42, 109, 23);
		settingsPanel.add(playerXrbt);
		
		// radio button to choose player X as starting player 
		playerOrbt = new JRadioButton("Player O");
		playerOrbt.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		playerOrbt.addMouseListener(new MouseAdapter() {
			@Override
			// if button is clicked, store respective data into starterPlayer variable 
			public void mouseClicked(MouseEvent e) {
				starterPlayer = "O";
			}
		});
		
		// create a button group so that only one button can be pressed at a time 
		ButtonGroup group = new ButtonGroup(); 
		group.add(playerXrbt);
		group.add(playerOrbt);
	
		playerOrbt.setBounds(20, 72, 109, 23);
		settingsPanel.add(playerOrbt);
		frame.getContentPane().add(jScrollPane);
		
		// create panel to contain components related to number of rounds 
		JPanel roundsPanel = new JPanel();
		roundsPanel.setLayout(null);
		roundsPanel.setBounds(54, 356, 371, 51);
		panel.add(roundsPanel);
		
		// label to display "Number of Rounds?" 
		JLabel roundsLabel = new JLabel("Number of Rounds?");
		roundsLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		roundsLabel.setBounds(10, 11, 140, 24);
		roundsPanel.add(roundsLabel);
		
		// create spinner so user can decide how many rounds to play 
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinner.setBounds(300, 16, 47, 20);
		roundsPanel.add(spinner);
		
		// create panel to contain components related to the mode (light vs dark) 
		JPanel modePanel = new JPanel();
		modePanel.setLayout(null);
		modePanel.setBounds(54, 418, 371, 51);
		panel.add(modePanel);
		
		// create label to display "Mode?" 
		JLabel modeLabel = new JLabel("Mode?");
		modeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		modeLabel.setBounds(10, 11, 140, 24);
		modePanel.add(modeLabel);
		
		// create togglebutton so user can choose if they want to play in light or dark mode 
		JToggleButton modeToggle = new JToggleButton("Light Mode");
		modeToggle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		modeToggle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				/*
				 *  if the button's state is changed
				 *  1. the colour of the panel changes 
				 *  2. the background and start button changes to black/white 
				 * 	3. the text on the toggle button changes to whichever mode is selected 
				 *  4. the text on the button is stored in the variable 'mode' to be used later
				 */
				String mode = modeToggle.getText(); 
				if(mode.equals("Light Mode"))
				{
					modeToggle.setText("Dark Mode"); 
					panel.setBackground(Color.BLACK); 
					titleLabel.setForeground(Color.WHITE); 
					startButton.setBackground(Color.WHITE); 
					startButton.setForeground(Color.BLACK); 
					
				}else 
				{
					modeToggle.setText("Light Mode"); 
					panel.setBackground(Color.WHITE);
					titleLabel.setForeground(Color.BLACK); 
					startButton.setBackground(Color.BLACK); 
					startButton.setForeground(Color.WHITE); 
				}
			}
		});
		
		modeToggle.setBounds(240, 15, 121, 23);
		modePanel.add(modeToggle);
		
		// create start button 
		startButton = new JButton("START");
		startButton.setVerticalAlignment(SwingConstants.BOTTOM);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		startButton.setBackground(Color.BLACK);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				/*
				 *  if start button is pressed: 
				 *  1. program gets and stores the value of the spinner (#of rounds), and the currentState of the togglebutton
				 *  2. void methods to return the chosen colours of player X/O is called 
				 *  3. code to check if a starting player has been chosen using the radio buttons 
				 *  	3a. if they have chosen a starting player, open the gameBoard frame and continue 
				 *  	3b. if they have not done so, display a warning message if the user hasn't chosen a starting player
				 * 
				 */
				
				// 1. 
				Integer spinnerValue = (Integer) spinner.getValue(); 
				String currentState = modeToggle.getText(); 
				
				
				//2. 
				playerXColour = textColourX (); 
				playerOColour = textColourO(); 
				
				// 3
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
				    AbstractButton button = buttons.nextElement();
				    if (button.isSelected()) {
				        isSelected = true;
				        break;
				    }
				}
				
				// 3a. 
				if (isSelected == false)
				{
					JOptionPane.showMessageDialog(frame, "Please choose the starting player.", "Tic Tac Toe", JOptionPane.WARNING_MESSAGE);
				} // 3b.
				else 
				{
					frame.setVisible(false);  
					new gameBoard(starterPlayer, spinnerValue, currentState, playerXColour, playerOColour); 
				}
				
			}
		});
		startButton.setBounds(167, 634, 134, 51);
		panel.add(startButton);
		
		// create panel to store components related to choosing player colours
		JPanel colourPanel = new JPanel();
		colourPanel.setLayout(null);
		colourPanel.setBounds(54, 480, 371, 134);
		panel.add(colourPanel);
		
		// create label to display text 
		JLabel colourLabel = new JLabel("Click to Choose Player Colours");
		colourLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		colourLabel.setBounds(84, 11, 215, 24);
		colourPanel.add(colourLabel);
		
		// create combo box to store strings of the colour options 
		/* note to self: 
		 * JComboBox has been not parameterized, which means that the code isn't like; 
		 * 		JComboBox<String> XColourCB = new JComboBox <String> (Colours);
		 * if you do this, the design window doesn't work 
		 */ 
		
		// to choose player X colour 
		JComboBox XColourCB = new JComboBox (Colours);
		XColourCB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		XColourCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedXColour= (String) XColourCB.getSelectedItem(); 
			}
		});
		XColourCB.setToolTipText("");
		XColourCB.setBounds(10, 65, 136, 58);
		colourPanel.add(XColourCB);
		
		// to choose player O colour 
		JComboBox OColourCB = new JComboBox (Colours);
		OColourCB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		OColourCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOColour = (String) OColourCB.getSelectedItem(); 
			}
		});
		OColourCB.setToolTipText("");
		OColourCB.setBounds(225, 65, 136, 58);
		colourPanel.add(OColourCB);
		
		// label to display text 
		JLabel colourXLabel = new JLabel("Player X");
		colourXLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		colourXLabel.setBounds(45, 40, 57, 14);
		colourPanel.add(colourXLabel);
		
		// label to display text 
		JLabel colourOLabel = new JLabel("Player O");
		colourOLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		colourOLabel.setBounds(269, 40, 57, 14);
		colourPanel.add(colourOLabel);
		
		// frame's bounds has to be the same as the scroll pane for the SP to work 
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true); 
 
	}
}
