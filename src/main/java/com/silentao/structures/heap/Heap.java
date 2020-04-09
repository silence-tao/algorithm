package com.silentao.structures.heap;

import java.util.List;

/**
 * @Description
 * @Author Silence
 * @Date 2018/8/26 11:18
 **/
public interface Heap<T> extends Attribute {

    /**
     * 插入一个元素
     * @param item
     */
    void insert(T item);

    /**
     * 提取堆顶元素
     * @return
     */
    T extractMax();

    /**
     * 堆排序
     * @return
     */
    List<T> sort();
}
