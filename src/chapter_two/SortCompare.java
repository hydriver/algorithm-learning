package chapter_two;

import chapter_one.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
    public static double timeRandomInput(SortMethod algorithm, int N, int T) {
        // 使用algorithm将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(algorithm, a);
        }
        return total;
    }

    public static double time(SortMethod alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        alg.sort(a);
        return timer.elapseTime();
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
//        double t1 = timeRandomInput(Insertion::sort, N, T);
//        double t2 = timeRandomInput(a -> Selection.sort(a), N, T);
        double t2 = timeRandomInput(Shell::sort, N, T);
//        double t1 = timeRandomInput(Insertion::sort, N, T);
        StdOut.printf("For %d random Doubles\n", N);
//        StdOut.printf("t1 / t2 = %.1f", t1 / t2);
        StdOut.printf("t2 = %.1f", t2 / 100);
    }
}
