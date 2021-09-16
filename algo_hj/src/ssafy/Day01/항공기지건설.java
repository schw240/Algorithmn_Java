package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 항공기지건설 {
	static int T, N, K, Ans = 0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("항공기지건설 input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			N=sc.nextInt();
			K=sc.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					map[r][c]=sc.nextInt();
				}
			}
			//print(map);
			int tmp = 0;
			// 시작점 이중루프
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					// 끝점 이중루프
					for (int m = r; m < N; m++) {
						for (int n = c; n < N; n++) {
							
							// 선택된 영역에서 최대최소값의 차가 K 보다 작은지 검사 이중루프
							int max=0;
							int min=Integer.MAX_VALUE;
							for (int a = r; a <= m; a++) {
								for (int b = c; b <= n; b++) {
									max = Math.max(max, map[a][b]);
									min = Math.min(min, map[a][b]);
								}
							}
							// 최대최소차가 K보다 작다면
							if(Math.abs(max -  min) <= K) {
								// 면적을 구한다
								Ans = Math.max(Ans, Math.abs(m-r+1)* Math.abs(n-c+1));
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,Ans);
		}
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
