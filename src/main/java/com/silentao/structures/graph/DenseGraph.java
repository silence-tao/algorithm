package com.silentao.structures.graph;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description
 * @Author chentao10
 * @Date 2018/9/4 13:15
 **/
public class DenseGraph implements Graph {

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
     * 邻接表数据
     */
    private List<List<Boolean>> graph;

    /**
     * 当前访问的节点
     */
    private int current;

    /**
     * 当前访问的索引
     */
    private int index;

    public DenseGraph(int node) {
        this.node = node;
        this.edge = 0;

        graph = Lists.newArrayList();
        for (int i = 0; i < node; i++) {
            List<Boolean> booleans = Lists.newArrayList();
            graph.add(booleans);

            for (int j = 0; j < node; j++) {
                booleans.add(false);
            }
        }
    }

    public DenseGraph(int node, boolean directed) {
        this.node = node;
        this.edge = 0;
        this.directed = directed;

        graph = Lists.newArrayList();
        for (int i = 0; i < node; i++) {
            List<Boolean> booleans = Lists.newArrayList();
            graph.add(booleans);

            for (int j = 0; j < node; j++) {
                booleans.add(false);
            }
        }
    }

    @Override
    public int getNode() {
        return this.node;
    }

    @Override
    public int getEdge() {
        return this.edge;
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 ||
                v >= this.node ||
                w < 0 ||
                w >= this.node) {
            System.out.println("节点超出范围");

            return ;
        }

        if (hasEdge(v, w)) {
            System.out.println("节点v、w已建立连接");

            return ;
        }

        graph.get(v).set(w, true);
        if (!directed) {
            graph.get(w).set(v, true);
        }

        this.edge++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 ||
                v >= this.node ||
                w < 0 ||
                w >= this.node) {
            System.out.println("节点超出范围");

            return false;
        }

        return graph.get(v).get(w);
    }

    @Override
    public void show() {
        for (int i = 0; i < this.node; i++) {
            for (int j = 0; j < this.node; j++) {
                System.out.println(graph.get(i).get(j) + "\t");
            }

            System.out.println();
        }
    }

    @Override
    public void setCurrent(int current) {
        if (current < 0 ||
                current >= this.node) {
            System.out.println("节点超出范围");

            current = 0;
        }

        this.current = current;
    }

    @Override
    public int begin() {
        this.index = -1;

        return this.next();
    }

    @Override
    public int next() {
        for (this.index += 1; this.index < this.node; this.index++) {
            if (graph.get(this.current).get(this.index)) {
                return this.index;
            }
        }

        return -1;
    }

    @Override
    public boolean end() {
        return this.index >= this.node;
    }
}
