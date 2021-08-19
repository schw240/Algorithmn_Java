package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_김한주 {
	private static int R;

	private static int C;

	private static int[][] map;

	static boolean[] visited = new boolean[26];

	static int[] dr = { -1, 1, 0, 0 };

	static int[] dc = { 0, 0, -1, 1 };

	static int ans = 0;

	static void solution(int x, int y, int cnt) {

		if (visited[map[x][y]]) { // 방문한곳이면

			ans = Math.max(ans, cnt); // ans 갱신

			return;

		} else { // 아니라면

			visited[map[x][y]] = true;

			for (int i = 0; i < 4; i++) { // 4방탐색

				int nx = x + dr[i];

				int ny = y + dc[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {

					solution(nx, ny, cnt + 1);

				}

			}

			visited[map[x][y]] = false;

		}

	}

	public static void main(String[] args) throws Exception {

		// R과 C가 빈칸을 사이에 두고 주어짐

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());

		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {

			String str = br.readLine();

			for (int j = 0; j < C; j++) {

				map[i][j] = str.charAt(j) - 'A';

			}

		} // 입력 완료

//		for(int i = 0; i < R; i++) {

//			System.out.println(Arrays.toString(map[i]));

//		} // 확인용

		// 첫재줄에 말이 지날 수 있는 최대의 칸 수 출력하기

		// 말은 상하좌우로 인접한 네 칸 중 한칸으로 이동할 수 있는데 새로 이동한 칸에 적혀있는 알파벳은

		// 지금까지 지나온 모든 칸에 적혀있는 알파벳에 지금까지 지나온 모든 칸에 적혀있는 알파벳과는 달라야한다.

		// 같은 알파벳이 적힌 칸을 두번 지날 수 없다.

		// 좌측 상단부터 시작해서 최대한 몇칸을 지날 수 있는지 구하기

		solution(0, 0, 0); // (0,0) 부터 시작

		System.out.println(ans);

	} // end of main
}
