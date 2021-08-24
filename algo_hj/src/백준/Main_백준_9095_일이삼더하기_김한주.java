package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_9095_일이삼더하기_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		// dp문제
		int[] dp = new int[11]; // 11보다 작음
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
		dp[4] = 7; // 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1
		for(int i = 5; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 정수 N이 주어진다. 
			
			// 각 케이스마다 N을 1,2,3의 합으로 나타내는 방법의 수를 출력하기
			// 순열? dp
			System.out.println(dp[N]);
			
		}
		
	} // end of main
} // end of solution
