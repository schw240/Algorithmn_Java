package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_11315_오목판정 {
	
	
	static char[][] map;
	static int T;
	static int N;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			flag = false;
			// 입력
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 확인용
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'o') { // 돌이 있을 떄 여기에서부터 대각선까지 있으므로 8방탐색
						 for(int k = 0; k < 8; k++) {
							 for(int cnt = 1; cnt <= 4; cnt++) {
								 System.out.println(i + " " + j + " 돌위치");
								 // 0,4 0,4에서 8방탐색하고 돌있는 위치에서 
								 int nr = i + dr[k] * cnt; // 찾은 돌 만큼 곱해주기
								 int nc = j + dc[k] * cnt;
								 
								 if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
									 // 범위를 벗어난다면
									 break;
								 } else if(map[nr][nc] != 'o') {
									 // 범위안에있지만 만약 돌이 아니라면
									 break;
								 }
								 
								 
								 System.out.println(map[nr][nc] + " " + "cnt :" + cnt);
								 if(cnt == 4) {
									 System.out.println("5개 찾기는 하나? : " + map[i][j]);
									 flag = true;
								 }
								 
								 
							 }
						 }
					}
				}
			} // 맵 전체 탐색 완료
			
			String ans = "";
			if(flag == true) ans = "YES";
			else ans = "NO";
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // end of tc
		
		
		
		System.out.println(sb);
		
		
	} // end of main
} // end of class
