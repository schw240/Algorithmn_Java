package 프로그래머스.고득점kit.이분탐색;

public class 입국심사 {
	
	public static long solution(int n, int[] times) {
		long answer = 0;
		
		// n명이 입국심사를 위해 기다리고있다. 심사관 마다 심사하는 시간이 다름
		// 한 심사대에서 한명 심사 가능, 가장 앞사람 비어있는 심사대 가서 심사받기. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 가는것도 가능
		// 모든 사람이 심사를 받는데 걸리는 시간 최소값 return
		
		long left = 0;
		long right = (long) n * times[times.length - 1];
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			
			for(int i = 0; i < times.length; i++) {
				
				// 심사관별 걸리는 시간을 가지고 mid와 나눠서 처리해주기
				cnt += mid / times[i]; 
			}
			
			// cnt와 n을 비교해서 최소 시간 다시 찾기
			if(cnt < n) {
				// cnt가 n보다 작다는건 다 처리하지 못했다는 의미
				left = mid + 1;
			} else {
				// 더 많이 처리됬다는 의미
				right = mid - 1;
				answer = mid;
			}
			
		} // end of while
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		System.out.println(solution(n, times));
	}
}
