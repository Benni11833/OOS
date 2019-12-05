package eventHandling1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class Eventhandler1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel = new JLabel("Frame zur Ereignisverarbeitung!!!");
	private JLabel textLabel = new JLabel("TextFeld:");
	private JTextField textField = new JTextField();
	private JButton okButton = new JButton("OK?");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventhandler1 frame = new Eventhandler1();
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
	public Eventhandler1() {
		setUpFrameContentsToFrame();
		addFrameContentsToFrame();
		setupFrame();
	}

	private void setupFrame() {
		setSize(400, 300);
		setTitle("Ereignisverarbeitung 1");
		setLayout(null);
		setVisible(true);
	}
	
	private void setUpFrameContentsToFrame() {
		titleLabel.setBounds(10, 40, 300, 30);
		textLabel.setBounds(10, 80, 300, 30);
		textField.setBounds(100, 80, 300, 30);
		okButton.setBounds(90, 150, 150, 30);
	
		okButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(textField.getText());
			}
		});
	}

	private void addFrameContentsToFrame() {
		add(titleLabel);
		add(textLabel);
		add(textField);
		add(okButton);
	}

	

}
