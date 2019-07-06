package inventory;

import java.util.Comparator;

public class CompareName implements Comparator<Item> {

    public int compare(Item obj1,Item ob2){
        return obj1.getName().compareTo(ob2.getName());
    }


}

