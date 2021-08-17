package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1074_Z_김한주 {
	
	static int r, c, N, cnt;
	static int[] dr = {0,0,1,1}; // z자 탐색. 제자리, 우, 아래, 오른쪽 대각선 아래
	static int[] dc = {0,1,0,1};
	static int n;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// N = 3이면 8X8 행렬 전체는 1번 탐색, 4X4 사각형은 4번 2X2 사각형은 16번 1X1은 64번 탐색
		// 0,0 부터 시작
		// 0,4 부터 시작하면 카운트 16
		// 4,0 부터 시작 카운트 32
		// 4,4 부터 시작 카운트 48
		
		// 제곱해주기
		n = (int)Math.pow(2, N);
		
		// 배열을 Z모양으로 탐색. 
		// 재귀적으로 방문하기
		// N이 주어졌을 때 r,c위치를 몇번째로 방문하는지 작성하시오
		
		// n = 2^N;
		dfs(n, 0, 0);  // 0,0 부터 탐색 시작
		
	} // end of main
	
	
	public static void dfs(int n, int x, int y) {
		
		// 종료조건
		if(n==2) {
			for(int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if(nr == r && nc == c) {
					System.out.println(cnt);
					return;
				}
				cnt++;
			}
			return;
		}
		
		
		
		// 재귀 탐색
		dfs(n/2, x, y); // 제자리
		dfs(n/2, x, y + n/2); // 오른쪽
		dfs(n/2, x + n/2, y); // 아래
		dfs(n/2, x + n/2, y + n/2); // 오른쪽 하단
	}
	
	
} // end of class
