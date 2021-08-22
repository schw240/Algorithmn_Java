package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_2005_파스칼의삼각형_D2_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 크기가 N인 파스칼 삼각형 만들기
			// 맨 왼쪽, 오른쪽은 그냥 1 내려옴
			// 가운대는 왼쪽과 오른쪽의 숫자의 합으로 구성된다.
			int[][] map = new int[N][];
			map[0] = new int[1];
			map[0][0] = 1;
			for(int i = 1; i < N; i++) {
				map[i] = new int[i+1];
				for(int j = 0; j <= i; j++) {
					if(j == 0 || j == i) {
						// 처음이거나 끝이면 1넣기
						map[i][j] = 1;
					} else {
						// 아니라면 왼쪽, 오른쪽 값의 합 넣기
						// 1
						// 1 1
						// 1 2 1
						// 1 3 3 1
						map[i][j] = map[i-1][j-1] + map[i-1][j];
					}
				}
				
			}
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print(map[i][j] + " ");
				} 
				System.out.println();
			}
				
		} // end of tc
		
		
		
	} // end of main
} // end of class
