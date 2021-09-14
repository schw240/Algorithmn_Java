package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1149_RGB거리_김한주 {
	public static void main(String[] args) {
		
		// N개의 집
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			// RGB 입력받고 
			int R = sc.nextInt();
			int G = sc.nextInt();
			int B = sc.nextInt();
			
			// 1,2번 N, N-1번, i-1, i, i+1 번 색 다 다름 여기서 모든 집을 칠하는 비용의 최소값을 출력하기
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G;
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + B;
			
		}
//		for(int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	} // end of main
} // end of class
