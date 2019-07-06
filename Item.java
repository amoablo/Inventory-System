package inventory;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Item implements Comparable<Item>,Serializable{

    private String name;
    private int amount;
    private double price;
    private static int count =0;
    private int id;
    private int limit;
    private String description;
    File file = new File("Stock File.txt");


    public  Item(String name,int amount,double price,int limit,String description){
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.limit=limit;
        this.description=description;
        this.id=count+1;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Done");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Done");
    }

    public int getId() {
        return id;
    }

    public void setAmount(String response,int amount){
        try {
            if (response.equals("D")) {//D stands for delete or reduce
                this.amount -= amount;
                lowStock();
            } else if (response.equals("A")) {// A stands for add
                this.amount += amount;
            } else this.amount = amount;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void lowStock(){
        if(amount<=limit){
            System.out.println("Stock level is at "+amount+",please refill stock");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Done");
    }

    public void setLimit(int limit) {
        this.limit = limit;
        System.out.println("Done");
    }

    public static int getCount() {
        return count;
    }

    public int getLimit() {
        return limit;
    }

    public int getAmount(){
        return amount;
    }

    public String toString() {
        return "\nItem Name:\t"+getName()+"\nStock No.:\t"+getAmount()+"\nPrice per item: "+getPrice()+
                "\nItem ID:\t"+getId()+"\nItem Description: "+getDescription()+
                "\nItem Stock limit: "+getLimit();
    }

    public String time() {
        //Displaying current date and time in 12 hour format with AM/PM
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm aa");
        String dateString = dateFormat.format(new Date());
        return dateString;
        }

    public void saveFile(){

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Stock File has been created");
            }
            else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                System.out.println(line);
                if (line.equals(null)){
                    FileWriter f = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(f);
                    bw.write(toString()+"\n"+time());
                    bw.close();
                }
                else{
                    String textToAppend = toString();
                    BufferedWriter writer = new BufferedWriter(
                            new FileWriter(file, true)  //Set true for append mode
                    );
                    writer.newLine();   //Add new line
                    writer.write(textToAppend);
                    writer.close();
                }
            }
                System.out.println(("File found saving will commence"));
        }catch (IOException e){
            e.printStackTrace();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readFile(){
        String text="";
        try {
            FileReader fr = new FileReader("Stock File.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                text+=(line+"\n");
                line=br.readLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(text);
    }

    public static void main(String[]args) {
        Item box = new Item("Box", 50, 10.5, 10, "10x2");
        Item ox = new Item("Box", 50, 10.5, 10, "10x2");
        System.out.println(box.getId());
    }


    @Override
    public int compareTo(Item o) {
        if(this.id == o.getId())
            return 0;
        else
            return this.id > o.getId() ? 1 : -1;
    }
}

