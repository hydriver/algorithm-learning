package chapter_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestStack {
    public static void main(String[] args) {
//        FixedCapacityStackOfString<String> s = new FixedCapacityStackOfString<String>(100);
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
        for (String item : s) {
            StdOut.println(item);
        }
    }
}
