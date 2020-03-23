import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
      
        PriorityQueue <Integer> pq=new PriorityQueue<>(Comparator.reverseOrder()); //우선순위가 낮은 것(큰 값)부터 출력하기 위하여. 
     
        LinkedList <Integer> date= new LinkedList<>();
        LinkedList <Integer> supply= new LinkedList<>();
        
        for(int i=0;i<dates.length;i++)
        	date.add(dates[i]);
        for(int i=0;i<supplies.length;i++)
        	supply.add(supplies[i]);
        
    
        
         for(int i=0; i<k;i++) {
        	 
        	 if(!date.isEmpty() && i==date.peekFirst()) // 물품을 받을 수 있는 날이 되면 
        	  {
        	     date.removeFirst();
        			 pq.add(supply.removeFirst()); // 큐에다가 물량을 저장 
        	  }
        			
        	 if(!pq.isEmpty() && stock==0) // 재고가 필요한날이 오면 큐에서 물량을 꺼내다 stock 증가 
        	 {
        		
        		stock+=pq.poll();
        		answer++; // 물량을 공금받는 횟수
        	  }
        	 
        	stock--;  // 하루에 재고가 하나씩 소멸된다. 
        		
        		

        } 
         
        			return answer;
       
    }
}
