package zoff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
	
	private static int N;
	private static int M;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		
		for(int r = 1; r <=N; r++) {
			String next = sc.next();
			for(int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(next.charAt(c-1) + "");
			}
		}
		
		// print(map);
		
		// bfs
		Queue<Point> q = new LinkedList<>();
		boolean[][][] v = new boolean[N+1][M+1][2];
		q.add(new Point(1, 1, 1, 0));
		v[1][1][0] = true; // 안부수고간건 0번에 처리 부수고간건 1번에 처리
		while(q.size() > 0) {
			Point p =  q.poll();
			if(p.r == N && p.c == M) {
				// 끝점에 도착한것
				ans = Math.min(ans,  p.cnt); 
				break;
			}
			
			// 이동
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr > 0 && nr <= N && nc > 0 && nc <= M) {
					// 지도 영역 안에있음
					if(map[nr][nc] == 0 && !v[nr][nc][p.puk]) {
						// 새 위치가 0이고 방문하지 않았다면
						q.add(new Point(nr, nc, p.cnt + 1, p.puk));
					} else if(map[nr][nc] == 1 && p.puk == 0) { // 벽을 한번은 부술 수 있음
						// 부순적이 없다면
						v[nr][nc][1] = true; // 1이 부쉈다는 의미
						q.add(new Point(nr, nc, p.cnt + 1, 1));
					}
				}
				
			}
			
			
			
		} // end of while
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
		
	} // end of main
	
	static class Point {
		int r, c, cnt; // 몇칸 이동했는지 셀 cnt
		int puk;
		
		Point(int r, int c, int cnt, int puk) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.puk = puk;
		}
	}
	
	private static void print(int[][] map) {
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	
	
} // end of class
