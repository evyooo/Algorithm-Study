import java.util.*;
class Solution {
    class Truck {
	int weight;
	int count;	// 한 트럭이 브릿지 위에서 있었던 시간

	public Truck(int weight, int count){
		this.weight = weight;
		this.count = count;
	}
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
	Queue<Truck> complete = new LinkedList<>();
	Queue<Truck> bridge = new LinkedList<>();
	Queue<Truck> waiting = new LinkedList<>();

	int sec =0;
	int now_weight=0;

	// waiting 큐에 전체 트럭 담기 
	for(int w :truck_weights ) {
		Truck truck = new Truck(w, 1);
		waiting.add(truck);
	}

	// 모든 트럭이 브릿지 건너기를 완료했을때 끝남 (종료조건)
	while(complete.size()!=truck_weights.length) {

		// 1) waiting o , bridge x  --> waiting에서 추가 
		if(!waiting.isEmpty() && bridge.isEmpty()) {
			Truck in = waiting.poll();
			if(now_weight + in.weight <= weight) {
				now_weight += in.weight;
				bridge.add(in);
			}
		}

		// 2-1) 트럭이 나가는 조건 : 가장 앞에 있는 트럭의 count > bridge_length  && bridge not null
		if( !bridge.isEmpty() && bridge.peek().count > bridge_length) {
			Truck out = bridge.poll();
			now_weight-= out.weight;
			complete.add(out);
		}

		// 2-2) 새로운 차 들어오는 조건 : 현재 다리위 무게 + 새로 들어오는 트럭의 무게 <= weight && waiting not null
		if(!waiting.isEmpty()) {
			Truck in = waiting.peek();
			if(now_weight + in.weight <= weight) {
				now_weight += in.weight;
				bridge.add(in);
				waiting.poll();
			}
		}

		// (공통) 브릿지 위 모든 트럭에 대해서 count++, sec++
		for (Truck t : bridge) {
			t.count++;
   		 }
		sec++;
	}

	answer = sec;
        return answer;
    }
}
