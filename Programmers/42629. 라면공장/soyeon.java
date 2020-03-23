//저는 풀이를 어떻게해야할지 잘 모르겠어서 다른 분의 풀이를 참고했습니다.
//출처는 https://taesan94.tistory.com/62 입니다
import java.util.*;
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
    	int answer = 0;
		int day = stock; //최초로 0 이되는 날짜
		int index = 0 ; //add supplie index

		PriorityQueue<Integer> amounts = new PriorityQueue<Integer>(Collections.reverseOrder());
		while (day<k) {
			while(index<dates.length&&dates[index]<=day){
				// 사용한 밀가루 보다 공급일이 작거나 같은경우
				amounts.add(supplies[index]);
				index++;
			}
			day+= amounts.poll();
			answer++;
		}
		return answer ;
    }
}
