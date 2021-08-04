package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1954_달팽이숫자_D2_answer3 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] m = new int[N][N];
			int r= 0;
			int c= 0;
			int num = 1; // 저장할 숫자
			int dir = 0; // 방향 우0 하1 좌2 상3
			
			
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			int target = N * N;
			while(num <= target) { // 한바뀌 우하좌상
				m[r][c] = num++;
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(0 <= nr && nr < N && 0 <= nc && nc < N && m[nr][nc] == 0) { // 전진이 가능하다면
					r = nr;
					c = nc;
				} else { // 배열의 범위를 벗어나거나, 다음 칸에 값이 있다면 => 방향전환
					dir++; // 이렇게 작성하는게 더 빠름
					if(dir == 4) {
						dir = 0;
					}
					
//					dir = (dir + 1) % 4; // 이거 느림
					
					r = r + dr[dir]; // 바꾼 방향으로 전진해라
					c = c + dc[dir];
					
				}
				for(int i = 0; i < m.length; i++) {
					System.out.println(Arrays.toString(m[i]));
				}
				System.out.println();
				br.readLine();
			}
			
			
			
	
			
			
//			System.out.println(r + " , " + c); // 확인
//			for(int i = 0; i < m.length; i++) {
//				System.out.println(Arrays.toString(m[i]));
//			}
			
			
			sb.append("#").append(tc).append("\n");
			
			for(int i = 0; i < m.length; i++) {
				for(int j = 0; j < m[i].length; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			
		} // end of testCase
		
		
		System.out.println(sb);
		
	} // end of main
} // end of class
