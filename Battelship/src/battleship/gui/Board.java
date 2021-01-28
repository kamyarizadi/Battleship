package battleship.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import battleship.mvc.controller.Controller;
import battleship.mvc.view.IBattleshipBoard;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements IBattleshipBoard {

	private static Board window = null;
	private Controller controller = null;
	private JPanel contentPane;
	private JTextField txtGuessInput;
	private JLayeredPane layeredPane;
	private JLabel lblMsg;
	private JButton btnFireButton;

	/**
	 * Launch the board in the singleton Mode.
	 */
	public static IBattleshipBoard startBoard() {
		if (window != null)
			return window;
		try {
			//invoke Waits for the form to be appeared then continue
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						window = new Board();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		catch(Exception e){

		}		

		return window;
	}

	/**
	 * Singleton Constructor.
	 */
	private Board() {
		initialize();		
	}

 
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 749);	
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setBackground(Color.BLACK);
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.RED, 3));
		layeredPane.setBackground(Color.BLACK);
		contentPane.add(layeredPane);
		
		txtGuessInput = new JTextField();
		txtGuessInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleFireButton();
			}
		});
		txtGuessInput.setBounds(313, 634, 86, 20);
		layeredPane.add(txtGuessInput);
		txtGuessInput.setColumns(10);
		
		btnFireButton = new JButton("Fire!");
		btnFireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleFireButton();
			}
		});
		btnFireButton.setBounds(401, 633, 66, 23);
		layeredPane.add(btnFireButton);
		
		JLabel lblBoard = new JLabel("");
		lblBoard.setBackground(Color.MAGENTA);
		lblBoard.setBounds(5, 5, 1024*3/4, 823*3/4);
		setBoardScaledImage(lblBoard);
		layeredPane.add(lblBoard);		
		lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setForeground(Color.GREEN);
		lblMsg.setBackground(Color.BLACK);
		lblMsg.setBounds(242, 665, 274, 15);
		layeredPane.add(lblMsg);
		
//		JLabel lblMiss = new JLabel("", SwingConstants.CENTER);
//		lblMiss.setBounds(280, 285, 67, 67);		
//		layeredPane.setLayer(lblMiss, 1);		
//		setMissScaledImage(lblMiss);
//		layeredPane.add(lblMiss);		
	}

	
	private void setBoardScaledImage(JLabel lbl){
        BufferedImage image = null;
        try {
            image = ImageIO.read(Board.class.getResource("/resources/board.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image img= image.getScaledInstance((int)(512*1.5), (int)(430*1.5),
                Image.SCALE_SMOOTH);

        lbl.setIcon(new ImageIcon(img));
    }	
	
	private void setMissScaledImage(JLabel lbl, String picType){
		String picPath = picType.equals("miss")? "/resources/miss.png":"/resources/ship.png";
		
        BufferedImage image = null;
        try {
            image = ImageIO.read(Board.class.getResource(picPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

       Image img= image.getScaledInstance((int)(79*3/4), (int)(33*3/4),
                Image.SCALE_SMOOTH);

        lbl.setIcon(new ImageIcon(img));
    }	
	
	
	private void handleFireButton() {
		String guess = txtGuessInput.getText();
		controller.processGuess(guess);
		txtGuessInput.setText("");
		
		
	}
	
	
	/**
	 * Displays Miss at cell [i, j]
	 * @param i
	 * @param j
	 */
	private void displayMiss(int i, int j)
	{
		JLabel lblMiss = new JLabel("", SwingConstants.CENTER);
		lblMiss.setBounds(136 + i * 72, 66 + j * 72, 67, 67);
		setMissScaledImage(lblMiss, "miss");
		layeredPane.setLayer(lblMiss, 1);				
		layeredPane.add(lblMiss);		
		
		
//		/**
//		 * x and y are coordinates of cells extracted from the picture
//		 */
//		int x[] = {136, 208, 280, 351, 424, 495, 567};
//		int y[] = {66, 137, 209, 285, 357, 428, 500};
//		for(int i = 0; i < x.length; ++i)
//			for (int j = 0; j < y.length; ++j)
//			{
//				JLabel lblMiss = new JLabel("", SwingConstants.CENTER);
//				lblMiss.setBounds(136 + i * 72, 66 + j * 72, 67, 67);
//				setMissScaledImage(lblMiss);
//				layeredPane.setLayer(lblMiss, 1);				
//				layeredPane.add(lblMiss);
//			}


	}

	/**
	 * Displays Hit at cell [i, j]
	 * @param i
	 * @param j
	 */
	private void displayHit(int i, int j)
	{
		JLabel lblHit = new JLabel("", SwingConstants.CENTER);
		lblHit.setBounds(136 + i * 72, 66 + j * 72, 67, 67);
		setMissScaledImage(lblHit, "hit");
		layeredPane.setLayer(lblHit, 1);				
		layeredPane.add(lblHit);		
	}	
	
	@Override
	public void displayMessage(String msg) {
		// TODO Auto-generated method stub
		this.lblMsg.setText(msg);
	}

	@Override
	public void displayMiss(String location) {		
		int intLoc = Integer.parseInt(location);
		
		int j = intLoc / 10; //The left digit corresponds to rows A to G 
		int i = intLoc % 10; //The right digit corresponds to columns 0 to 6
		displayMiss(i, j);
		
	}

	@Override
	public void displayHit(String location) {		
		int intLoc = Integer.parseInt(location);
		
		int j = intLoc / 10; //The left digit corresponds to rows A to G 
		int i = intLoc % 10; //The right digit corresponds to columns 0 to 6
		displayHit(i, j);
		
	}

	@Override
	public void disableGuess() {
		this.btnFireButton.setEnabled(false);
		this.txtGuessInput.setEnabled(false);
		
	}	
	
	
}
