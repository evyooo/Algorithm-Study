import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
 
public class Solution {
 
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        //답으로 쓸 answer 변수 선언
        int answer = 0;
        Queue<integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        //우선순위 큐
        
        int index = 0;
        for (int i = 0; i < k; i++) {
            //딱 밀가루를 사용할 수 있는 날 전에는
            if(index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);
                
            //재고가 없으면
            if(stock == 0) {
                //우선순위 큐에서 증가시킴
                stock += priorityQueue.poll();
                answer++;
            }
            //하루가 지나면 재고 량 -1
            stock -= 1;
        }
        return answer;
    }
}
