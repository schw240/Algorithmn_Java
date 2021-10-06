package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1249_보급로_김한주_151ms {
	
	
	
	static int T, N, ans;
	static int[][] map, costMap;
	static boolean[][] visited;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int INF = Integer.MAX_VALUE;
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			costMap = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					costMap[i][j] = INF;
				}
			}
			
			costMap[0][0] = 0;
			
			// 확인
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			// 출발지에서 도착지까지 가는 경로중 복구 작업에 드는 시간이 가장 작은 경로의 복구시간
			
			ans = INF;
			bfs();
			System.out.println("#" + tc + " " + ans);
		} // end of tc
		
		
		
		
	} // end of main
	
	
	public static void bfs() {
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0));
		
		visited[0][0] = true;
		
		while(q.size() > 0) {
			Pos p = q.poll();
			
			if(p.x==N-1 && p.y==N-1) { // 도착했다면
				ans = Math.min(ans, costMap[N-1][N-1]);
			}
			
			
			for(int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; // 범위 벗어난경우
				
				if(visited[nr][nc] == false || costMap[nr][nc] > costMap[p.x][p.y] + map[nr][nc]) {
					visited[nr][nc] = true;
					costMap[nr][nc] = costMap[p.x][p.y] + map[nr][nc];
					q.add(new Pos(nr, nc));
				}
				
				
			}
				 
			
		}
		
		
		
	}
	
} // end of class
