package DSA.Stacks;
import java.util.*;

// Using Java Collection FrameWorks implement Stack
public class CollectionFrameWorks {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
