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
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Board2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board2 frame = new Board2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Board2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 719);	
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setBackground(Color.BLACK);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.RED, 3));
		layeredPane.setBackground(Color.BLACK);
		contentPane.add(layeredPane);
		
		textField = new JTextField();
		textField.setBounds(313, 634, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Fire!");
		btnNewButton.setBounds(401, 633, 55, 23);
		layeredPane.add(btnNewButton);
		
		JLabel lblBoard = new JLabel("New label");
		lblBoard.setBackground(Color.MAGENTA);
		lblBoard.setBounds(5, 5, 1024*3/4, 823*3/4);
		setBoardScaledImage(lblBoard);
		layeredPane.add(lblBoard);
	}

	
	public void setBoardScaledImage(JLabel lblBoard){
        BufferedImage image = null;
        try {
            image = ImageIO.read(Board.class.getResource("/resources/board.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image img= image.getScaledInstance((int)(512*1.5), (int)(430*1.5),
                Image.SCALE_SMOOTH);

        lblBoard.setIcon(new ImageIcon(img));
    }	
}
