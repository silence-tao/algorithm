package com.silentao.structures.linked;

/**
 * @Description
 * @Author Silence
 * @Date 2019/11/28 22:15
 **/
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
