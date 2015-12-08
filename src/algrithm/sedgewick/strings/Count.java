package algrithm.sedgewick.strings;

public class Count {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet("abc");
        int R = alpha.R();
        int[] count = new int[R];
        String a = "abcccccccccccaaaaaaaaaaaaaabbbbbbbbasfsdafasdfasdf";
        int N = a.length();
        //���δ������ݼ��е�ÿ���ַ����ж��Ƿ���ڣ����ڵĻ������ַ�����������ͳ��
        for (int i = 0; i < N; i++)
            if (alpha.contains(a.charAt(i)))
                count[alpha.toIndex(a.charAt(i))]++;
        for (int c = 0; c < R; c++)
            System.out.println(alpha.toChar(c) + " " + count[c]);
    }
}
