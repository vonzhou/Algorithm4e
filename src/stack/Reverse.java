package stack;

import fundamental.programmodel.StdIn;
import fundamental.programmodel.StdOut;


public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        // EOF
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
        for (int i : stack) {
            StdOut.println(i);
        }
    }
}
