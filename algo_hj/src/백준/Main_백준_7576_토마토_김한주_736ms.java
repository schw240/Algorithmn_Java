package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_백준_7576_토마토_김한주_736ms {

	static int N, M;
	static int ans = -1;
//	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Tomato {
		int x, y, day;

		Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Queue<Tomato> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < map.length; i++) { // 토마토가 있는 위치 큐에다가 다 넣어주기
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					// 큐에다가 담아주기
					// 위치값을 가져와야함. r,c
					q.add(new Tomato(i, j, 0)); // day 기본값 0
				}
			}
		}
		
		// 확인
//		System.out.println(N + " " + M);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		while (q.size() > 0) {

			Tomato t = q.poll();

			ans = Math.max(ans, t.day);

			for (int i = 0; i < 4; i++) {
				int nr = t.x + dr[i];
				int nc = t.y + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					q.add(new Tomato(nr, nc, t.day + 1));
					map[nr][nc] = 1;
				}
			}

		} // end of bfs
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		if (check(map) == false)
			ans = -1;

		System.out.println(ans);
	} // end of main

	private static boolean check(int[][] map) { // 지도에 0으로 남아있는 토마토가 있는지 확인하기

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

} // end of class
