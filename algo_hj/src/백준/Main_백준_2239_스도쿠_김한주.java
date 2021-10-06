package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_2239_스도쿠_김한주 {
	
	static int[][] map;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		
		// 하다 만 스도쿠 퍼즐이 주어졌을 때 마져 끝내는 프로그램 작성하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		list = new ArrayList<int[]>();
		for(int i = 0; i < 9; i++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				
				if(map[i][j] == 0) list.add(new int[] {i, j});
				
			}
		}
		
		// 확인
//		for(int i = 0; i < 9; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		


		
		
	} // end of main
	
	private static void dfs(int idx) {
		if(list.size() == idx) {
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		
		boolean[] check = new boolean[10];
		
		
		// 행
		for(int i = 0; i < 9; i++) {
			if(map[x][i] != 0) {
				check[map[x][i]] = true;
			}
		}
		
		// 열
		for(int i = 0; i < 9; i++) {
			if(map[i][y] != 0) {
				check[map[i][y]] = true;
			}
		}
		
		int miniX = (x / 3) * 3;
		int miniY = (y / 3) * 3;
		for(int i = miniX; i < miniX + 3; i++) {
			for(int j = miniY; j < miniY + 3; j++) {
				if(map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}
		
		
		
		for(int i = 1; i < 10; i++) {
			if(check[i] == false) {
				map[x][y] = i;
				dfs(idx + 1);
				map[x][y] = 0;
			}
		}
		
		
	}
	
	
	
} // end of class
