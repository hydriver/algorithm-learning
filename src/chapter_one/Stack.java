package chapter_one;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    // 使用链表实现元素的存储
    private Node first;
    private int N; // 栈的大小

    private class Node {
        // 定义本数据结构中的节点结构
        Item item = null;
        Node next = null;
    }

    public Stack() {
        N = 0;
        first = null;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        // 初始化一个节点
        Node n = new Node();
        n.item = item;
        n.next = first;
        // 在头部插入节点
        first = n;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
