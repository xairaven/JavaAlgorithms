import java.util.Iterator;
/**
 * Test client for stack
 * Alex Kovalyov, 03.02.2022
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for(Integer i: stack) {
            System.out.println(i);
        }
    }
}
