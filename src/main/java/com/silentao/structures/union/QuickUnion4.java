package com.silentao.structures.union;

/**
 * @Description
 * @Author Silence
 * @Date 2018/9/2 14:41
 **/
public class QuickUnion4 implements Union {

    /**
     * 用来保存指向父节点的数组下标
     */
    private int[] parents;

    /**
     * 所有元素的个数
     */
    private int size;

    /**
     * 表示以i为根的集合中元素的层数
     */
    private int[] rank;

    public QuickUnion4(int size) {
        this.size = size;
        this.parents = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            this.parents[i] = i;
            this.rank[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        if (p < 0 ||
                p > this.size ||
                q < 0 ||
                q > this.size) {
            System.out.println("p、q不在范围内");

            return;
        }

        int pRoot = find(p);
        int qRoot = find(q);

        if (this.rank[pRoot] < this.rank[qRoot]) {
            this.parents[pRoot] = qRoot;
        } else if (this.rank[qRoot] < this.rank[pRoot]) {
            this.parents[qRoot] = pRoot;
        } else {
            this.parents[pRoot] = qRoot;
            this.rank[qRoot] += 1;
        }
    }

    @Override
    public int find(int p) {
        if (p < 0 ||
                p > this.size) {
            System.out.println("p不在范围内");
        }

        while (p != this.parents[p]) {
            this.parents[p] = this.parents[this.parents[p]];
            p = this.parents[p];
        }

        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        if (p < 0 ||
                p > this.size ||
                q < 0 ||
                q > this.size) {
            System.out.println("p、q不在范围内");

            return false;
        }

        return find(p) == find(q);
    }

    @Override
    public String getName() {
        return "quickUnion4";
    }
}
