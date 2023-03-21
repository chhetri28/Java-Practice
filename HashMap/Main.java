package HashMap;

public class Main {
    public static void main(String[] args) {
        MyHash<String,Integer> hm=new MyHash<>();
        hm.put("India", 135);
        hm.put("China", 150);
        hm.put("Us", 35);
        hm.put("Uk", 20);
        for (String key : hm.keySet()) {
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}
