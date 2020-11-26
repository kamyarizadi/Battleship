package battleship.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.nio.file.Paths;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board {

	private JFrame frame;
	private static Board window = null;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JLabel lblBoard;

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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 932, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setVerticalAlignment(SwingConstants.TOP);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.RED, 4));
		//System.out.println("$"+Paths.get(".").toAbsolutePath().normalize().toString());
		//lblBoard.setIcon(new ImageIcon(Board.class.getResource("/resources/board.jpg")));
		setBoardScaledImage(lblBoard);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 918, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setHonorsVisibility(false);
		frame.getContentPane().setLayout(groupLayout);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Fire!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(393)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnNewButton))
						.addComponent(lblBoard, Alignment.TRAILING))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblBoard)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton)))
		);
		panel.setLayout(gl_panel);
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
