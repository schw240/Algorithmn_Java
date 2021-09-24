package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17208_카우버거알바생 {
	private static int[][][] dp;
	private static int[] burger;
	private static int[] fries;
	private static int N;
	private static int M;
	private static int K;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 주문의 수
		M = Integer.parseInt(st.nextToken()); // 치즈버거 개수
		K = Integer.parseInt(st.nextToken()); // 감자튀김 개수
		
		burger = new int[101];
		fries = new int[101];
		
		dp = new int[101][301][301];
		
		for(int i = 0; i < N; i++) { // 치즈버거 요구개수 x, 감자튀김 요구개수 y
			st = new StringTokenizer(br.readLine(), " ");
			burger[i] = Integer.parseInt(st.nextToken());
			fries[i] = Integer.parseInt(st.nextToken());
		}
		
		// 주방에 남은 치즈버거와 감자튀김을 사용해 처리할 수 있는 최대 주문의 개수
		int ans = knapsack(0, M, K);
		
		
		
		System.out.println(ans);
		
	} // end of main

	private static int knapsack(int start, int b, int f) {
		// TODO Auto-generated method stub
		if(start == N) {
			return 0;
		}
		
		if(dp[start][b][f] >= 1) {
			return dp[start][b][f];
		}
		
		int res = 0;
		
		if(burger[start] <= b && fries[start] <= f) {
			res = knapsack(start + 1, b - burger[start], f - fries[start]) + 1; // 주문 처리
		}
		
		res = Math.max(res, knapsack(start + 1, b, f));
		dp[start][b][f] = res;
		return res;
	}
} // end of class
