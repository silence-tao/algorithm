package com.silentao.structures.union;

/**
 * @Description
 * @Author Silence
 * @Date 2018/9/2 11:42
 **/
public class QuickUnion1 implements Union {

    /**
     * 用来保存指向父节点的数组下标
     */
    private int[] parents;

    /**
     * 所有元素的个数
     */
    private int size;

    public QuickUnion1(int size) {
        this.size = size;
        this.parents = new int[size];

        for (int i = 0; i < size; i++) {
            this.parents[i] = i;
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

        if (pRoot == qRoot) {
            return ;
        }

        parents[pRoot] = qRoot;
    }

    @Override
    public int find(int p) {
        if (p < 0 ||
                p > this.size) {
            System.out.println("p不在范围内");
        }

        while (p != parents[p]) {
            p = parents[p];
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
        return "quickUnion1";
    }
}
