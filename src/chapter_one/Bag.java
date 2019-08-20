package chapter_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private class Node {
        Item item = null;
        Node next = null;
    }

    private Node first;
    private int N;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Bag() {
        first = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public static void main(String[] args) {
        Bag<String>[] bags = (Bag<String>[]) new Bag[10];
        bags[0] = new Bag<String>();
        Bag<String> b = new Bag<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            b.add(s);
        }
        for (String s : b) {
            StdOut.println(s);
        }
    }
}
