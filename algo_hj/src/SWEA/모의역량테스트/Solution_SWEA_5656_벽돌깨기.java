package SWEA.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기 {
	
	private static class Point{
		int r, c, cnt; // 행, 열, 벽돌 숫자

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		
	}

	private static int N;
	private static int W;
	private static int H;
	private static int min;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0, 1, -1};
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		
			
			int[][] map = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			min = Integer.MAX_VALUE;
			go(0, map);
			
			System.out.println("#" + tc + " " + min);
		}
		
		
	} // end of main
	
	// 중복순열로 구슬을 던짐
	private static void go(int cnt, int[][] map) {
		
		
		if(cnt == N) { // 구슬을 다 던짐
			// 남아있는 벽돌 수 카운트 최소값 갱신
			int res = getRemain(map);
			min = Math.min(res, min);
			
			return;
		}
		
		int[][] newMap = new int[H][W];
		
		for(int c = 0; c < W; c++) { // 0열부터 마지막 열 까지 시도
			
			// c열에 구슬이 던져졌을 때 위에서 처음 만나는 벽돌 찾기
			int r = 0;
			while(r < H && map[r][c] == 0) {
				r++; // 벽돌 못찾으면 r을(행) 증가시키며 내려가기
			}
			
			if(r == H) {
				// 구슬을 던졌지만 맞은 벽돌이 없는 경우(해당 열 모두 빈칸)
				go(cnt + 1, map); // 다음 구슬 던지기
			} else { // 맞은 벽돌이 있는 경우
				
				// 이전 cnt 까지의 map 상태를 복사해서 사용
				copy(map, newMap); // 레퍼런스 값을 전해주고 안에 값을 넣어줬으므로 return값은 필요없다.
				
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리(연쇄적 처리)
				boom(newMap, r, c);
				
				// 제거된 벽돌들 내리기
				down(newMap);
				// 다음 구슬 던지기
				go(cnt + 1, newMap);
				
			}
			
			
		}
		
	}
	
	
	private static int getRemain(int[][] map) {
		// TODO Auto-generated method stub
		
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		
		return cnt;
	}

	private static void down(int[][] newMap) {
		// TODO Auto-generated method stub
		
		for(int c = 0; c < W; c++) {
			int r = H - 1;
			while(r > 0) {
				if(newMap[r][c] == 0) { // 빈칸이면 벽돌 내리기
					int nr = r - 1; // 자신의 직전 행부터 탐색
					
					while(nr > 0 && newMap[nr][c] == 0) nr--;
					
					newMap[r][c] = newMap[nr][c]; // 현재 빈칸에는 자신의 위쪽으로 처음 만나는 벽돌 내리기
					newMap[nr][c] = 0; // 내린 벽돌 자리는 빈칸으로
				}
				--r;
				
			}
		}
		
		
	}

	private static void boom(int[][] newMap, int r, int c) {

		// bfs로 함께 부숴질 벽돌 처리
		Queue<Point> q = new LinkedList<Point>();
		
		if(newMap[r][c] > 1) { // 벽돌의 숫자가 1보다 클 때만 주변 벽돌 연쇄 처리
			q.offer(new Point(r, c, newMap[r][c]));
		}
		
		newMap[r][c] = 0; // 벽돌을 제거하고 빈칸을 채우기
		Point p = null;
		while(q.size() > 0) {
			p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				
				for(int k = 1; k < p.cnt; k++) {
					// 카운트 숫자만큼
					nr += dr[d];
					nc += dc[d];
					// 부숴질 수 있는 벽돌에 대해서 처리
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && newMap[nr][nc] != 0) {
						if(newMap[nr][nc] > 1) {
							q.offer(new Point(nr, nc, newMap[nr][nc]));
						}
						newMap[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
	}
	
	
} // end of class
