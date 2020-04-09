package com.silentao.structures.heap;

/**
 * @Description 索引堆
 * @Author chentao10
 * @Date 2018/8/29 13:40
 **/
public class IndexReverseHeap<T extends Comparable> {

    /**
     * 堆中的数据
     */
    protected T[] elements;

    /**
     * 堆当前存储数据的数量
     */
    protected int size;

    /**
     * 堆的容量
     */
    protected int capacity;

    /**
     * 索引
     */
    private int[] indexes;

    /**
     * 指向索引在堆中的位置
     */
    private int[] reverse;

    public IndexReverseHeap(int capacity) {
        this.elements = (T[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity + 1];

        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(int i, T item) {
        if (this.capacity < this.size + 1) {
            System.out.println("数量超过了堆的容量");

            return ;
        }

        if (i + 1 < 1 ||
                i + 1 > this.capacity) {
            System.out.println("入参不正确");

            return ;
        }

        i += 1;
        this.elements[i] = item;
        this.indexes[this.size + 1] = i;
        this.reverse[i] = this.size + 1;

        this.size++;

        shiftUp(this.size);
    }

    public T extractMax() {
        if (this.size <= 0) {
            return null;
        }

        T element =  this.elements[indexes[1]];

        swap(indexes, 1, this.size);

        reverse[indexes[1]] = 1;
        reverse[indexes[this.size]] = 0;
        this.size--;
        shiftDown(1);

        return element;
    }

    public int extractMaxIndex() {
        if (this.size <= 0) {
            return -1;
        }

        int result =  indexes[1] - 1;

        swap(indexes, 1, this.size);

        reverse[indexes[1]] = 1;
        reverse[indexes[this.size]] = 0;

        this.size--;
        shiftDown(1);

        return result;
    }

    boolean contain(int i) {
        if (i < 0 ||
                i + 1 > capacity) {
            return false;
        }

        return reverse[i + 1] != 0;
    }

    T getElement(int i) {
        if (contain(i)) {
            return elements[i + 1];
        }

        return null;
    }

    public void change(int i, T element) {
        if (!contain(i) ||
                null == element) {
            System.out.println("入参不合法");

            return ;
        }

        i += 1;
        elements[i] = element;

        //快速的找到elements[i]在堆中的位置
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    private void shiftUp(int k) {
        while (k > 1 && this.elements[this.indexes[k / 2]].compareTo(this.elements[this.indexes[k]]) < 0) {
            swap(indexes, k / 2, k);

            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;

            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= this.size) {
            int j = 2 *k;
            if (j + 1 <= this.size && this.elements[this.indexes[j + 1]].compareTo(this.elements[this.indexes[j]]) > 0) {
                j += 1;
            }

            if (this.elements[this.indexes[k]].compareTo(this.elements[this.indexes[j]]) >= 0) {
                break ;
            }

            swap(this.indexes, k, j);
            this.reverse[this.indexes[k]] = k;
            this.reverse[this.indexes[j]] = j;
            k = j;
        }
    }

    /**
     * 交换数组中元素a,b的位置
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int arr[], int a, int b) {
        if (null == arr || a >= arr.length || b >= arr.length) {
            System.out.println("index is more than capacity");

            return ;
        }

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
