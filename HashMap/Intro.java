package HashMap;

import java.util.HashMap;
import java.util.Set;

public class Intro {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India", 135);
        hm.put("China", 150);
        hm.put("Us", 35);
        hm.put("Uk", 20);

        // Printing elements in object of Map
        System.out.println(hm);
        // Printing elements in object of Map one by one
        for(String key:hm.keySet()){
            Integer val=hm.get(key);
            System.out.println(key+" "+val);
        }

        //Print all the keys
        Set<String> keys=hm.keySet();
        System.out.println(keys);
    }
}
