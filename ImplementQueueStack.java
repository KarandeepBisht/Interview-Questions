import java.util.*;

class ImplementQueueStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        static int deQueue() {
            if (s1.isEmpty()) {
                System.out.println("Q is empty");
                System.exit(0);
            }
            int x = s1.peek();
            s1.pop();
            return x;
        }
    };

    public static void main(String[] args) {
        Queue s = new Queue();
        s.enQueue(1);
        s.enQueue(2);
        s.enQueue(3);
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
    }
}