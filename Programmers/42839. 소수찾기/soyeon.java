import java.util.*;
class Solution {
	public static HashSet<Integer> hashset=new HashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        StringTokenizer st=new StringTokenizer(numbers,"0123456789",true);
        LinkedList<Integer> array=new LinkedList<Integer>();
        while(st.hasMoreTokens()) {
        	array.add(Integer.valueOf(st.nextToken()));
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numbers.length();i++) {
        	int subnum=array.get(i);
        	array.remove(i);
        	makeNumber(subnum, array);
        	array.add(i, subnum);
        }
        Iterator it=hashset.iterator();
        while(it.hasNext()) {
        	int num=(int) it.next();
        	//System.out.println(num);
        	if(isPrime(num)) {
        		answer++;
        		//System.out.println(num+"**");
        	}
        }
        return answer;
    }
    public void makeNumber(int n, LinkedList<Integer> array) {
    	hashset.add(n);
    	
    	for(int i=0;i<array.size();i++) {
    		int subnum=array.get(i);
        	array.remove(i);
        	makeNumber(subnum+n*10, array);
        	array.add(i, subnum);
    	}
    	return;
    }
    public boolean isPrime(int n) {
    	if(n<=1) return false;
        if(n==2) return true;
    	for(int i=2;i<=Math.sqrt(n)+1;i++) {
    		if(n%i==0)
    			return false;
    	}
    	return true;
    }
}
