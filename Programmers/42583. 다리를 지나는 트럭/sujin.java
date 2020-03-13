
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue01_bridgeTruck {
	static class Truck {
		int weight;
		int count;
		
		public Truck(int weight, int count){
			this.weight = weight;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
		
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
			Iterator br = bridge.iterator();
			while(br.hasNext()) {
				Truck mem =(Truck)br.next();
				mem.count++;
			}
			sec++;
		}

		System.out.println(sec);
	}
}
