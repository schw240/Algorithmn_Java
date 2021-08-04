package SWEA.D2;

import java.util.Scanner;

public class Solution_SWEA_2001_파리퇴치_D2_김한주 {

	public static void main(String[] args) {
		
//		N X N 배열 각 값은 해당 영역에 존재하는 파리의 개수
//		M X M 크기의 파리채를 내리쳐 최대한 많은 수의 파리를 죽임
		
		
		
		

//	[제약 사항]
//	1. N 은 5 이상 15 이하이다.
//	2. M은 2 이상 N 이하이다.
//	3. 각 영역의 파리 갯수는 30 이하 이다.
		
		Scanner sc = new Scanner(System.in);
		
		
//	[입력]
//	가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
//	각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
			int N = sc.nextInt();
			int M = sc.nextInt();
//	다음 N 줄에 걸쳐 N x N 배열이 주어진다.
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = -9999;
			for(int i = 0; i < N-M + 1; i++) {
				for(int j = 0; j < N-M + 1; j++) {
					int sum = 0;
					for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							sum += map[i+k][j+l];
						}
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			
//	[출력]
//	출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
//	(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
			System.out.printf("#%d %d\n", tc, max);
			
		}

		
		
	} // end of mina
} // end of class
