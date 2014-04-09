package algorithm.basic;

import java.util.Stack;

public class QuickSortIterative extends Sort {
  
	
	public static void recursvieQsort(int[] arr,Integer start, Integer end) { 
	    if (end - start < 2) return; //stop clause
	    int p = start + ((end-start)/2);
	    p = partition(arr,p,start,end);
	    recursvieQsort(arr, start, p);
	    recursvieQsort(arr, p+1, end);

	}

	public static void iterativeQsort(int[] arr) { 
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(0);
	    stack.push(arr.length);
	    while (!stack.isEmpty()) {
	        int end = stack.pop();
	        int start = stack.pop();
	        if (end - start < 2) continue;
	        int p = start + ((end-start)/2);
	        p = partition(arr,p,start,end);

	        stack.push(p+1);
	        stack.push(end);

	        stack.push(start);
	        stack.push(p);

	    }
	}
	
	private static int partition(int[] arr, int p, int start, int end) {
	    int l = start;
	    int h = end - 2;
	    int piv = arr[p];
	    swap(arr,p,end-1);

	    while (l < h) {
	        if (arr[l] < piv) {
	            l++;
	        } else if (arr[h] >= piv) { 
	            h--;
	        } else { 
	            swap(arr,l,h);
	        }
	    }
	    int idx = h;
	    if (arr[h] < piv) idx++;
	    swap(arr,end-1,idx);
	    return idx;
	}
	private static void swap(int[] arr, int i, int j) { 
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
  public void sort(int[] A) {
    
    int[] stack = new int[64];
    int top = -1;
    stack[++top] = 0;
    stack[++top] = A.length - 1;
    
    while (top != -1) {
      int right = stack[top--];
      int left = stack[top--];
      if (left < right) {
        int pivot = pivot(A, left, right);
        if (pivot - left > right - pivot) {  // left longer, process right first
          stack[++top] = left;
          stack[++top] = pivot - 1;
          stack[++top] = pivot + 1;
          stack[++top] = right;
        }
        else { // right longer, process left first
          stack[++top] = pivot + 1;
          stack[++top] = right;
          stack[++top] = left;
          stack[++top] = pivot - 1;
        }
      }
    }
    
  }
  
  private int pivot(int[] A, int start, int end) {
    int i = start, j = end + 1;
    int val = A[start];
    
    while (true) {
      while (A[++i] < val) {
        if (i == end) {
          break;
        }
      }
      
      while (val < A[--j]) {
        if (j == start) {
          break;
        }
      }
      
      if (i >= j) {
        break;
      }
      
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
    
    int tmp = A[j];
    A[j] = A[start];
    A[start] = tmp;
    return j;
  }

}
