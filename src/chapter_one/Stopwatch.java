package chapter_one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * Stopwatch 计时器
 * --
 * Stopwatch()  创建一个计时器
 * double elapseTime()  流逝的时间，计时器自创建以来流逝的时间
 */
public class Stopwatch {
    private final long startTime;

    public Stopwatch() {
        // 自1970.1.1到现在的毫秒数
        startTime = System.currentTimeMillis();
    }

    public double elapseTime() {
        long now = System.currentTimeMillis();
        return (now - startTime) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapseTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
