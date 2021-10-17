package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1806_부분합 {
	
	static int N, S, ans; // 10 ~ 10만, 0~1억
	static int[] nums; // 수열
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		ans = Integer.MAX_VALUE;
		// 이 수열에서 연속된 수들의 부분 합 중 그 합이 S 이상 되는 것중 가장 짧은 것의 길이를 구하는 프로그램
//		for(int i = 0; i < N; i++) {
//			int cnt = 1;
//			int sum_V = nums[i];
//			for(int j = i + 1; j < N; j++) {
//				if(sum_V + nums[j] < S) {
//					cnt++;
//					sum_V += nums[j];
//					ans = Math.min(ans, cnt);
//				} else if(sum_V + nums[j] >= S) {
//					cnt++;
//					ans = Math.min(ans, cnt); // 현재까지의 최소값 갱신
//				}
//		
//			}
//			
//			if(ans > N) {
//				System.out.println(0);
//				System.exit(0);
//			}
//		}
//		
//		
//		System.out.println(ans);
		
		int sum = 0;
		int start = 0;
		int end = 0;
		
		while(true) {
			if(sum >= S) {
				// S보다 크면
				sum -= nums[start++]; //S이상이면 start 이동
				ans = Math.min(ans, (end - start) + 1); // ans 갱신
			} else if(end == N) {
				break;
			} else { // S 보다 작으면
				sum += nums[end++];
			}
		} // end of while
		
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
		
	} // end of main
} // end of class
