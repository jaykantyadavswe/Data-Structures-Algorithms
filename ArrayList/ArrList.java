package DSA.ArrayList;

import java.util.ArrayList;

public class ArrList {
    public static void main(String[] args) {
        // Java Collection Framework
        // ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Float> lists = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // add operation - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(1, 9);

        System.out.println(list.size());

        System.out.println(list);

        // Get Operations - O(1)
        int ele = list.get(2);
        System.out.println(ele);

        // Delete - O(n)
        list.remove(2);
        System.out.println(list);

        // Set - O(n)
        list.set(2, 5);
        System.out.println(list);

        // Contain Element 
        System.out.println(list.contains(5));
        System.out.println(list.contains(66));
    }
}
