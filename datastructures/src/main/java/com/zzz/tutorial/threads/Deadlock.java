package com.zzz.tutorial.threads;

public class Deadlock implements Runnable {

    @Override
    public void run() {

    }
}

class SharedResource {
    // This is the shared resource class
    // which is shared by two or more threads
    // and is thread safe
    public synchronized void method_one(SharedResource otherResource) throws InterruptedException {
        System.out.println("In Method one ");

        Thread.sleep(1000);

        otherResource.method_two(this);
    }

    public synchronized void method_two(SharedResource firstResource) throws InterruptedException {
        System.out.println("In method two ");
        Thread.sleep(1000);

        firstResource.method_one(this);
    }
}
