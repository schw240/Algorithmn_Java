package ssafy.Day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 색종이 {
	static int [][] map;
	// 색종이 수
	static int N;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("색종이.txt"));
		Scanner sc = new Scanner(System.in);
		map= new int[1001][1001];
		N=sc.nextInt();
		for (int n = 1; n <= N; n++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			// 지도에 색종이를 그려요
			for (int i = r; i < r+h; i++) {
				for (int j = c; j < c+w; j++) {
					map[i][j]=n;
				}
			}
		}
		//print(map);
		int []ans = new int[N+1];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c]!=0) {
					ans[map[r][c]]++;
				}
			}
		}
		//System.out.println(Arrays.toString(ans));
		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	private static void print(int[][] map) {
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}
