package DSA.LinkedList;
import java.util.*;
import java.util.LinkedList;

public class LLUsingFrameworks {
    public static void main(String[] args) {
        // Java Collection Framework
        // create
        LinkedList<Integer> ll = new LinkedList<>();

        // Add
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(0);
        // 0->1->2
        System.out.println(ll);

        // Remove
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
