/**
 * Test client for queue
 * Alex Kovalyov, 03.02.2022
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            if (i == 5) queue.dequeue();
            if (i == 8) queue.dequeue();
            queue.enqueue(i);
        }
        for(Integer i: queue) {
            System.out.println(i);
        }
    }
}
