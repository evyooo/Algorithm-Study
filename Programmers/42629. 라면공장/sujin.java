import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
 
class Supply implements Comparable<Supply> {
    int date;
    int supply;
    
    public Supply(int date, int supply) {
        this.date = date;
        this.supply = supply;
    }
 
    //공급량이 많을수록 공급 날짜가 빠를수록 더 우선순위를 줌
    @Override
    public int compareTo(Supply o) {
        if (this.supply > o.supply) {
            return -1;
        } else if (this.supply == o.supply) {
            if (this.date < o.date) return -1;
            else return 1;
        } else return 1;
    }
}
 
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Supply> pq = new PriorityQueue<>();
        List<Supply> list = new ArrayList<>();
        
        //우선순위 큐를 이용하여 Supply 정렬
        for (int i = 0; i < supplies.length; i++) {
            pq.add(new Supply(dates[i], supplies[i]));
        }
        
        //List에 우선순위 순으로 삽입
        for (int i = 0; i < supplies.length; i++) {
            list.add(pq.poll());
        }
        
        int cnt = 0;
        //stock이 k일까지 버틸 수 있을때까지 반복
        while (stock < k) {
            //우선순위 순으로 List를 순회하며 supply 공급받음
            for (int i = 0; i < list.size(); i++) {
                //date가 stock보다 작거나 같다면 현재 stock만으로 수령 가능
                if (stock >= list.get(i).date) {
                    stock += list.get(i).supply;
                    list.remove(i);
                    cnt++;
                    break;
                }
            }
        }
        
        return cnt;
    }
}

