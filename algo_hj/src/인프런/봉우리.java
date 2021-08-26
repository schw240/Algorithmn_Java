package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 봉우리 {
	static int[] dr = {0, -1, 0 , 1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		for(int i = 0; i < N+1; i++) {
			Arrays.fill(map[i], 0);
			Arrays.fill(visited[i], false);
		}
		
		for(int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i < N+2; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인
		
		int ans = 0;
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				boolean flag = true;
				// 봉우리 개수 탐색하기
				for(int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(map[nr][nc] >= map[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag) ans++;
				
			}
		}
		
		
		System.out.println(ans);
		
	} // end of main
} // end of class
