package 프로그래머스.고득점kit.동적계획법;

import java.util.Arrays;

public class 등굣깃 {
	
	
	public static int solution(int m, int n, int[][] puddles) {
		int ans = 0;
		
		int[][] dp = new int[n+1][m+1];
		// (1,1)에 집 위치, (m,n) 위치에 학교
		
		dp[1][1] = 1; // 집
		
		for(int i = 0; i < puddles.length; i++) {
			dp[puddles[i][1]][puddles[i][0]] = -1;
		}
		
//		for(int i = 0; i < n+1; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		// 격자의 크기 m,n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어질때
		// 오른쪽과 아래쪽으로만 움직여서 집에서 학교까지 갈 수 있는 최단 경로의 개수를 구학
		// 위에서 온 경우, 왼쪽에서 온 경우
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(dp[i][j] == -1) continue; // 웅덩이
				// 웅덩이가 아니라면
				if(dp[i-1][j] != -1) dp[i][j] += dp[i-1][j] % 1000000007; // 위에서 오는 경우
				if(dp[i][j-1] != -1) dp[i][j] += dp[i][j-1] % 1000000007; // 왼쪽에서 오는 경우
					
			}				
		}
//		for(int i = 0; i < n+1; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		ans = dp[n][m];
		
		return ans % 1000000007;
	}
	
	public static void main(String[] args) throws Exception {
	
		
		int m = 4;
		int n = 3;
		int[][] puddles = {
				{2,2}
		};
		
		System.out.println(solution(m, n, puddles));
		
	}
	
	
	
}
