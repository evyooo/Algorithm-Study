import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) pq.add(i);
        
        int cnt = 0;
        while (true) {
            if (pq.peek()>=K) break;
            if (pq.size() == 1) return -1;
            pq.add(pq.poll()+(pq.poll()*2));
            cnt++;
        }
        
        return cnt;
    }
}
