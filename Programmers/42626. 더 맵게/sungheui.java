import java.util.*;

//정확도는 맞게 나오는데 효율성에서 시간초과가 나옵니다.
//아마 오름차순으로 정렬하기 위한 sort에서 시간을 많이 소요되는거 같아요. 
//priorityqueue를 사용하면 정렬할 필요없이 우선순위가 높은 순으로 출력이 가능한 것 같습니다. 


class Solution {
	

    public int solution(int[] scoville, int K) {
        int answer = 0;
       LinkedList <Integer>  heap= new LinkedList<> (); 
        
        for(int i=0; i<scoville.length;i++ )
        	heap.add(i, scoville[i]); 
        
          Collections.sort(heap); //오름차순으로 정렬 
 
        
          while(heap.getFirst() <K) // 정렬된 리스트에서 가장 첫 번째 원소가 K미만이면 실행
          {
                 if(heap.size()==1 )// 첫 번째 원소가 K이하인데, 리스트 크기 또한 1이면 모든 음식을 K이상으로 만들 수 없는 조건에 해당된다. 
                     return  answer=-1;
            	   
             
        	  int sum= heap.get(0)+heap.get(1)*2; //스코빌 지수 계산 
              heap.add(sum);

              heap.remove(0); 
              heap.remove(0);
              Collections.sort(heap); // 계산된 값을 포함하여 다시 정렬.
               answer++;  // 정렬한 횟수 증가 
           
             
            	
              
    
          }
          
         
          
       
          
      
          return answer;
    }
    	
    
}
