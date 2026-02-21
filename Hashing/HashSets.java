package DSA.Hashing;

import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        /* System.out.println(set);
        System.out.println(set.isEmpty());
        set.clear();
        set.remove(2);
        if(set.contains(2)){
            System.out.println("Set contains 2");
        }

        System.out.println(set.size()); */

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        /* Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        } */

        for(String city : cities){
            System.out.println(city);
        }
    }
}
