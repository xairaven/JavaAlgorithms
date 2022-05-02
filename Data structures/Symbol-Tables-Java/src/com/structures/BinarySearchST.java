package com.structures;
import edu.princeton.cs.algs4.Queue; // ANY QUEUE WITH ITERATOR
import java.util.NoSuchElementException;

/**
 * Implementation of Binary Search ST (USING ARRAY)<br>
 * Date: 01.05.2022
 * @author Alex "xairaven" Kovalyov
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() { return n; }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValue = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempValue[i] = values[i];
        }
        values = tempValue;
        keys = tempKeys;
    }

    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    public int rank(Key key) {
        if (key == null) throw new NullPointerException("Key is null");

        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val)  {
        if (key == null) throw new NullPointerException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) resize(2*keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = val;
        n++;

        assert check();
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        if (isEmpty()) return;

        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n - 1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        n--;
        keys[n] = null;  // to avoid loitering
        values[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);

        assert check();
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    public Key min() {
        if (isEmpty()) return null;
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) return null;
        return keys[n-1];
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= n) return null;
        return keys[rank];
    }

    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("Key is null");
        int i = rank(key);
        if (i == n) return null;
        else return keys[i];
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("Lo (given to size()) is null");
        if (hi == null) throw new NullPointerException("Hi (given to size()) is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("Lo (given to keys()) is null");
        if (hi == null) throw new NullPointerException("Hi (given to keys()) is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
}
