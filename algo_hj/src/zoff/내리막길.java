package zoff;

import java.util.Arrays;
import java.util.Scanner;

public class 내리막길 {

	static int N, M;
	static int[][] map;
	
	static int[][] dp;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static int ans;
	
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

//		print(map);
		
		// 하향식 작성 망식

//		dfs(0, 0);
		dfs_dp(0,0);
		System.out.println(dfs_dp(0,0));

	}

	private static int dfs_dp(int r, int c) {
		// TODO Auto-generated method stub
		
		if(r == M-1 && c == N-1) {
			// 정상에 도착하면 끝내지 말고 기록을 하기
			return 1; // 길하나를 찾았다는 의미로 1을 리턴해주기
		}
		
		// 여기서부터 다른사람이 산에 간적이 있니?  -------- 핵심코드!!!!!
		if(dp[r][c] != -1) {
			// 이미 다른사람이 방문한것이므로 더이상 올라가지말기
			return dp[r][c];
		}
		
		// 내가 올라가는 길은 0으로 하면서 올라감
		dp[r][c] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
				dp[r][c] = dp[r][c] + dfs_dp(nr, nc); // 어디서 시작했는지 저장하기 그리고 이전에 온 놈들도 있으니 그곳에다가 값을 저장하라
			}
		}
		return dp[r][c];
		
	}

	private static void dfs(int r, int c) {

		if (r == M - 1 && c == N - 1) {
			ans++;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
				dfs(nr, nc);
			}
		}
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
