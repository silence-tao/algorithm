package com.silentao.concurrent;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 生产者消费者模式
 * 通过ReentrantLock结合条件变量Condition实现
 * @Author chentao10
 * @Date 2020/6/29 11:29
 **/
public class ProducerConsumerLockPattern {
    static ReentrantLock lock = new ReentrantLock();
    // 等待生产：如果资源不为空，那么生产者就要等待消费者消费了这个资源再生产
    static Condition produced = lock.newCondition();
    // 等待消费：如果资源为空，那么消费者就要等待生产者生产了资源再消费
    static Condition consumed = lock.newCondition();
    // 共享资源
    static volatile Integer value = null;

    /**
     * 生产者
     */
    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();

                    while (value != null) {
                        // 已生产资源，生产者阻塞，等待消费者消费后唤醒
                        produced.await();
                    }

                    value = ThreadLocalRandom.current().nextInt(100);
                    System.out.println("生产：" + value);

                    // 生产资源完成，唤醒消费者继续消费
                    consumed.signalAll();
                } catch (InterruptedException ignore) {

                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {}
            }
        }
    }

    /**
     * 消费者
     */
    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();

                    while (value == null) {
                        // 资源已被消费，消费者阻塞，等待生产者生产资源
                        consumed.await();
                    }

                    System.out.println("消费：" + value);
                    value = null;

                    // 资源消费完成，唤醒生产者继续生产
                    produced.signalAll();
                } catch (InterruptedException ignore) {

                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {}
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
