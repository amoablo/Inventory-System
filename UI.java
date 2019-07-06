package inventory;

import java.util.*;


public class UI {
    Inventory warehouse = new Inventory();

    ArrayList<String> userRecord = new ArrayList<String>();
    String userName = "User";
    String password ="123";
    Inventory inventory = new Inventory();
    


    public void addItem(String name,int amount,double price,int limit,String description){
    	try{
    		inventory.addItem(name,amount,price,limit,description);
    	}
    	catch(Exception e ) {
    		System.out.println("A field you entered was incorrrect");
    		MenuGUI gui = new MenuGUI();
    	}
    }
    
    public void saveAll() {
    	inventory.saveAll();
    	inventory.savingStockFile();
    }
    
    public void deleteItem(String str,String key) {
    	try{
    		inventory.delete(str, key);
    	}catch(Exception e) {
    		System.out.println("A field you entered was incorrrect");
    		MenuGUI gui = new MenuGUI();
    	}
    }
    
    public void readFromStaticFile()throws Exception {
    	if(inventory.f.exists()) {
    		inventory.ReadObjectFromFile();
    	}
    }
    
    public void showAllInformation() {
    	inventory.showAll();
    }
    
    public void showLastThingSaved() {
    	inventory.readigStockFile();
    }
   
    
    public void saveToFile() {
    	inventory.WriteObjectToFile();
    }
    
    public void showItemInformation(String str) {
    	inventory.showInformation(str);
    }
    
    public void addUnits(String str,int amt) {
    	inventory.add(str, amt);
    }

    public boolean verifyUser(String user,String word){
        if(user.equals(userName)&& word.equals(password)){
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args){
       UI ui = new UI();
       System.out.println(ui.verifyUser("User", "123"));
    }


}

