package chapter_one;

import java.util.Iterator;

public class FixedCapacityStackOfString<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfString(int cap) {
        a = (Item[]) new Object[cap];
    }

    private void resize(int max) {
        // 将原来的数据转移到新的数组中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * N);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;  // 将对象的使用权交给item
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 实现Iterable接口
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 内部类，实现迭代器接口
    private class ReverseArrayIterator implements Iterator<Item> {
        // 现在的数量
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
