package 프로그래머스.고득점kit.동적계획법;

public class 정수삼각형 {
	
	private static int solution(int[][] triangle) {
		int ans = 0;
		
		// 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우
		// 바로 위에서 내려온 경우 [i-1][j], 왼쪽 위에서 내려온경우[i-1][j-1]
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		
		for(int i = 1; i < triangle.length; i++) {
			dp[i][0] = triangle[i][0] + dp[i-1][0];
			
			for(int j = 1; j < i + 1; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
			}
		}
		
		// 가장 마지막줄
		for(int i = 0 ; i < dp[triangle.length - 1].length; i++) {
			ans = Math.max(dp[triangle.length - 1][i], ans);
		}
		
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		int[][] triangle = {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		
		System.out.println(solution(triangle));
		
		
		
	} // end of main
} // end of class
