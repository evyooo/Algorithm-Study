import java.util.*;
class Solution {
	//Heap 자료구조는 Java의 Priority Queue 라는 class를 사용한다
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.parallelSort(scoville);
       
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        answer=mixTwo(pq, K);
        return answer;
    }
    public boolean isFinished(PriorityQueue<Integer> scoville, int K) {
	//음식을 섞는것이 끝났는지 확인
    	Iterator it=scoville.iterator();
    	while(it.hasNext()){
    		if((int)it.next()<K) {
    			return false;
    		}
    	}
    	return true; //모든 값이 K보다 크면 끝낸다
    }
    public int mixTwo(PriorityQueue<Integer> scoville, int K) {
    	int ans=0;
    	while(true) {
    		if(scoville.size()==1 && scoville.peek()<K) //K이상을 만들 수 없는 경우
    			return -1;
    		
    		int sc1=scoville.poll();
    		if(sc1>=K) break; //가장 작은 값이 K이상인 경우 멈춘다
    		
    		int sc2=scoville.poll();
    		scoville.add(sc1+2*sc2);
    		ans++;
    	}
    	return ans;
    }
}
