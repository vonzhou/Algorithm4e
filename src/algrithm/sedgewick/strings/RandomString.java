package algrithm.sedgewick.strings;

import fundamental.programmodel.StdRandom;


/**
 * 10. Random string. 
 * Write a recursive function to create a random string of characters between 'A' and 'Z'.
 */
public class RandomString {
	// N�����ַ������L��
	public static String random(int N) {
		   if (N == 0) 
			   return "";
		   // �������һ���ַ���ʽ���ַ���
		   if (N == 1) 
			   return String.valueOf((char)('A' + StdRandom.uniform(26)));
		   // �ݹ�
		   return random(N/2) + random(N - N/2);
	}
	
	public static void main(String[] args) {
		System.out.println(random(1));
		System.out.println(random(10));
	}
	
}
