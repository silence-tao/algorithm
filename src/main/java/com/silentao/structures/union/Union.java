package com.silentao.structures.union;

/**
 * @Description
 * @Author Silence
 * @Date 2018/9/2 9:51
 **/
public interface Union {

    /**
     * 将两个元素连接在一起
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * 找到p所在的集合
     * @param p
     * @return
     */
    int find(int p);

    /**
     * p q是否相连
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    String getName();
}
