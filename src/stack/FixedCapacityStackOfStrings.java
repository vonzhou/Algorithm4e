package stack;

import java.util.Iterator;

import fundamental.programmodel.StdIn;
import fundamental.programmodel.StdOut;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty()            {  return (N == 0);                  }
    public boolean isFull()             {  return (N == a.length);           }
    public void push(String item)       {  a[N++] = item;                    }
    public String pop()                 {  return a[--N];                    }
    public String peek()                {  return a[N-1];                    }
    // ������
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }


    /*
     * �����ڲ�����ص�
     */
    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public String next()     { return a[i--]; }
        public void remove()      { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) {
        int max = 100;
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        // windows����EOF��ctrl+Z��UNIX������ctrl+D
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item); 
            else if (stack.isEmpty())  StdOut.println("BAD INPUT"); 
            else                       StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    } 
} 
