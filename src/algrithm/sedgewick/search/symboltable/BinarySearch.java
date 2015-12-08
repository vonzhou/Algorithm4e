package algrithm.sedgewick.search.symboltable;

import java.util.Arrays;

public class BinarySearch {
	 public int rank(int[] A, int key) {
	        int lo = 0, hi = A.length-1; 
	        while (lo <= hi) { 
	            int m = lo + (hi - lo) >> 1; 
	            if      (A[m] > key) hi = m - 1; 
	            else if (A[m] < key) lo = m + 1; 
	            else return m; 
	        } 
	        return -(lo+1);
	    } 
	 
	 public static void main(String[] args) {
		int A[] = {0,2,4,5,8,12,34,56,75};
		int res = Arrays.binarySearch(A, 9); // -6
		System.out.println(res);;
	}

}
