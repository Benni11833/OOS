package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SwingDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	class myKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			System.out.println("Pressed key: " + arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			System.out.println("Released key: " + arg0);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			System.out.println("Typed key: " + arg0);
		}

		
	}
	
	private JLabel titleLabel = new JLabel("Mein erstes Frame");
	private JLabel nameLabel = new JLabel("Name");
	private JTextField nameTextField = new JTextField();
	private JLabel passwordLabel = new JLabel("Passwort");
	private JPasswordField passwordField = new JPasswordField();
	private JCheckBox checkBox = new JCheckBox("checkBox");
	private JButton ausfuehrenButton = new JButton("Ausführen");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingDialog frame = new SwingDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingDialog() {
		setUpFrameContentsToFrame();
		addFrameContentsToFrame();
		setupFrame();
		
	}

	private void setupFrame() {
		setSize(400, 300);
		setTitle("AnmeldungFrame");	
		setLayout(null);
		setVisible(true);
	}

	private void setUpFrameContentsToFrame() {
		Color labelColor = new Color(102, 102, 153);
		
		titleLabel.setBounds(40, 10, 320, 40);
		titleLabel.setFont(new Font("Serif", 1, 20));
		titleLabel.setForeground(labelColor);
		
		nameLabel.setBounds(30, 50, 100, 40);
		nameLabel.setFont(new Font("Arial", 1, 14));
		nameLabel.setForeground(labelColor);
		
		nameTextField.setBounds(150, 50, 150, 30);
		
		passwordLabel.setBounds(30, 100, 100, 40);
		passwordLabel.setFont(new Font("Arial", 1, 14));
		passwordLabel.setForeground(labelColor);
		
		passwordField.setBounds(150, 100, 150, 30);
		passwordField.setEchoChar('*');
		
		checkBox.setBounds(150, 150, 150, 30);
		checkBox.setSelected(true);
		checkBox.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Checkbox: " + checkBox.isSelected());
						nameTextField.setEditable(checkBox.isSelected());
					}
				}
			);
		
		ausfuehrenButton.setBounds(150, 200, 150, 30);
		ausfuehrenButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(nameTextField.getText().equals(
						passwordField.getText())
				);
			}
		});
	}

	private void addFrameContentsToFrame() {
		add(titleLabel);
		add(nameLabel);
		add(nameTextField);
		add(passwordLabel);
		add(passwordField);
		add(checkBox);
		add(ausfuehrenButton);
	}
	
	

}