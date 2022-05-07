package ua.xairaven.main.DataStructures.SymbolTables;
import ua.xairaven.main.DataStructures.Queues.Queue;

/**
 * SYMBOL TABLE
 * Implementation of Sequential Search ST<br>
 * Date: 10.04.2022
 * @author Alex "xairaven" Kovalyov
 */
public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("Key is null");
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    // tests
    public static void main(String[] args) {
        SequentialSearchST<Integer, Integer> st = new SequentialSearchST<>();
        for (int i = 0; i < 10; i++) {
            st.put(i*100, i);
        }
        System.out.println("SequentialSearchST:");
        for (int a : st.keys()) {
            System.out.println("Key: " + a + " Value: " + st.get(a));
        }
    }
}

