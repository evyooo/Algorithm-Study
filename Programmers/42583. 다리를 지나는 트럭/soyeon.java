import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] weights) {
        Queue<Integer> que=new LinkedList<Integer>();

        int sum=0;//트럭무게
	int num=0;//트럭개수
	int time=0;

	for(int i=0;i<weights.length;i++){
		int train=weights[i];
		while(true){
			time++;
			if(num==bridge_length){//트럭이 꽉 차 있으면
				num--;
				sum-=que.element();
				que.remove();
			}
			if(sum+train>weight){//트럭이 무게를 못버티면
				num++;
				que.add(0);
			}
			else{
				num++;
				sum+=train;
				que.add(train);
				break;
			}
		}
	}
	return time+bridge_length;
    }
}
