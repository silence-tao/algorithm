package com.silentao.util;


import com.silentao.structures.linked.ListNode;

/**
 * @Description
 * @Author chentao10
 * @Date 2019/6/21 17:38
 **/
public class PrintUtils {

	public static void print(int[] array, String message) {
		System.out.println(message + ":");

		print(array);
	}

	/**
	 * 打印整形数组
	 * @param array
	 */
	public static void print(int[] array) {
		if (null == array) {
			return ;
		}

		for (int num : array) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

	public static void print(ListNode listNode, String message) {
		System.out.println(message + ":");

		print(listNode);
	}

	/**
	 * 打印链表
	 * @param listNode
	 */
	public static void print(ListNode listNode) {
		if (null == listNode) {
			System.out.println("listNode is empty");

			return ;
		}

		ListNode node = listNode;
		while (null != node) {
			if (node.next != null) {
				System.out.print(node.val + " ");
			} else {
				System.out.print(node.val);
			}

			node = node.next;
		}

		System.out.println();
	}
}
