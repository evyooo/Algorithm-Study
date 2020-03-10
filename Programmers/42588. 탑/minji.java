class Solution {
    public int[] solution(int[] heights) {
        
        int len=heights.length; //배열 길이 선언   
        int[] answer =new int[len]; //길이만큼 초기화 0
        
        for(int i=len-1;i>0;i--){ //뒤에서부터 계산 왜냐면 빛을 왼쪽으로 쏘니까
            for(int j=i-1;j>=0;j--){ //뒤엣놈의 앞놈부터 차례로 크기 비교
                if(heights[j]>heights[i]){
                    answer[i]=j+1;
                    break; //젤먼저 큰놈이 answer[i]
                }
            }
        }     
      
        return answer;
    }
}
