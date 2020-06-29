package com.silentao.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description
 * @Author Silence
 * @Date 2020/6/28 23:14
 **/
public class ProducerConsumerPattern {
    static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    int value = ThreadLocalRandom.current().nextInt(100);
                    queue.put(value);
                    System.out.println("生产：" + value);
                } catch (InterruptedException ignore) {

                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费：" + value);
                } catch (InterruptedException ignore) {

                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
