class Solution {
   public int[] solution(int[] heights) {
       int[] answer=new int [heights.length];
       
       int top=heights.length-1;
       int tmp1,tmp2;
       int idx=top;
       int i;
       
       while(top!=-1)
       {
            
           tmp1= heights[top];
           top--;
           int a=top;
           for(i=a;i>=0;i--)  
           {
               tmp2=heights[i];

               if(tmp2>tmp1)
               {
                    answer[idx--]=i+1;
                   break;
               }
                    
           }
        
           if(i==-1) //for문 다 돌고 더 큰 값을 못찾았을 경우 
           {
               answer[idx--]=0;
   
           }
               
       
       }

       
       return answer;
   }

}
