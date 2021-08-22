package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기_D2_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= T; tc++) {
			int[] nums = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				sum += nums[i];
			}
			
			double ans = 0.0;
			
			// 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램 작성하기
			// 반올림한 정수
			Arrays.sort(nums);
			sum = sum - (nums[0] + nums[9]);
			ans = sum / 8.0;
			ans = Math.round(ans);
			
			System.out.printf("#%d %.0f\n", tc, ans);
		} // end of tc
		
		
		
	} // end of main
} // end of class
