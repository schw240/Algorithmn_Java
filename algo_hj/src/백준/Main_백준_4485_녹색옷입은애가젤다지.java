package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_4485_녹색옷입은애가젤다지 {
	
	private static int N, tc;
	static int[][] map;
	static int[][] rupy;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	
	static class Pos {
		int x;
		int y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
	
		
		// 제일 오른쪽 아래칸인 N-1, N-1까지 이동하는데
		// 잃는 금액을 최소로 하여 동굴 건너편까지 이동하도록할때
		// 잃는 최소금액 출력
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = 1;
		while (true) {
			// 동굴의 크기 정수 N
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			rupy = new int[N][N];
			// 각 칸에있는 도둑루피의 크기가 공백으로 구분되어 주어짐
			// 도둑루피의 크기가 k이면 이 칸을 지나면 k 루피를 잃난드난 의미
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0, index = 0; j < N; j++, index+=2) {
					map[i][j] = s.charAt(index) - '0';
					rupy[i][j] = Integer.MAX_VALUE;
				}
			}
			
//			System.out.println(N);
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			} // 확인
			
			rupy[0][0] = map[0][0];
			bfs();
			
			
			
			System.out.println("Problem " + tc + ": " + rupy[N-1][N-1]);
			tc++;
		} // end of while
		
		
	} // end of main

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0));
		while(q.size() > 0) {
			Pos p = q.poll();
			int r = p.x;
			int c = p.y;
			
			for(int i = 0; i < 4; i++) {
				
//				for(int k = 0; k < N; k++) {
//					System.out.println(Arrays.toString(rupy[k]));
//				} // 중간 루피 확인용
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; // 범위를 벗어나면 넘어가기
				
				if(rupy[nr][nc] <= rupy[r][c] + map[nr][nc]) continue; // 최단경로 아닌경우 넘어가기
				
				rupy[nr][nc] = rupy[r][c] + map[nr][nc];
				q.add(new Pos(nr, nc));
				
			}
			
		} // end of while
		
		
	} // end of bfs
	
	
	
} // end of class
