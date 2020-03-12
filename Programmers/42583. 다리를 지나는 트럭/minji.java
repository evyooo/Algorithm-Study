import java.util.*; //스택이나 큐로 풀지는 않았다..
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
		int len = truck_weights.length; //배열의 크기 먼저 계산
		int[] b = new int[len];
		int bridgeTruck = 0; //다리위의 트럭 무게
		int i = 0, j = 0, k = 0; //i와 j를 while문 밖에서 먼저 초기화
		while (true) { //가능할때까지 돌려줄거다.
			while ((bridgeTruck + truck_weights[j]) <= weight && k == 0) {
				answer += 1; 
				bridgeTruck += truck_weights[j];
				b[j] = answer + bridge_length; //2, 3, 3
				if(j>=1) {
					if(b[j]<=b[j-1]) // 이 부분이 중요! 이렇게 해주기 전까지 테스트케이스 20개중 2개 통과 못했음
						b[j]=b[j-1]+1; //혹시 다음꺼가 작게되면 큰놈에서 +1해주는게 포인트
				}
				if (j == len - 1) { //len-1에서 이 코드를 한번만 돌기 위해서 적어준 if문
					k = 1;
					break;
				}
				j++;
			}
			answer = b[i]; //한놈이 들어가고 나왔을 때를 answer로 대입
			bridgeTruck -= truck_weights[i];
			if (i == len - 1) //i=len-1일때 answer가 답
				break;
			i++;
			answer -= 1; //다음 트럭이 시작하는 지점이 그 전 트럭이 나갈 때랑 겹쳐서 -1을 해줘야 됨
		}

		return answer;
    }
}
