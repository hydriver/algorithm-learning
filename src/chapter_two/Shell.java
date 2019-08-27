package chapter_two;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
    // 希尔排序
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 产生一个序列 1, 4, 13, ...
        // 递推式b(n+1) = 3b(n) + 1
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }
        h /= 3;
        // 前h个元素不用排序，相当于子序列只有一个元素
        // for循环相当于进行一次相隔h的插入排序
        // 每个完整的h序列排序穿插进行
        // 如{a[1], a[3], a[5]}和{a[2], a[4], a[6]} 先排{a[1], a[3]}，然后排{a[2], a[4]}，
        // 再排{a[1], a[3], a[5]}，最后排{a[2], a[4], a[6]}
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                Comparable elemTemp = a[i];
                int j = 0;
                for (j = i - h; j >= 0 && less(elemTemp, a[j]) ; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = elemTemp;
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable elemTemp = a[i];
        a[i] = a[j];
        a[j] = elemTemp;
    }

    private static void show(Comparable[] a) {
        for (Comparable elem : a) {
            StdOut.print(elem + " ");
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
        StdOut.println();
        sort(a);
        show(a);
    }
}
