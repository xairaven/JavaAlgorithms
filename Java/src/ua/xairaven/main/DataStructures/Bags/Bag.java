package ua.xairaven.main.DataStructures.Bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    private class Node {
        private Item item;
        private Node next;

        // empty constructor
        public Node() {}

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.size;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        size++;
    }

    public Iterator<Item> iterator()  {
        return new BagIterator(first);
    }

    private class BagIterator implements Iterator<Item> {
        private Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        for (int i = 1; i <= 10; i++) {
            bag.add(i);
        }
        System.out.println("Bag size: " + bag.size());
        System.out.println("Is bag empty?: " + bag.isEmpty());
        System.out.println("\nBag:");
        for (int i : bag) {
            System.out.print(i + " ");
        }
    }
}

