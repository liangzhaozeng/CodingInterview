package interview.questions.linkedin;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class ComsumerProducer {








/**
 * Java program to solve Producer Consumer problem using wait and notify
 * method in Java. Producer Consumer is also a popular concurrency design pattern.
 *
 * @author saurabhschool
 */


    public static void main(String args[]) {
        Queue<Integer> sQueue = new LinkedList<Integer>();
        int size = 4;   // vector can contain upto 5 elements
        Thread producerThread = new Thread(new Producer(sQueue, size), "Producer");
        Thread consumerThread = new Thread(new Consumer(sQueue, size, producerThread), "Consumer");
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private final Queue<Integer> sQueue;
    private final int SIZE;

    public Producer(Queue<Integer> sQueue, int size) {
        this.sQueue = sQueue;
        this.SIZE = size;
    }

   
    public void run() {
    	int i = 0;
       while (true) {
            System.out.println("Producer trying to insert item: " + i);
            try {
                produce(i++);
                
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if queue is full
        while (sQueue.size() == SIZE) {
            synchronized (sQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + (sQueue.size()+1));

                sQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sQueue) {
            sQueue.add(i);
            sQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {

    private final Queue<Integer> sQueue;
    private final int SIZE;
    private final Thread producerThread;

    public Consumer(Queue<Integer> sQueue, int size, Thread producerThread) {
        this.sQueue = sQueue;
        this.SIZE = size;
        this.producerThread= producerThread;
    }

   
    public void run() {
        while (true) {
            try {
                System.out.println("Consuming element: " );
                if (consume()==-1) break;
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sQueue.isEmpty() ) {
            // if producer thread has completed then return 
            if (!producerThread.isAlive())
                return (-1);
            synchronized (sQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                                    + " is waiting for new element inserted by a producer, size: " + sQueue.size());

                sQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sQueue) {
            sQueue.notifyAll();
            return sQueue.poll();
        }
    }
}