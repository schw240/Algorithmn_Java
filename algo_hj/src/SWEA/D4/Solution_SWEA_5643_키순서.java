package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서 {
	
	static int N, M; // N명 학생, 키 비교한 횟수 M
	static int T;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		
		
		// 1 < 5
		// 3 < 4
		// 5 < 4
		// 4 < 2
		// 4 < 6
		// 5 < 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
	        int INF = 100001; 
			int ans = 0; 
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) map[i][j] = 0;
					else map[i][j] = INF;
				}
			}

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
			}
			
			
			// 플로이드워셜
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (k == i) continue;
					for (int j = 0; j < N; j++) {
						if (k == j || i == j) continue;
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == INF && map[j][i] == INF) {
						flag = false;
						break;
					}
				}
				if (flag) ans++;
			}
			
			
			System.out.println("#" + tc + " " + ans);
		} // end of tc
		
		
		
		
		
		
		
		
		
		
	} // end of main
	
}// end of class
