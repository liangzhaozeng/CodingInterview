package interview.questions.apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class FindStreamMedian {

	private int[] arr;
    private final int SEED = 100;

    FindStreamMedian(int n) {
        arr =  new int[n];

    }

    public void createRandomNumber(int num) {
        Random gen = new Random();
        for( int i =0; i < num; i++) {
            arr[i] = gen.nextInt(SEED);
        }
        arr[0] = 1;
        arr[1] =1;
        arr[1] = 1;
    }

    public Integer findMedian() {
        //Create two heaps
        int len = arr.length;

        if(arr == null) {
            return null;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((len/2)+1);  //Natural Order of Priority Group is Min Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((len/2)+1, Collections.reverseOrder());   //Reverse the order to Change it to Max Heap

        maxHeap.offer(arr[0]);

        //Starting from 1st index as first element is already inserted into maxHeap
        //I did that so that we don't have to check NULL condition in every iteration
        for(int i=1; i< arr.length; i++) {

            //First Check the size of of each Heap
            if(maxHeap.size() == minHeap.size()) {
             // increase size of maxHeap first;
                //Compare the element with the root of the Max Heap
                if(maxHeap.peek() > arr[i] || (maxHeap.peek() < arr[i] && minHeap.peek() > arr[i])) {
                    //Pop the Root element of the Max Heap and Insert it into Min Heap
                    //minHeap.offer(maxHeap.poll());
                    maxHeap.offer(arr[i]);
                }
                else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(arr[i]);
                }

            } else { //If the size of the two heaps are not equal

                //Here we are maintaining the structure where maxHeap size is always greater
                if(maxHeap.peek() < arr[i]) {
                    minHeap.offer(arr[i]);
                }
                else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(arr[i]);
                }
            }
        }

        //if the number of points is even then we are returning the ((n/2)-1)th element
        return maxHeap.poll();

    }

    public void print(){
        Arrays.sort(arr);
        for(int i=0; i < arr.length; i++) {
            System.out.print(i + " " + arr[i] + ",");
        }
    }

    public static void main(String[] args) {

        FindStreamMedian FM = new FindStreamMedian(40);
        FM.createRandomNumber(40);


        int median = FM.findMedian();

        FM.print();
        System.out.println();
        System.out.println(median);

    }
}
