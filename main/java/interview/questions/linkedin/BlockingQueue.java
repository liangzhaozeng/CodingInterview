package interview.questions.linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

	public class BoundedBlockingQueue<T> {
		private final List<T> queue;
		private final Semaphore availableItem;
		private final Semaphore availableSpace;
		
		public BoundedBlockingQueue(int size) {
			this.queue = new LinkedList<T>();
			availableItem = new Semaphore(0);
			availableSpace = new Semaphore(size);
		}
		
		public void add(T element) throws InterruptedException {
			availableSpace.acquire();
			boolean isAdded = false;
			try {
				synchronized (this) {
					isAdded = queue.add(element);
				}
			} finally {
				if (!isAdded) {
					availableSpace.release();
				} else {
					availableItem.release();
				}
			}
		}
		
		public T remove() throws InterruptedException {
			availableItem.acquire();
			T element;
			synchronized (this) {
				element = queue.remove(queue.size() - 1);
				availableSpace.release();
			}
			return element;
		}
		
	}
	
	
	public class MyBlockingQueue<T> {
	    
	    private Queue<T> queue;
	    private AtomicInteger limit = new AtomicInteger(10);
	    private Lock put_lock = new ReentrantLock();
	    private Lock take_lock = new ReentrantLock();
	    
	    public MyBlockingQueue(AtomicInteger limit){
	        queue = new LinkedList<T>();
	        this.limit = limit;
	    }
	    
	    public boolean put(T item) throws InterruptedException{
	        put_lock.lockInterruptibly();
	        try{
	            while(queue.size() == limit.get()){
	                put_lock.newCondition().await();
	            }
	            put_lock.newCondition().signal();
	            queue.add(item);
	        }finally{
	            put_lock.unlock();
	        }
	        
	        return true;
	    }
	    
	    public T take() throws InterruptedException{
	        take_lock.lockInterruptibly();
	        try{
	            while(queue.size() == 0){
	                take_lock.newCondition().await();
	            }
	            take_lock.newCondition().signal();
	            return queue.poll();
	        }finally {
	            take_lock.unlock();
	        }
	    }
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {

		while (this.queue.size() == this.limit) {
			wait();
		}
		// Notify all the threads that are waiting
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}

		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}
