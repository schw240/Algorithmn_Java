package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 기지국 {
	static char[][] map;
	static int T, N;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("[SSAFY] Intermediate 예제 풀이_JAVA_기지국.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// print(map);
			// 풀이
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					// A or B or C
					if (map[r][c] == 'A' || map[r][c] == 'B' || map[r][c] == 'C') {
						int cnt = map[r][c] - 64;
						for (int step = 1; step <= cnt; step++) {
							// 4방탐색
							for (int d = 0; d < 4; d++) {
								// A B C 범위만큼 반복해서 X 를 지도에 찍어준다

								int nr = r + dr[d] * step;
								int nc = c + dc[d] * step;
								// 지도를 벗어나는지 확인
								if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
									map[nr][nc] = 'X';
								}
							}
						}
					}
				}
			}
			// print(map);
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 'H') {
						cnt++;
					}
					;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
