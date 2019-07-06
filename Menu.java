package inventory;

import java.awt.*;

import javax.swing.*;

public class Menu {
	
	private JFrame frame;
	private JPanel panel;
	private JButton opA;
	private JButton opB;
	private JLabel label;
	
	
	Menu() {
		
		frame = new JFrame();
		panel = new JPanel();
		opA = new JButton("Add Item");
		opB = new JButton("Calculat amount sold");
		label = new JLabel("To calculate amount will tell the number of items sold based on the value entered");
		panel.setPreferredSize(new Dimension(500, 750));
		panel.add(opA);
		panel.add(opB);
		panel.add(label);
		frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public static void main(String[]args) {
		Menu menu = new Menu();
	}

}
