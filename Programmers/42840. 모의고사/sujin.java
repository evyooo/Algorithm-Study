import java.util.*;
class Solution {
     public int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = {1, 2, 3, 4, 5};
		int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] pA = {0,0,0};
		
		for(int i=0; i<answers.length;i++) {
			if(p1[i%5]==answers[i]) {
				pA[0]++;
			}
			if(p2[i%8]==answers[i]) {
				pA[1]++;
			}
			if(p3[i%10]==answers[i]) {
				pA[2]++;
			}

		}
		// max 값 
		int max= pA[0] <= pA[1] ? pA[1] : pA[0];   // 일단 p1A와 p2A 먼저 비교 
		max = pA[2] >= max ? pA[2] : max;	// 그중 최대값과 p3A 비교 
		
		int count =0;
		for(int i=0; i<3; i++) {
			if(max == pA[i]) {
				count++;
			}
		}
		answer = new int[count];
		int c=0;
		for(int i=0; i<3; i++) {
			if(max == pA[i]) {
				answer[c++] = i+1;
			}
		}
    	
    	return answer;
    	
    }
}
