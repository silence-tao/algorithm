package com.silentao.structures.union;

/**
 * @Description
 * @Author Silence
 * @Date 2018/9/2 10:14
 **/
public class QuickFind implements Union {

    /**
     * 用来存放元素所在集合的id
     */
    private int[] ids;

    /**
     * 所有元素的个数
     */
    private int size;

    public QuickFind(int size) {
        this.size = size;
        this.ids = new int[size];

        for (int i = 0; i < size; i++) {
            this.ids[i] = i;
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

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return ;
        }

        for (int i = 0; i < this.size; i++) {
            if (this.ids[i] == pId) {
                this.ids[i] = qId;
            }
        }
    }

    @Override
    public int find(int p) {
        if (p < 0 ||
                p > this.size) {
            System.out.println("p不在范围内");
        }

        return this.ids[p];
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

        return this.ids[p] == this.ids[q];
    }

    @Override
    public String getName() {
        return "quickFind";
    }
}
