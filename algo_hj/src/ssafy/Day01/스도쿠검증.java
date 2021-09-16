package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class 스도쿠검증 {
	static int[][] map;
	static int T, N, Ans;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("스토쿠검증.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			map = new int [9][9];
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					map[r][c]=sc.nextInt();
				}
			}
			//print(map);
			Ans = solve(map);
			System.out.printf("#%d %d\n", tc, Ans);
		}
	}
	static HashSet<Integer> hs = new HashSet<>();
	
	private static int solve(int[][] map) {
		// 가로줄 탐색
		for (int i = 0; i < 9; i++) {
			hs.clear();
			for (int j = 0; j < 9; j++) {
				hs.add(map[i][j]);
			}
			if(hs.size()< 9) return 0;
		}
		// 새로줄 탐색
		for (int i = 0; i < 9; i++) {
			hs.clear();
			for (int j = 0; j < 9; j++) {
				hs.add(map[j][i]);
			}
			if(hs.size()< 9) return 0;
		}
		// 3 x 3 
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hs.clear();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						hs.add(map[3*i+k][3*j+l]);
					}
				}
				if(hs.size()<9) return 0;
			}
		}
		return 1;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

	

}
