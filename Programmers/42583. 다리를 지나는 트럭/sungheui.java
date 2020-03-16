import java.util.*;


class Solution {
	

	 public int solution(int bridge_length, int weight, int[] truck_weights) {
	   
	   
       int wt=0; // 무게 
       int time=0; // 시간 
       int[] idx= new int[truck_weights.length];  // 제거 시간 기록 
       Queue <Integer> q= new LinkedList<>();
       
       
      for(int i =0;i<truck_weights.length;i++) 
      {
    
    	while(true){ 

               time++; // 시간 카운트  
               
               for(int j=0;j<=i;j++)
               {
            	   if(time==idx[j]) // 제거할 시간이면 큐에서 트럭 제거
            	   {
            		   int m= q.poll();
            		   wt=wt-m;

               	   break;
               	       
            	   }
            		   
               }
               

               if( wt+truck_weights[i]<=weight) // 삽입 가능한 경우 
            	{      
            		  wt+=truck_weights[i];
            		  q.offer(truck_weights[i]); // 큐에 삽입 
            		  idx[i]=time+bridge_length;  // 제거할 시간 기록 
           
 		              break;
                }
 
           }


     }
 
      return time+bridge_length;

	 }
	
	
}
