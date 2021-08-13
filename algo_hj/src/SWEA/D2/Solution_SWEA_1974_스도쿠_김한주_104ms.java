package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠_김한주_104ms {

	static HashSet<Integer> hset = new HashSet<>();

	public static void main(String[] args) throws Exception {

		// 스도쿠 퍼즐 입력으로 들어온 것을 체크해서 옳바른 스도쿠라면 1 반환, 잘못됬다면 0 반환
		int ans = 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int[][] map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for(int i = 0; i < 9; i++) { // 확인
//				System.out.println(Arrays.toString(map[i]));
//			}
			ans = sudoku(map);

			System.out.println("#" + tc + " " + ans);
		} // end of tc

	} // end of main

	private static int sudoku(int[][] map) {

		// 가로 체크
		for (int i = 0; i < 9; i++) {
			hset.clear();
			for (int j = 0; j < 9; j++) {
				hset.add(map[i][j]);
			}
			if (hset.size() < 9) {
				return 0;
			}
		}

		// 세로 체크
		for (int j = 0; j < 9; j++) {
			hset.clear();
			for (int i = 0; i < 9; i++) {
				hset.add(map[i][j]);
			}
			if (hset.size() < 9) {
				return 0;
			}
		}

		// 3 x 3 체크
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				hset.clear();
				for(int k = 0; k < 3; k++) {
					for(int l = 0; l < 3; l++) {
						hset.add(map[k+i][l+j]);
					}
				}
				if (hset.size() < 9) {
					return 0;
				}
			}
		}

		return 1;
	}

} // end of class
