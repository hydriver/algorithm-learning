package chapter_one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    /**
     * 加权quick-union算法
     * 优化quick-union算法，避免大的树总连接到小的树
     * 在连接时，总是小的树连到大的树
     * 使用路径压缩
     */
    private int[] id;
    private int[] size;  // 以该触点为首的分量的大小
    private int count;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  // 以自己为连通分量
            size[i] = 1;  // 分量大小为1
        }
        count = N;
    }

    public int count() {
        // 连通分量个数
        return count;
    }

    public boolean connected(int p, int q) {
        // 两个触点是否连接
        return find(p) == find(q);
    }

    public int find(int p) {
        int pRoot = id[p];
        while (pRoot != id[pRoot]) {
            pRoot = id[pRoot];
        }
//        int front = id[p]; // 记住前一个结点
//        while (pRoot != front) {
//            id[p] = pRoot;
//            p = front;
//            front = id[p];
//        }
        // 压缩路径
        int current = p;
        while (current != id[current]) {
            int front = id[current];
            if (id[current] != pRoot) {
                id[current] = pRoot;
            }
            current = front;
        }
        return pRoot;
    }

    public void union(int p, int q) {
        // 将小数连到大树上
        int pRoot = find(p);
        int qRoot = find(q);

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        // 方法库的用例
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new  WeightedQuickUnionUF(N);
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
