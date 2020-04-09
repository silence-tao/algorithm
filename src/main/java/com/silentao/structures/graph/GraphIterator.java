package com.silentao.structures.graph;

/**
 * @Description 图迭代器
 * @Author chentao10
 * @Date 2018/9/3 20:03
 **/
public abstract class GraphIterator {

    /**
     * 图中的节点数
     */
    private int node;

    /**
     * 图中的边数
     */
    private int edge;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 当前访问的节点
     */
    private int current;

    /**
     * 当前访问的索引
     */
    private int index;
}
