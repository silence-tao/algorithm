package com.silentao.leetcode.array;

/**
 * @Description
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @Author Silence
 * @Date 2020/4/19 22:46
 **/
public class SearchA2DMatrix {

    /**
     * 利用二分法
     * 跳到下一行时根据上一行的结果缩小范围
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int w, h;
        if (matrix == null || (h = matrix.length) == 0 || (w = matrix[0].length) == 0) {
            return false;
        }

        int l = 0, r = w - 1;
        for (int i = 0; i < h; i++) {
            int[] arr = matrix[i];
            if (arr[l] > target || arr[r] < target) {
                continue ;
            }

            // 二分法
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            // 目标会落在l上
            if (arr[l] == target) {
                return true;
            } else if (arr[l] < target) {
                // target在l的右边，缩小范围
                l = l + 1;
                r = w;
            } else {
                // target在l的左边，缩小范围
                r = l - 1;
                l = 0;
            }
        }

        return false;
    }

    /**
     * 二分法
     * [l, mid]-[mid + 1, r]
     * 当存在多个目标值时，l是第一个目标值的位置
     * 当不存在目标值时，l是大于目标值的第一个数所在的位置
     * @param arr
     * @param target
     * @return
     */
    public static boolean dichotomy1(int[] arr, int target) {
        int len;
        if (arr == null || (len = arr.length) == 0) {
            return false;
        }

        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println("l = " + l + ", arr[l] = " + arr[l]);
        System.out.println("r = " + r + ", arr[r] = " + arr[r]);

        return arr[l] == target;
    }

    /**
     * 二分法
     * [l, mid - 1]-[mid, r]
     * 当存在多个目标值时，l是最后一个目标值的位置
     * 当不存在目标值时，l是小于目标值的第一个数所在的位置
     * @param arr
     * @param target
     * @return
     */
    public static boolean dichotomy2(int[] arr, int target) {
        int len;
        if (arr == null || (len = arr.length) == 0) {
            return false;
        }

        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        System.out.println("l = " + l + ", arr[l] = " + arr[l]);
        System.out.println("r = " + r + ", arr[r] = " + arr[r]);

        return arr[l] == target;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(arr, 5));

        int[] a = new int[] {1, 2, 3, 4, 4, 4, 4, 6, 7, 8};
        System.out.println(dichotomy1(a, 4));
        System.out.println(dichotomy2(a, 4));

        System.out.println(dichotomy1(a, 5));
        System.out.println(dichotomy2(a, 5));
    }
}
