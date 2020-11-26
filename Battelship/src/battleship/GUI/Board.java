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
import javax.swing.JLayeredPane;

public class Board {

	private JFrame frame;
	private static Board window = null;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JLabel lblBoard;
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
		frame.setBounds(100, 100, 784, 759);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.RED, 4));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 918, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(164))
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
		
		layeredPane = new JLayeredPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(307)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton))
						.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setVerticalAlignment(SwingConstants.TOP);
		//System.out.println("$"+Paths.get(".").toAbsolutePath().normalize().toString());
		//lblBoard.setIcon(new ImageIcon(Board.class.getResource("/resources/board.jpg")));
		setBoardScaledImage(lblBoard);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		layeredPane.setLayer(lblNewLabel, 1);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(774))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addComponent(lblBoard)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
					.addComponent(lblBoard)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(297))
		);
		layeredPane.setLayout(gl_layeredPane);
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
