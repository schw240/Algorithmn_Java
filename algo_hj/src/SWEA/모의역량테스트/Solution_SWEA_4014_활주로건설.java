package SWEA.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설 {
	
	
	static int T, N, X; // 테케 개수, 한변의 크기, 경사로의 길이 X
	static int[][] map;
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 활주로를 가로 또는 세로 방향으로 건설할 수 있는 가능성을 확인하려고 한다.
		// 활주로는 높이가 동일한 구간에서 건설이 가능하고
		// 높이가 다른 구간의 경우 활주로가 끊어지기 때문에 경사로를 설치해야만 활주로를 건설할 수 있다.
		
		// 경사로는 길이가 X이고 높이는 1이다.
		// 경사로는 높이 차이가 1이고 낮은 지형의 높이가 동일하게 경사로의 깊이만큼 연속되는 곳에 설치할 수 있다.
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println(N + " " + X);
			for(int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
		
		} // end of tc
		
		
		
		
	} // end of main
} // end of class
