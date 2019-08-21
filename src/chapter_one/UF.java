package chapter_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * API说明
 * --
 * name: UF--union-find
 * --
 * * UF(int N) 初始化N个触点
 * * void union(int p, int q) 将触点p和触点q连接起来
 * * int find(int p) 寻找触点p所属的连通分量
 * * boolean connected(int p, int q) 触点p和触点q是否在同一个连通分量
 * * int count() 连通分量的个数
 */

public class UF {
    // 当成方法库使用
    private int[] id;  // 记录每个触点的连通分量，索引为触点
    private int count;  // 连通分量个数

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

//    public void union(int p, int q) {}

//    public int find(int p) {}

    /**
     * quick-find算法
     * find 操作非常快，每个id[]元素都存储触点对应的分量
     * 连接触点时,需将其中一个连通分量的触点全都改为另一个分量
     */
//    public void union(int p, int q) {
//        int pId = find(p);
//        int qId = find(q);
//
//        if (qId == pId) {
//            return;
//        }
//        // 以q的连通分量为根
//        for (int i = 0; i < id.length; i++) {
//            if (pId == id[i]) {
//                id[i] = qId;
//            }
//        }
//        // 两个连通分量合并为一个
//        count--;
//    }
//
//    public int find(int p) {
//        return id[p];
//    }


    /**
     * quick-union算法
     * 加快union的速度，但要减慢find的速度
     * id[]记录同一连通分量的相邻结点，构建一个森林，树的根为连通分量标记
     * 连接触点时，找到这两个触点的根，将一个根结点连接到另一个根结点
     * 找根时，像链表那样顺着id[]回溯
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count--;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public static void main(String[] args) {
        // 方法库的用例
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " <-> " + q);
            } else {
                continue;
            }
        }
        StdOut.println(uf.count() + " components");
    }
}
