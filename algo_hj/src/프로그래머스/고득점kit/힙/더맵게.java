package 프로그래머스.고득점kit.힙;

import java.util.PriorityQueue;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 모든 음식의 스코빌 지수를 K 이상
        // 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 섞음
        
        // 모든 음식의 스코빌 지수가 K 이상이 될때까지 반복
        // 섞어야 하는 최소 횟수 return
        
        // 제한사항: 모든 음식의 스코빌 지수를 k 이상으로 만들 수 없는 경우 -1 return
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        
        while(true) {
        	if(pq.size() == 1) {
        		// 만약 1개남으면 -1 return
        		return -1;
        	}
        	
        	if(pq.peek() >= K) {
        		break; // 가장 끝값의 스코빌 지수가 K 이상이면 종료
        	} else {
        		// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        		pq.add(pq.poll() + pq.poll() * 2);
        		answer++;
        	}
        	
        	
        }
        
        return answer;
    }
	
	
	
	
	public static void main(String[] args) {
//		int[] scoville = {1,2,3,9,10,12};
		int[] scoville = {8,10,11};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
