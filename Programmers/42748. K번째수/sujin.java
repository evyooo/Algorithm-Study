import java.util.*;
class Solution {
   public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] newArr;
        for(int i=0; i<commands.length; i++){
            newArr= new int[commands[i][1]-commands[i][0]+1];
            int k=0;
            // 1. 일부분 잘라서 새로운 배열에 담기
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                newArr[k]=array[j];
                k++;
            }
            // 2. 정렬하기 
            Arrays.sort(newArr);
            
            // 3. k 번째 숫자 구하기
            answer[i]=newArr[commands[i][2]-1];
        }
        
        return answer;
    }
}
