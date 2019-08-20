package chapter_one;

import edu.princeton.cs.algs4.StdOut;

public class Counter {
    /**
     * 我写的第一个类
     */
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
        count = 0;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        // return the count
        return count;
    }

    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads + " " + tails);
        StdOut.println(heads.tally() + tails.tally());
        StdOut.println(1 + 2 + "3");
        StdOut.println(-26 % 3);

    }
}
