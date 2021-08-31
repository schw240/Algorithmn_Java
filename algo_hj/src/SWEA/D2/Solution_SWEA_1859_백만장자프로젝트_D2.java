package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2 {
	public static void main(String[] args) throws Exception {
		
		// 연속된 N일 동안의 물건의 매매가 예측
		// 하루에 최대 1만큼 구입
		// 판매는 얼마든지 할 수 있음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] nums = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			long ans = 0;
			long max = nums[N-1];
			for(int i = N-2; i >= 0; i--) {
				if(nums[i] < max) {
					// 뒤에서 부터 체크를 하고 만약 max값보다 현재 가격이 작다면 이득임
					ans += max - nums[i];
				} else {
					// max값 갱신
					max = Math.max(nums[i], max);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}// end of tc
		
		
	} // end of main
} // end of class
