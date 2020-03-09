import java.util.Arrays;

class Solution {
	 
	 
	 public boolean solution(String[] phone_book)
	 {
	
		    boolean answer = true;
		    Arrays.sort(phone_book); // 배열 오름차순 정렬
		    
		    for(int i=0;i<phone_book.length-1;i++)
		    {
		    	if(phone_book[i+1].startsWith(phone_book[i]))
		    		answer=false;
		    	//앞 순서와 비교
		    }
		    	
	        return answer;
	   
	
	
	}




}
