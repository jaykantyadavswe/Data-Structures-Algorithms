package DSA.Hashing;

import java.util.*;

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>(); //Based on Key Sorted
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap(); //follow Order
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        HashMap<String, Integer> hm = new HashMap();//Random Store
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        
        System.out.println(tm);
        System.out.println(lhm);
        System.out.println(hm);
    }
}
