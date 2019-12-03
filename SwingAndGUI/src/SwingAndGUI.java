import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingAndGUI {

	JFrame frame;
	JButton submitButton;
	JButton clearButton;
	JTextField textName;
	JTextField textAddress;
	
	public static void main(String[] args) {
		SwingAndGUI gui = new SwingAndGUI();
		gui.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		
		JPanel textPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonListener());
		submitButton.addKeyListener(new submitButtonKeyListener());
		submitButton.setEnabled(false);;
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonListener());
		clearButton.setEnabled(false);
		
		textName = new JTextField(5);
		textName.setBorder(LineBorder.createBlackLineBorder());
		textName.addKeyListener(new TextNameListener());
		textName.addFocusListener(new TextNameFocusListener());

		textAddress = new JTextField(20);
		textAddress.setBorder(LineBorder.createBlackLineBorder());
		textAddress.addKeyListener(new TextAddressListener());
		textAddress.addFocusListener(new TextAddressFocusListener());
		
		JLabel labelName = new JLabel("Name ");
		JLabel labelAddress = new JLabel("Address ");
		
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setVerticalAlignment(SwingConstants.CENTER);
		labelAddress.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddress.setVerticalAlignment(SwingConstants.CENTER);
	
		GridLayout grid = new GridLayout(3,2);
		grid.setVgap(100);
		textPanel.setBorder(BorderFactory.createEmptyBorder(100, 700, 100, 700));
		textPanel.setBackground(Color.PINK);
		textPanel.setLayout(grid);
				
		textPanel.add(labelName);
		textPanel.add(textName);
		textPanel.add(labelAddress);
		textPanel.add(textAddress);
			
		buttonsPanel.setBackground(Color.PINK);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(100, 70, 70, 100));
		buttonsPanel.setLayout(new FlowLayout());
	
		buttonsPanel.add(submitButton);
		buttonsPanel.add(clearButton);    
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1,0,100));
		frame.getContentPane().setBackground(Color.PINK);
				
		frame.add(textPanel);
		frame.add(buttonsPanel);
		
		frame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().width - 50, (int)Toolkit.getDefaultToolkit().getScreenSize().height - 50);
		frame.setVisible(true);
	}
	
	class TextNameFocusListener implements FocusListener {

		public void focusGained(FocusEvent event) {
			
		}

		public void focusLost(FocusEvent event) {
			
			String name = textName.getText();
			
			if(name.length() > 0) {
				if(Character.isWhitespace(name.charAt(0))) {
					name = name.trim();
					textName.setText(name);
				}
			}
			if(name.length() == 0 ) {
				textName.setText("");
				textName.requestFocusInWindow();
				submitButton.setEnabled(false);
				clearButton.setEnabled(false);
				JOptionPane.showMessageDialog(textName , "please enter valid name!*");
				textName.requestFocusInWindow();
			}
		}
	}
	
	class TextAddressFocusListener implements FocusListener {

		public void focusGained(FocusEvent arg0) {
			
		}

		public void focusLost(FocusEvent arg0) {

			String address = textAddress.getText();
			
			if(address.length() > 0) {
				if(Character.isWhitespace(address.charAt(0))) {
					address = address.trim();
					textAddress.setText(address);
				}
			}
			if(address.length() == 0 ) {
				textAddress.setText("");
				textAddress.requestFocusInWindow();
				submitButton.setEnabled(false);
				clearButton.setEnabled(false);
				JOptionPane.showMessageDialog(textAddress , "please enter valid address!");
				textName.requestFocusInWindow();
			}
		}
		
	}
	

	class TextNameListener implements KeyListener {
		
		public void keyListener(KeyEvent event) {
			
			String name = textName.getText();
						
			if (!name.isEmpty() || name != null) {
				for(char c : name.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
					}
					if(Character.isDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
					}
				}
			}
		}
		
		public void keyReleased(KeyEvent event) {
				
				String name = textName.getText();
							
				if (!name.isEmpty() || name != null) {
					for(char c : name.toCharArray()) {
						if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
							textName.setText("");
							textName.requestFocusInWindow();
							JOptionPane.showMessageDialog(textName , "please enter valid name!");
							submitButton.setEnabled(false);
							clearButton.setEnabled(false);
						}
						if(Character.isDigit(c)) {
							textName.setText("");
							textName.requestFocusInWindow();
							JOptionPane.showMessageDialog(textName , "please enter valid name!");
							submitButton.setEnabled(false);
							clearButton.setEnabled(false);
						}
						if(event.getKeyCode() == KeyEvent.VK_ENTER) {
							textAddress.requestFocusInWindow();
						}
						
						//enter code here
					}
				}
		}
		
		public void keyTyped(KeyEvent event) {
			
			String name = textName.getText();
			int length = name.length();
			
			if (!name.isEmpty() || name != null) {
				
				for(char c : name.toCharArray()) {
				
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
						submitButton.setEnabled(false);
						clearButton.setEnabled(false);
						length--;
					}
					
					if(Character.isDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
						submitButton.setEnabled(false);
						clearButton.setEnabled(false);
						length--;
					}
					
					if(Character.isWhitespace(c)) {
						length--;
					}
				}
				
				if (length > 0) {
					submitButton.setEnabled(true);
					clearButton.setEnabled(true);
				}
			}
		}
		
		public void keyPressed(KeyEvent event) {
			
			String name = textName.getText();
			
			if (!name.isEmpty() || name != null) {
				for(char c : name.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
					}
					if(Character.isDigit(c)) {
						textName.setText("");
						textName.requestFocusInWindow();
					}
				}
			}
		}
	}
	
	class TextAddressListener implements KeyListener {
		public void keyListener(KeyEvent event) {
			
			String address = textAddress.getText();
			
			if(!address.isEmpty() || address != null) {
				for(char c : address.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textAddress.setText("");
						textAddress.requestFocusInWindow();
					}
				}
			}
		}
		
		public void keyReleased(KeyEvent event) {
			
			String address = textAddress.getText();
			
			if(!address.isEmpty() || address != null) {
				for(char c : address.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textAddress.setText("");
						textAddress.requestFocusInWindow();
						JOptionPane.showMessageDialog(textName , "please enter valid address!");
						submitButton.setEnabled(false);
					}
					if(event.getKeyCode() == KeyEvent.VK_ENTER) {
						submitButton.requestFocusInWindow();
					}
				}
			}
		}
		
		public void keyTyped(KeyEvent event) {
			
			String address = textAddress.getText();
			
			if(!address.isEmpty() || address != null) {
				submitButton.setEnabled(true);
				for(char c : address.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textAddress.setText("");
						textAddress.requestFocusInWindow();
					}
				}
			}
		}
		
		public void keyPressed(KeyEvent event) {
			
			String address = textAddress.getText();
			
			if(!address.isEmpty() || address != null) {
				for(char c : address.toCharArray()) {
					if(!Character.isWhitespace(c) && !Character.isLetterOrDigit(c)) {
						textAddress.setText("");
						textAddress.requestFocusInWindow();
					}
				}
			}
		}
	}
	
	class SubmitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String name = textName.getText();
			JOptionPane.showMessageDialog(frame, "Welcome ".concat(name));
			submitButton.setEnabled(false);
			clearButton.setEnabled(false);
			textName.setEditable(false);
			textAddress.setEditable(false);
			frame.requestFocusInWindow();
		}
	}
	
	class submitButtonKeyListener implements KeyListener {
		
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_ENTER) {
				String name = textName.getText();
				JOptionPane.showMessageDialog(frame, "Welcome ".concat(name));
				submitButton.setEnabled(false);
				clearButton.setEnabled(false);
				textName.setEditable(false);
				textAddress.setEditable(false);
				frame.requestFocusInWindow();
			}
		}

		public void keyReleased(KeyEvent event) {
			submitButton.setEnabled(false);
			clearButton.setEnabled(false);
		}

		public void keyTyped(KeyEvent event) {
			submitButton.setEnabled(false);
			clearButton.setEnabled(false);
		}
	}
	
	class ClearButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			textName.setText("");
			textAddress.setText("");
			textName.requestFocusInWindow();
			submitButton.setEnabled(false);
			clearButton.setEnabled(false);
		}
				
	}
}

