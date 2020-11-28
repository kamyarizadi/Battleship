package battleship.GUI;

import java.awt.BorderLayout;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JFrame {

	private static Board window = null;
	private JPanel contentPane;
	private JTextField textField;
	private JLayeredPane layeredPane;

	/**
	 * Launch the board in singleton Mode.
	 */
	public static void startBorad() {
		if (window != null)
			return;
		
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Singleton Constructor.
	 */
	private Board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 719);	
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
		
		textField = new JTextField();
		textField.setBounds(313, 634, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Fire!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMiss();
			}
		});
		btnNewButton.setBounds(401, 633, 55, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblBoard = new JLabel("");
		lblBoard.setBackground(Color.MAGENTA);
		lblBoard.setBounds(5, 5, 1024*3/4, 823*3/4);
		setBoardScaledImage(lblBoard);
		layeredPane.add(lblBoard);
		
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
	
	private void setMissScaledImage(JLabel lbl){
        BufferedImage image = null;
        try {
            image = ImageIO.read(Board.class.getResource("/resources/miss.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

       Image img= image.getScaledInstance((int)(79*3/4), (int)(33*3/4),
                Image.SCALE_SMOOTH);

        lbl.setIcon(new ImageIcon(img));
    }	
	private void showMiss()
	{
		JLabel lblMiss = new JLabel("", SwingConstants.CENTER);
		lblMiss.setBounds(280, 285, 67, 67);
		setMissScaledImage(lblMiss);
		layeredPane.setLayer(lblMiss, 1);		
		
		layeredPane.add(lblMiss);
	}
}
