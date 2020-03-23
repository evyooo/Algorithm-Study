import java.util.PriorityQueue;
//우선순위 큐 사용

class Solution {
    public int solution(int[] scoville, int K) {
        //답으로 낼 값.
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        //스코빌 배열 탐색 후 힙에 넣기
        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }
        
        //정렬된 힙 순서대로 탐색. 탐색한 값이 K보다 클 때 까지 탐색
        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            //k보다 작다면 가장 작은 두 값 꺼내서 계산
            int a = heap.poll();
            int b = heap.poll();


            int result = a + (b * 2);

            heap.offer(result);
            //반복문 횟수 계산
            answer ++;
        }
        return answer;
    }
}
