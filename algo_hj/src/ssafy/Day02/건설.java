package ssafy.Day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 건설 {
	static int T,N,K;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("건설.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N=sc.nextInt();
			K=sc.nextInt();
			map=new int[N][N];
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[0].length; c++) {
					map[r][c]=sc.nextInt();
				}
			}
			//print(map);
			// solve
			int area = 0;
			// 시작점 순회
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 끝점 순회
					for (int m = r; m < N; m++) {
						for (int n = c; n < N; n++) {
							
							// r ,c , m, n
							// 시작점과 끝점안에 있는 값들이 k범위보다 작은지 검사
							int max=0,min=Integer.MAX_VALUE;
							for (int a = r; a <= m; a++) {
								for (int b = c; b <= n; b++) {
									max = Math.max(max, map[a][b]);
									min = Math.min(min, map[a][b]);
								}
							}
							if( Math.abs(max - min) <= K) {
								// 비행장을 설치할수 있어요
								area = Math.max(area, Math.abs(n-c+1) * Math.abs(m-r+1));
							}
							
						}
					}
					
					
				}
			}
			System.out.printf("#%d %d\n",tc,area);
		}
		
	}
	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		
	}

}
