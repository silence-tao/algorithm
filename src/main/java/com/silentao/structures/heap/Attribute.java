package com.silentao.structures.heap;

/**
 * @Description 获取基本属性
 * @Author Silence
 * @Date 2018/8/26 11:16
 **/
public interface Attribute {

    /**
     * 有几个元素
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否不为空
     * @return
     */
    boolean isNotEmpty();
}
