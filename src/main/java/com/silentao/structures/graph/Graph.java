package com.silentao.structures.graph;

/**
 * @Description
 * @Author chentao10
 * @Date 2018/9/3 19:58
 **/
public interface Graph {

    /**
     * 获取节点数
     * @return
     */
    int getNode();

    /**
     * 获取边数
     * @return
     */
    int getEdge();

    /**
     * 将节点v、w建立连接
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 节点v、w是否连接
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     * 输出图
     */
    void show();

    /**
     * 设置当前访问的节点
     * @param current
     */
    void setCurrent(int current);

    /**
     * 和当前节点相连的第一个节点
     * @return
     */
    public abstract int begin();

    /**
     * 和当前节点相连的下一个节点
     * @return
     */
    public abstract int next();

    /**
     * 当前所以是否到最后
     * @return
     */
    public abstract boolean end();
}
