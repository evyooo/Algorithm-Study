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
    	Iterator it=scoville.iterator();
    	while(it.hasNext()){
    		if((int)it.next()<K) {
    			return false;
    		}
    	}
    	return true;
    }
    public int mixTwo(PriorityQueue<Integer> scoville, int K) {
    	int ans=0;
    	while(true) {
    		if(scoville.size()==1 && scoville.peek()<K)
    			return -1;
    		
    		int sc1=scoville.poll();
    		if(sc1>=K) break;
    		
    		int sc2=scoville.poll();
    		scoville.add(sc1+2*sc2);
    		ans++;
    	}
    	return ans;
    }
}
