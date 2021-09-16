package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열_D3_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int ans = 0;
		for(int tc = 1; tc <= T; tc++) {
			
			// 수열의 길이 N
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0;  i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			} // end of input
			
			// 확인
//			System.out.println(N);
//			System.out.println(Arrays.toString(nums));
			
			int[] dp = new int[N];
			for(int i = 0; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(nums[i] > nums[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				ans = Math.max(ans, dp[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			ans = 0;
		} // end of tc
		
		bw.write(sb.toString());
		bw.close();
		
	} // end of main
} // end of class
