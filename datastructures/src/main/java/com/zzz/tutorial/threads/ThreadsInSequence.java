package com.zzz.tutorial.threads;

/**
 * Write a program to print 1 to 10 with three different threads where
 * t1 prints 1, followed by t2 with 2 and t3 with 3 and so on
 */
public class ThreadsInSequence implements Runnable {

    private static volatile int i = 1;
    private static int numthread;
    private static int allowedThread = 1;
    private static Object object = new Object();
    private int mythread;

    ThreadsInSequence() {
        this.mythread = ++numthread;
        System.out.println(mythread);
    }

    public static void main(String args[]) {
        ThreadsInSequence ts1 = new ThreadsInSequence();
        ThreadsInSequence ts2 = new ThreadsInSequence();
        ThreadsInSequence ts3 = new ThreadsInSequence();
        Thread t1 = new Thread(ts1);
        Thread t2 = new Thread(ts2);
        Thread t3 = new Thread(ts3);

        t1.start();
        t2.start();
        t3.start();

    }

    @Override
    public void run() {
        synchronized (object) {
            for (i = 1; i <= 10; i++) {
                while (mythread != allowedThread) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i <= 10)
                    System.out.println(mythread + " : " + i);
                if (allowedThread == 3)
                    allowedThread = 1;
                else
                    allowedThread++;
                object.notifyAll();

            }

        }
    }
}

