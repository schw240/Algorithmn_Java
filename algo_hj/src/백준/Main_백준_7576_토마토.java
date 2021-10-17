package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토 {
	
	
	static int N, M; // M은 가로, N은 세로
	static int[][] map;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		Queue<Tomato> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Tomato(i,j, 0));
				}
			}
 		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		int ans = Integer.MIN_VALUE;
		
		while(q.size() > 0) {
			Tomato t = q.poll();
			ans = Math.max(ans, t.day);
			for(int i = 0; i < 4; i++) {
				int nr = t.x + dr[i];
				int nc = t.y + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					// 범위 안에있고 안익은 토마토라면
					q.add(new Tomato(nr, nc, t.day + 1));
					map[nr][nc] = 1;
				}
			}
			
			
		} // end of while
		
		// 모든 토마토가 익지 못했다면 -1 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					ans = -1;
				}
			}
		}
		
		System.out.println(ans);
		
		
	} // end of main
	
	
	public static class Tomato {
		int x;
		int y;
		int day;
		public Tomato(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}

		
		
		
	}
} // end of class
