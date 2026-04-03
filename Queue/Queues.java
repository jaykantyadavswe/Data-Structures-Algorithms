package DSA.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    // Java Collection FrameWorks
    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>(); //arrayDeque
        Queue<Integer> q = new ArrayDeque<>(); //arrayDeque
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
