package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1113_119구급대_김한주_276ms {

	static int[][] map;
	static boolean[][] visited;
	static int N,M; // 지도의 크기
	static int[] dr = {-1,1, 0,0}; // 상하좌우순으로
	static int[] dc = {0,0,-1,1};
	static int n,m; // 목표지점
	static int ans; // 가장 빨리 도착할 수 있는 경로 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		st = new StringTokenizer(br.readLine(), " ");
		// m,n 순
		// 단 M = m+1, N = n+1
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		// N줄에는 M개의 값이 주어짐
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인
		
		ans = Integer.MAX_VALUE;
		
		bfs();
		
		System.out.println(ans);
		
	} // end of main
	
	
	public static void bfs() {
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		// 0,0에서 시작
		
		// 가장 마지막 원소 방향: 상하좌우 0123
		q.add(new Node(0,0,-1,-1)); 
		visited[0][0] = true;
		
		while(q.size() > 0 ) {
			Node cur = q.poll();
			
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt; 
			int dir = cur.dir;
			
//			System.out.println(cnt);
			
			if(x == m && y == n) { // 도착지점 도착
//				System.out.println("도착함?");
				ans = Math.min(ans, cnt); 
			}
			
			for(int i = 0; i < 4; i++) { // 상하좌우순으로 돌기
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] == 0 || visited[nr][nc] == true) continue; 

				
				
				visited[nr][nc] = true;
				
//				System.out.println(nr + " " + nc + " " + ans);
				
				// 방향전환 여부
				if(dir != i) { // 방향이 바뀐경우
					q.add(new Node(nr, nc, cnt + 1, i));
				} else {
					// 방향 그대로라면
					q.add(new Node(nr, nc, cnt, dir));
				}
				

				
			}
		}
		
	} // end of bfs
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cnt; // 코너링횟수?
		int dir; // 방향
		
		
		public Node(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}


		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}
		
	}
	
} // end of class
