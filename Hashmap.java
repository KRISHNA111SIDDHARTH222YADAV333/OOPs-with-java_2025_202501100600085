import java.util.*;
public class HashMapdemo {
    public static void main(String[] args) {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(1, 10);
        hm.put(2, 20);
        hm.put(3, 30);
        System.out.println("HashMap: " + hm);     
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }          
    if(hm.containsKey(2)) {
            System.out.println("HashMap contains key 2");
        } else {
            System.out.println("HashMap does not contain key 2");
        }hm.put(10, 98);
        hm.remove(20); 
        System.out.println("Updated HashMap: " + hm);
    }
}
