package SWEA.D3;

import java.util.Scanner;

public class Solution_SWEA_2805_농작물수확하기_김한주 {
	
	public static void main(String[] args) {
		
//		N X N크기의 농장이 있다.
//		이 농장에는 이상한 규칙이 있다.
//		규칙은 다음과 같다.
//
//	   ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
//	   ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
		
		
		
//		[제약 사항]
//		농장의 크기 N은 1 이상 49 이하의 홀수이다. (1 ≤ N ≤ 49)
//		농작물의 가치는 0~5이다.
		
//		[입력]
//		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
//		각 테스트 케이스에는 농장의 크기 N과 농장 내 농작물의 가치가 주어진다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 농장의 크기 N
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			
//			 확인
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
//			농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은 얼마인지 구하여라.
			// 규칙대로 마름모를 구한다음에 해당하는 값만 전부 더해서 값 출력하기
			
			int sum = 0;
			
			for(int i = 0; i < N/2; i++) { // 상단 완성  0 1 2
				for(int j = N/2 -i; j <= N/2+i; j++) { 
					sum += map[i][j];
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			for(int i = N/2; i >= 0; i--) { // 하단
				for(int j = N/2 -i; j <= N/2 + i; j++) {
					sum += map[N-i-1][j];
					System.out.print(map[N-i-1][j]);
				}
				System.out.println();
			}
//		[출력]
//		각 줄은 '#t'로 시작하고, 공백으로 농장의 규칙에 따라 얻을 수 있는 수익을 출력한다.
//		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		

		
		
	} // end of main
} // end of class
