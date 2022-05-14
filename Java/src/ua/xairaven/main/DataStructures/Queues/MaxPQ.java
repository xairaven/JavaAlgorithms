package ua.xairaven.main.DataStructures.Queues;
import edu.princeton.cs.algs4.In;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] pq;
    private int N;

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity+1];
        N = 0;
    }

    public MaxPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Comparable[keys.length + 1];
        for (int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for (int k = N/2; k >= 1; k--)
            sink(k);
    }

    public void insert(Key v) {
        if (N >= pq.length - 1) resize(2 * pq.length);
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("priority queue underflow");
        return pq[1];
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("priority queue underflow");
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k/=2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k , j);
            k = j;
        }
    }

    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;

        public HeapIterator() {
            copy = new MaxPQ<>(size());
            for (int i = 1; i <= N; i++) copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

    // tests
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>();
        In in = new In(args[0]);        // Java/res/txt_files/tinyPQ.txt
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) System.out.print(pq.delMax() + " ");
        }
        System.out.println("(" + pq.size() + " left on pq)");
    }
}

