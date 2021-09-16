package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 포쏘기 {
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("포쏘기.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = 'o';
			}
		}

		// print(map);
		// 지도에다가 입력받은 위치에 포를 쏩니다 (x)
		int r = -1, c = -1;
		r = sc.nextInt();
		c = sc.nextInt();
		// map[r][c]='x';
		// print(map);
		// 지도에다가 입력받은 위치에 포를 쏘는데 이 포는 상하좌우 에 x 를 표시합니다

//		map[r-1][c+0]='x';
//		map[r+1][c+0]='x';
//		map[r+0][c-1]='x';
//		map[r+0][c+1]='x';

		int P = -1;
		P = sc.nextInt();

		// delta
		map[r][c] = 'x';
		for(int k=1;k<=P;k++){
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d]*k;
				int nc = c + dc[d]*k;
				// 경계선 체크
				if (0 <= nr && nr < N && 0 <= nc && nc < M) {
					map[nr][nc] = 'x';
				}
			}
		}
		print(map);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void print(char[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
