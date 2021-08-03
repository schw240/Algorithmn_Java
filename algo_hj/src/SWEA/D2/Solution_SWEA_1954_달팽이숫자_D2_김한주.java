package SWEA.D2;

import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_D2_김한주 {

	private static int[] dr = {0,1,0,-1};
	private static int[] dc = {1,0,-1,0};
	
	private static int N;
	private static int[][] map;
	
	public static void main(String[] args) {
		
		
//		달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
//		다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
		
//		[입력]
//		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
//		각 테스트 케이스에는 N이 주어진다.
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			// 행렬 만들기
			map = new int[N][N];
			
			
			// 생각한 로직 
			// 1 ~ N*N 숫자까지 반복하며 만약 범위 벗어나면 방향 바꿔준다.
			// 방향은 동남서북
			// 그리고 해당 칸에 만약 0이 아닌 숫자가 들어있다면 방향을 바꿔서 다시 진행한다.
			
			int num = 1;
			int r = 0;
			int c = 0;
			int idx = 0;

			while(true) {
				map[r][c] = num++;
				
				if (num > N*N) { // 종료조건 만약 num == N*N이면 종료
					break;
				}
				
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) { // 범위를 벗어나는 경우
					idx = (idx + 1) % 4;
					nr = r + dr[idx];
					nc = c + dc[idx];
				} 
				
				
				if(map[nr][nc] != 0) { // 이미 숫자가 있으면
					idx = (idx + 1) % 4;
					nr = r + dr[idx];
					nc = c + dc[idx];
				}
				
				r = nr;
				c = nc;
				
			}
			
			
		//		[출력]
		//		각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.
		//		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
			System.out.printf("#%d\n", tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		
		} // end of testCase
		
		
		
		
		
		
		
		
	} // end of main
} // end of class
