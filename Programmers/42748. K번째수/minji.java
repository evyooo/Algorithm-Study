import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int n = commands.length; //n의 길이는 3 , n은 answer의 길이가 됩니다.
    	int[] answer = new int[n];
      
    	for(int i=0;i<n;i++) {
    		int a =commands[i][0]; //[i,j,k]를 a,b,c로 입력받아줍니다.
    		int b =commands[i][1];
    		int c = commands[i][2];
    		int[] ary = new int[b-a+1]; // 크기에 맞는 배열을 새로 생성해줍니다.
    		for(int j=0;j<b-a+1;j++)
    			ary[j]=array[a-1+j];
    		Arrays.sort(ary);//Arrays.sort 정렬 이용
    		answer[i]=ary[c-1]; //c번째 answer 출력
    	}
        return answer;
    }
    
}
