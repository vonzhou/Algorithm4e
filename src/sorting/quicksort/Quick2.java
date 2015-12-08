package sorting.quicksort;

import java.util.Random;

import fundamental.programmodel.StdIn;
import fundamental.programmodel.StdOut;
import fundamental.programmodel.StdRandom;



public class Quick2 {

    // This class should not be instantiated.
    private Quick2() { }

    // 快速排序入口
    public static void sort(int[] a) {
        shuffle(a);// 注意Shuffle算法
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) 
        	return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // 2
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi;
        int v = a[lo];
        while (i < j) { 

        	while(i < j && a[j] > v)
        		j --;
        	a[i] = a[j];
           while(i<j && a[i] <= v)
        	   i++;
           a[j] = a[i];
        }
        
        a[i] = v;

        return j;
    }
    
    /**
     * Rearrange the elements of an array in random order.
     */
    public static void shuffle(int[] a) {
        int N = a.length;
        Random random = new Random();
        for(int i=N-1; i>=0; i--){
        	// 得到0-（i-1）之间的一个随机数，然后和当前元素交换
        	int r = random.nextInt(i); // 0 inclusive and i exclusive
        	
        	 int temp = a[i];
             a[i] = a[r];
             a[r] = temp;
        }
    }



    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
      int a[] = {3,-2,4,6,67,32,432,3};
      Quick2.sort(a);
      show(a);
      
    }

}
