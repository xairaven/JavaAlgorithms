import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque class
 * @author xairaven
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;   // first element
    private Node<Item> last;    // last element
    private int n;              // size of deque

    /**
     * Deque constructor
     */
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Inner class Node
     * @param <Item>
     */
    private static class Node<Item> {
        private Item item;             // Item
        private Node<Item> next;       // reference to next element
        private Node<Item> prev;       // reference to prev element
    }

    /**
     * Is deque empty?
     * @return <tt>boolean</tt>
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Get size of deque
     * @return <tt>int size</tt>
     */
    public int size() {
        return n;
    }

    /**
     * Add element to start of deque
     * @param item
     */
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        n++;
        if (n == 1) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
    }

    /**
     * Add element to end of deque
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    /**
     * Remove & get first item
     * @return <tt>generic type | first item</tt>
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first.item = null;
        first = first.next;
        if (first != null) first.prev = null;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    /**
     * Remove & get flat item
     * @return <tt>generic type | last item</tt>
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        if (first == last) {
            last = null;
            first = null;
        } else {
            last.item = null;
            last = last.prev;
            last.next = null;
        }
        n--;
        return item;
    }

    /**
     * Iterator for "for-each" loop
     * @return <tt>Iterator</tt>
     */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private static class DequeIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public DequeIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests
     * @param args
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 1; i < 50; i++) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        System.out.println("\nDeque:");
        for (int i : deque) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                deque.removeLast();
            } else {
                deque.removeFirst();
            }
        }
        System.out.println("\nDeque:");
        for (int i : deque) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\nSize: %d", deque.size());
    }
}
