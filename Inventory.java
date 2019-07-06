package inventory;

import java.util.*;
import java.io.*;

public class Inventory implements Serializable{

    ArrayList<Item> store = new ArrayList<Item>();
    Item item;
    File f = new File("Storage File");


    public Inventory(){
    }

    public void addItem(String name,int amount,double price,int limit,String description){
        store.add(item = new Item(name,amount,price,limit,description));
    }

    public void saveAll(){
        WriteObjectToFile();
        for(Item i:store){
            i.saveFile();
        }
    }

    public int help(String name){
        Item i = new Item(null,0,0.0,0,null);
        i.setName(name);
        return Collections.binarySearch(store,i,new CompareName());
    }

    public void delete(String str,String key){
        try {
            if (str.equals("Name")) {
                Collections.sort(store);
                int k = help(key);
                store.remove(k);
            } else if (str.equals("ID")) {
                Collections.sort(store);
                store.remove(Integer.parseInt(key));
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void WriteObjectToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(f);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(store);
            objectOut.close();
            System.out.println("The Object was written to file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ReadObjectFromFile() {

        try {
            ArrayList<Item> temp = new ArrayList<Item>();
            FileInputStream fileIn = new FileInputStream("Java");
            ObjectInputStream objectOut = new ObjectInputStream(fileIn);
            temp= (ArrayList<Item>) objectOut.readObject();
            objectOut.close();
            store = temp;
            System.out.println("The Object successfully read from file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void calc(String str,double amt){
        int key = help(str);


        int num = (int)(amt / store.get(key).getPrice());
        store.get(key).setAmount("D",num);
        System.out.println("The number of units sold is: "+num+"\n"+"Stock has been reduced by this number");

    }

    public void aCalc(String str,double amt){
    	
    	try {
	        int key = help(str);
	
	
	        int num = (int)(amt / store.get(key).getPrice());
	        store.get(key).setAmount("A",num);
	        System.out.println("The number of units bought is: "+num+"\n"+"Stock has been increased by this number");
    	}
    	catch(NullPointerException e){
    		e.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    public int wordCheck(String str){
        int k=0;
        int length = str.length();
        char c = str.charAt(0);
        String caps= String.valueOf(c).toUpperCase()+str.substring(1,length);
        String lower= String.valueOf(c).toLowerCase()+str.substring(1,length);
        String allCaps = str.toUpperCase();
        String allLower = str.toLowerCase();
        System.out.println(caps+"\n"+lower+"\n"+allCaps+"\n"+allLower);
        int opt1 = help(caps);
        int opt2 = help(lower);
        int opt3 = help(allCaps);
        int opt4 = help(allLower);
        int opt5 = help(str);
        int[] intArray = new int[]{ opt1,opt2,opt3,opt4,opt5 };
        for(int i=0;i<5;i++){
            if(intArray[i]>0 && intArray[i]<store.size() ){
                k=i;
            }
        }System.out.println(k);
        return k;
    }

    public String showInformation(String str){

        int key=wordCheck(str);
        return store.get(key).toString();

        }
    public String showAll(){
        String info ="";
        for(Item i:store){
            info+=i.toString()+"\n";
        }return info;
    }

    public void add(String str,int amt){
        int key = help(str);
        store.get(key).setAmount("A",amt);
        System.out.println("Stock has been updated. \n New stock level is :"+store.get(key).getAmount());
    }
    public void readigStockFile(){
        item.readFile();
    }
    public void savingStockFile() {
    	item.saveFile();
    }
    
    public void changeDetails(String str,String inst,String unit) throws IOException {
    	try {
    		
    		int key= help(str);
    	
	    	if(inst.equals("Name")) {
	    		store.get(key).setName(unit);
	    	}
	    	else if(inst.equals("Price")) {
	    		double price = Double.parseDouble(unit);
	    		store.get(key).setPrice(price);
	    	}
	    	else if(inst.equals("Limit")) {
	    		int limit = Integer.parseInt(unit);
	    		store.get(key).setLimit(limit);
	    	}
	    	else if(inst.equals("Description")) {
	    		store.get(key).setDescription(unit);
	    	}
    	}
    	catch(NullPointerException e) {
    		e.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }

    public static void main(String[]args){
        Inventory in = new Inventory();
        in.addItem("name",50,50.5,7,"hello");
       System.out.println(in.showInformation("name"));

    }

}

