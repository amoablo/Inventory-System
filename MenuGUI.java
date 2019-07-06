package inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame implements ActionListener{
	
	UI ui = new UI();
	
//Main menu GUI components
	
	private JButton AddItem= new JButton("Add Item");
	private JButton DeleteItem= new JButton("Delete Item");
	private JPanel panel;
	private JButton CalculateNumberSold= new JButton("Calculate Number of untils sold");
	private JButton Save= new JButton("Save");
	private JButton Iteminfo= new JButton("Item information");
	private JButton stockInfo= new JButton("Full Inventory information");
	private JButton editDetails= new JButton("Edit Item details");
	private JButton quit = new JButton("Quit");
	private JButton lastSaved = new JButton("Show last saved information");
	private JButton addUnits = new JButton("Add units to current item");
	
	//--------------------------------------------------------------------------------------------------------	
	
	public MenuGUI() {

		super("Inventory System");
		panel = new JPanel(new FlowLayout());
		setSize(600,550);
        setLocation(500,150);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AddItem.addActionListener(this);
		quit.addActionListener(this);
		
		
		
		
		panel.add(AddItem);
		panel.add(addUnits);
		panel.add(editDetails);
		panel.add(Iteminfo);
		panel.add(stockInfo);
		panel.add(lastSaved);
		panel.add(DeleteItem);
		panel.add(CalculateNumberSold);
		panel.add(Save);
		panel.add(quit);

        
		getContentPane().add(panel);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Main Menu"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
      
        
	}
		

	
	public static void main(String[]args) {
		MenuGUI gu = new MenuGUI();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		AddGUI gu = new AddGUI();
		gu.setVisible(true);
		
	}
	
	  public void login() {
	    	quit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	            	dispose();
	        		System.exit(ABORT);
	                            }
	        });
	    }
	  
	  
	  
	  
	
	
	
	
}