package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LoginGUI extends JFrame{
	Map<String, char[]> map = new HashMap<String, char[]>();
	int t = 3;
    UI ui = new UI();
    
    
  //--------------------------------------------------------------------------------------------------------	

        JLabel name2 = new JLabel("Name:");
		JLabel psword = new JLabel("Password:");
        JButton blogin = new JButton("Login");
        JPanel panel = new JPanel();
        JTextField txuser = new JTextField(8);
        JPasswordField pass = new JPasswordField(10);

              

        LoginGUI()
        {
            super("Inventory System");
            setSize(300,250);
            setLocation(600,250);
            panel.setLayout (null);

          
            name2.setBounds(25,40,150,20);
			txuser.setBounds(70,40,150,20);
            psword.setBounds(7,80,150,20);
            pass.setBounds(70,80,150,20);
            blogin.setBounds(180,130,80,20);

      
            panel.add(name2);
			panel.add(psword);
            panel.add(blogin);
            panel.add(txuser);
            panel.add(pass);
            

            map.put("test", "12345".toCharArray());
			map.put("admin", "admin".toCharArray());


            getContentPane().add(panel);
            panel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Login Panel"));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            actionlogin();
        }
        
      //--------------------------------------------------------------------------------------------------------	
        
		public void actionlogin() {
			
			blogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					String puname = txuser.getText();
					char[] ppaswd = pass.getPassword();
				if (map.keySet().contains(puname) && Arrays.equals(map.get(puname), ppaswd)) {
					JOptionPane.showMessageDialog(null, "Correct Information", "Correct",
                        JOptionPane.INFORMATION_MESSAGE);
					dispose();
					MenuGUI gu = new MenuGUI();
					gu.setVisible(true);
					
				} 
				
				else {
					JOptionPane.showMessageDialog(null, "Name/Password Not Found on System",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
					t--;
					if(t==0) {
						System.exit(0);
					}

               

                    JOptionPane.showMessageDialog(null,"Re-enter your password and Name to confirm", "Information Saved",
                         JOptionPane.INFORMATION_MESSAGE);
                            
                }	
            }
        });
  
}
		

public static void main(String[]args) {
	LoginGUI gu = new LoginGUI();
}

}
