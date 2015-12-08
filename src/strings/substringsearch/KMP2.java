package strings.substringsearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class KMP2 {
    private int[] pmt;       // Partial Match Table

    private String pat;        // the pattern string

    // create the Partial Match Table from a pattern String
    public KMP2(String pat) {
        this.pat = pat;

        int M = pat.length();
        pmt = new int[M]; 
        computePMT();
    } 

    // 利用最蠢的方法来计算部分匹配表，前缀和和后缀共有元素的最大长度
    public void computePMT() {
    	pmt[0] = 0; 
    	for(int i=1; i<pat.length(); i++){
    		String current = pat.substring(0,i+1);
    		// 得到current的所有前缀和后缀，然后求交集，利用集合
    		Set<String> common = getCommonFromPrefixSuffix(current);
    		// 然后求得最大的公共元素长度
    		int longest = 0;
    		if(!common.isEmpty()){
    			Iterator<String> iter = common.iterator();
    			int cur = 0;
    			while(iter.hasNext()){
    				cur = iter.next().length();
    				if(cur > longest)
    					longest = cur;
    			}
    		}
    		pmt[i] = longest;
    	}
	}

	public Set<String> getCommonFromPrefixSuffix(String current) {
		if(current.length() < 1)
			return null;
		Set<String> prefixs = new HashSet<String>();
		Set<String> suffixs = new HashSet<String>();
		int len = current.length();
		
		for(int i=0; i<len-1; i++){
			prefixs.add(current.substring(0, i+1));
		}
		for(int i=1; i<len; i++){
			suffixs.add(current.substring(i, len));
		}
		
		prefixs.retainAll(suffixs);
		//System.out.println(prefixs);
		return prefixs;
	}

	// return offset of first match; N if no match
    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int i = 0, j=0;
        while(i<N){
        	System.out.println("i:" + i);
        	j = 0;
        	while(j<M){
        		if(txt.charAt(i+j) != pat.charAt(j)){
        			// 移动位数 = 已经匹配的字符数 - 对应的此刻的部分匹配值
        			int offset = 0; // 后面体现了i右移 
        			if(j>=1){
        				offset = j - pmt[j-1] - 1; //特别注意这里
            			
        			} 
        			i += offset;
        			break;
        		}else 
        			j++;
        	}
        	if (j == M) return i;            // found at offset i
        	 
        	i++;
        }
        return N;                            // not found    
    }

	public static void test1(){
    	String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";
        KMP2 kmp = new KMP2(pat);
        System.out.println(Arrays.toString(kmp.pmt));
        int offset1 = kmp.search(txt);
        System.out.println(offset1);
        System.out.println(txt);
        for (int i = 0; i < offset1; i++)
        	System.out.print(" ");
        System.out.println(pat);

    }
	
	public static void test2(){
    	String pat = "ABCDABD";
        String txt = "BBC ABCDAB ABCDABCDABDE";
        KMP2 kmp = new KMP2(pat);
        System.out.println(Arrays.toString(kmp.pmt));
        int offset1 = kmp.search(txt);
        System.out.println(offset1);
        System.out.println(txt);
        for (int i = 0; i < offset1; i++)
        	System.out.print(" ");
        System.out.println(pat);

    }


    // test client
    public static void main(String[] args) {
    	test2();
    }
}
