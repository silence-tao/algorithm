package com.silentao.structures.union;

import java.util.Random;

/**
 * @Description
 * @Author Silence
 * @Date 2018/9/2 10:40
 **/
public class Test {

    private static final int SIZE = 10000000;

    public static void main(String[] args) {
        Union quickFind = new QuickFind(SIZE);
        Union quickUnion1 = new QuickUnion1(SIZE);
        Union quickUnion2 = new QuickUnion2(SIZE);
        Union quickUnion3 = new QuickUnion3(SIZE);
        Union quickUnion4 = new QuickUnion4(SIZE);
        Union quickUnion5 = new QuickUnion5(SIZE);

//        test(quickFind);
//        test(quickUnion1);
//        test(quickUnion2);
        test(quickUnion3);
        test(quickUnion4);
        test(quickUnion5);
    }

    public static void test(Union union) {
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);

            union.union(p, q);
        }

        for (int i = 0; i < SIZE; i++) {
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);

            union.isConnected(p, q);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(union.getName() + ":" + SIZE + ", time:" + (endTime - startTime) / 1000.0 + "s");
    }
}
