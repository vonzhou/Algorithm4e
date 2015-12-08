package fundamental.dataabstract;

import fundamental.programmodel.StdOut;
import fundamental.programmodel.StdRandom;

//��������
public class Rolls {
    public static void main(String[] args) {
        int T = 1000;
        int SIDES = 6;

        //�������飬����ÿ�����û�û�г�ʼ��
        Counter[] rolls = new Counter[SIDES+1];
        
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "'s");
        }

        // flip dice
        for (int t = 0; t < T; t++) {
            int result = StdRandom.uniform(1, SIDES+1);
            rolls[result].increment();
        }

        // print results
        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);
        }
    }
}
