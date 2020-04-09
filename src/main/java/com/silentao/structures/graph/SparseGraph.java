package com.silentao.structures.graph;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 邻接表
 * @Author chentao10
 * @Date 2018/9/3 14:00
 **/
public class SparseGraph implements Graph {

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
    private List<List<Integer>> graph;

    /**
     * 当前访问的节点
     */
    private int current;

    /**
     * 当前访问的索引
     */
    private int index;

    public SparseGraph(int node) {
        this.node = node;
        this.edge = 0;

        graph = Lists.newArrayList();
        for (int i = 0; i < node; i++) {
            graph.add(Lists.<Integer>newArrayList());
        }
    }

    public SparseGraph(int node, boolean directed) {
        this.node = node;
        this.directed = directed;
        this.edge = 0;

        graph = new ArrayList<>();
        for (int i = 0; i < node; i++) {
            graph.add(new ArrayList<Integer>());
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

        graph.get(v).add(w);
        if (v != w && !directed) {
            graph.get(w).add(v);
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

        for (int i = 0; i < graph.get(v).size(); i++) {
            if (graph.get(v).get(i).equals(w)) {
                return true;
            }
        }

        return false;
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
    public void show() {
        for (int i = 0; i < this.node; i++) {
            System.out.print("vertex" + i + ":\t");
            for (int j = 0; j < graph.size(); j++) {
                System.out.print(graph.get(i).get(j) + "\t");
            }

            System.out.println();
        }
    }

    @Override
    public int begin() {
        this.index = 0;

        if (CollectionUtils.isNotEmpty(graph.get(this.current))) {
            return graph.get(this.current).get(this.index);
        }

        return -1;
    }

    @Override
    public int next() {
        this.index++;

        if (this.index < graph.get(this.current).size()) {
            return graph.get(this.current).get(this.index);
        }

        return -1;
    }

    @Override
    public boolean end() {
        return this.index >= graph.get(this.current).size();
    }
}
