package inventory;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AddGUI extends JFrame implements ActionListener{

	UI ui = new UI();
	
	JLabel name = new JLabel("Item Name:");
	JTextField itemName = new JTextField(20); //Text input for item name
	JLabel amt = new JLabel("Number of units:");
	JTextField itemAmt= new JTextField(20); //Text input for item amount
	JLabel price = new JLabel("Price per unit:");
	JTextField itemPrice= new JTextField(20); // Text input for item price
	JLabel limit = new JLabel("Stock re-fill limit:");
	JTextField itemLimit= new JTextField(20); // Text input for item limit
	JLabel description = new JLabel("Item description:");
	JTextArea itemDescription= new JTextArea(5,20); //Text area for item description
	JPanel panel;
	JButton save = new JButton("Submit"); //Button group for radio buttons for gender
	
	


	public AddGUI() {
		
		super("Add Item");
		panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		setSize(800,750);
        setLocation(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		save.setBounds(25,40,150,20);
		itemName.setBounds(25,40,150,20);
		itemAmt.setBounds(25,40,150,20);
		itemPrice.setBounds(25,40,150,20);
		itemLimit.setBounds(25,40,150,20);
		itemDescription.setBounds(25,40,150,20);
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;  
		save.addActionListener(this);
		panel1.add(name);
		panel1.add(itemName);
		panel2.add(amt);
		panel2.add(itemAmt, constraints);
		panel3.add(price);
		panel3.add(itemPrice, constraints);
		panel4.add(limit);
		panel4.add(itemLimit, constraints);
		panel5.add(description);
		panel5.add(itemDescription, constraints);
		panel.add(panel1, constraints);
		panel.add(panel2, constraints);
		panel.add(panel3, constraints);
		panel.add(panel4, constraints);
		panel.add(panel5, constraints);
		
		 constraints.gridx = 0;
	        constraints.gridy = 2;
	        constraints.gridwidth = 2;
	        constraints.anchor = GridBagConstraints.WEST;
		panel.add(save, constraints);
		
		getContentPane().add(panel);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Main Menu"));
		pack(); 
		setVisible(true); 
		
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
		String name = itemName.getSelectedText();
		String temp = itemAmt.getSelectedText();
		int num = 0;
		num =Integer.parseInt(temp);
		String temp2 = itemPrice.getSelectedText();
		double price = Double.parseDouble(temp2)+1;
		String temp3 = itemLimit.getSelectedText();
		int limit = Integer.parseInt(temp3)+1;
		String description = itemDescription.getSelectedText();
		ui.addItem(name, num, price, limit, description);
		JOptionPane.showMessageDialog(null, "Correct Information", "Correct",
                JOptionPane.INFORMATION_MESSAGE);

	}


	public static void main(String[] args) {
		AddGUI stress = new AddGUI();
	}

	
}