package DSA.Hashing;
import java.util.*;
import java.util.LinkedHashMap;

public class LinkedHashMaps {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap(); //follow Order
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        HashMap<String, Integer> hm = new HashMap();//Random Store
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        
        System.out.println(lhm);
        System.out.println(hm);
    }
}
