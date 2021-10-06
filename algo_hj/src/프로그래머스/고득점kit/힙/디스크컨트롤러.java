package 프로그래머스.고득점kit.힙;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	
	
	public static int solution(int[][] jobs) {
		
		// 하드디스크는 한번에 하나의 작업만 수행할 수 있다.
		// 디스크 컨트롤러를 구현하는 방법은 여러가지가 있는데
		// 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는것
		
		// 작업을 처리하는데 걸린 평균시간을 가장 줄이는 방법으로 처리할때 걸리는 평균 시간 return
		
		// 처리하는데 걸리는 시간이 짧은 순??
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		
		// 확인
//		for(int i = 0; i < jobs.length; i++) {
//			q.add(jobs[i]);
//		}
//		while(q.size() > 0) {
//			System.out.println(Arrays.toString(q.poll()));
//		}
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //시작시간 순서대로 

        int answer = 0;
        int current = 0; //현재 시간
        int i = 0;
        
        
        while(i < jobs.length || !q.isEmpty()) {
        	
        	// 시작할 수 있는 작업이 있다면 해당 작업 처리
  
            while(i < jobs.length && jobs[i][0] <= current) {
                q.add(new int[] {jobs[i][0], jobs[i][1]});
                i++;
            }
            // 지금 시작할 수 있는 작업이 없다면 해야할 작업 중 가장 먼저 해야할 작업의 요청 시간으로 현재 시간을 바꾸고 큐에 삽입
            if(q.isEmpty()) { //큐가 빔 -> 현재 실행할 수 있는 작업이 없음
                current = jobs[i][0]; //다음 작업의 시작시간으로 이동
            } else {
                int[] temp = q.poll();
                answer += current + temp[1] - temp[0]; //요청 ~ 종료시간 
                current += temp[1];
            }
        }
        
        // 평균 시간 반환
        return answer / jobs.length;
	}
	
	
	public static void main(String[] args) {
		
		int[][] jobs = {
				{0,3},
				{1,9},
				{2,6}
		};
		
		System.out.println(solution(jobs));
		
		
	} // end of main
} // end of class
