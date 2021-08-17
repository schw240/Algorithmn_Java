package 프로그래머스.고득점kit.스택_큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int ans = 0;
		
		// 일차선 다리를 정해진 순으로 건널때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내기
		// 다리는 weight이하 무게까지 가능, 다리에 완전히 오르지 않은 트럭의 무게는 무시
		// 최대 bridge_length 대 올라갈 수 있음
		
		Queue<Integer> q = new LinkedList<>();
		int sum = 0; // 무게
		
		for(int i = 0; i < truck_weights.length; i++) {
			while(true) {
				if(q.isEmpty()) { // 큐가 비어있다면 트럭 하나 넣어주기
					q.add(truck_weights[i]); 
					sum += truck_weights[i]; // 무게에 현재 트럭 무게 더해주기
					ans++; // 시간초 1초 증가
					break;
				} else if(q.size() == bridge_length) { // 다리길이만큼 올라갈수있으므로
					sum -= q.poll(); // 가득차있고 가장 먼저 진입한 트럭이 도착했으므로 다리밖으로 뺴줌
				} else { // 다리위에 있지만 큐가 가득차지 않았으면
					if(sum + truck_weights[i] > weight) { // 무게를 체크 
						ans++; // 더이상 널 수 없으므로 1초 증가
						q.add(0); // 0을 넣어서 혼자 지나갈 수 있도록해줌
					} else { // 더 넣을 수 있다면
						q.add(truck_weights[i]); //트럭 추가 
						sum += truck_weights[i]; // 무게추가
						ans++; // 1초증가
						break;
					}
				}
			}
		}
		
		ans += bridge_length;
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		
		int bridge_length = 2;
//		int bridge_length = 100;
		int weight = 10;
//		int weight = 100;
		
		
		int[] truck_weights = {7,4,5,6};
//		int[] truck_weights = {10};
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		int ans = solution(bridge_length, weight, truck_weights);
		System.out.println(ans);
	}
}
