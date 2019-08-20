package chapter_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    /**
     * 实现队列，链式存储
     */
    private Node first;  //队首
    private Node last;  // 队尾
    private int N;  // 队长度

    private class Node {
        Item item;  // 装载的数据
        Node next;  // 指向下一个结点
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        // 在队尾加入
        // 我的实现
//        Node newNode = new Node();
//        newNode.item = item;
//        newNode.next = null;
//        if (isEmpty()) {
//            last = newNode;
//            first = last;
//        } else {
//            last.next = newNode;
//            last = newNode;
//        }
//        N++;
        // 其他实现
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        // 空队不能出列
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

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

    // 测试驱动
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left on queue)");
        for (String s : q) {
            StdOut.println(s);
        }
    }
}
