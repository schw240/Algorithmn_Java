package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠_김한주 {
	
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int ans = 1; // 하나라도 비정상이면 이거 0으로 변경

			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

//			for(int i = 0; i < 9; i++) { // 확인
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			ans = sudoku(map);
			
			System.out.println("#" + tc + " " + ans);
		} // end tc
	}

	static int sudoku(int[][] map) {
		
		// 가로 체크
		for(int i = 0; i < 9; i++) {
			set.clear(); // 비워주기
			for(int j = 0; j < 9; j++) {
				set.add(map[i][j]);
			}
			if(set.size() < 9) { // 1 ~ 9 가 안들어감
				return 0;
			}
		}
		
		// 세로 체크
		for(int j = 0; j < 9; j++) {
			set.clear();
			for(int i = 0; i< 9; i++) {
				set.add(map[i][j]);
			}
			if(set.size() < 9) { // 1 ~ 9 가 안들어감
				return 0;
			}
		}
		
		// 3x3 체크
		for(int i = 0; i < 9; i+=3) { // 3씩 건너서 확인하여 각 스퀘어 위치의 첫번째 값에 위치
			for(int j = 0; j < 9; j+=3) {
				set.clear();
				for(int k = 0; k < 3; k++) { // 3x3의 처음 위치하는 곳에서 돌면서 확인하기
					for(int l = 0; l < 3; l++) {
						set.add(map[i+k][j+l]);
					}
				}
				if(set.size() < 9) {
					return 0;
				}
			}
		}
		
		return 1;
	}
}
