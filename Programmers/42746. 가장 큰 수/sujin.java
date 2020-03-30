import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
       
        StringBuilder sb = new StringBuilder();
        
        
		String[] strNums = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			strNums[i]= Integer.toString(numbers[i]);
		}
        
        Arrays.sort(strNums,Comparator.reverseOrder()); 
        
        for(int i=0; i<strNums.length-1; i++) {
        	for(int j=i+1; j<strNums.length; j++) {
        		if(strNums[i].startsWith(strNums[j])) {
        			String s1 = strNums[i]+strNums[j];
        			String s2 = strNums[j]+strNums[i];
                    
        	    if(Integer.parseInt(s1)<Integer.parseInt(s2)){
        				String temp =strNums[i];
        				strNums[i]= strNums[j];
        				strNums[j]= temp;
        			}
        		}
        	}
        }
        
        for(int i=0; i<strNums.length; i++){
            sb.append(strNums[i]);
        }
        answer=sb.toString();
        return answer;
    }
}
