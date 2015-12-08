package fundamental.dataabstract;

import fundamental.programmodel.StdOut;
import fundamental.programmodel.StdRandom;

public class Flips {
    public static void main(String[] args) {
        //int T = Integer.parseInt(args[0]);
    	int T = 10000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        //�������
        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5)) heads.increment();
            else   tails.increment();
        }
        
        StdOut.println(heads);
        StdOut.println(tails);
        int delta = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(delta));
    }
}



