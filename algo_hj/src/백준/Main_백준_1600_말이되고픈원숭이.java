package 백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1600_말이되고픈원숭이 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] jump = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

	// 원숭이 클래스
	static public class Monkey {
		int k;
		int x;
		int y;
		int cnt;

		public Monkey(int k, int cnt, int x, int y) {
			this.k = k;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {

		// 체스 타이트와 같은 방식으로 움직임
		// X로 표시된 곳은 말이 갈수 있다는 의미이고 말은 장애물을 뛰어넘을 수 있음
		// 하지만 원숭이는 K번만 위와 같이 움직이고 그 외에는 인접한 칸으로 움직일 수 있음
		// 대각선 방향은 포함 X 4방만 가능
		// 격자판의 맨 왼쪽 위에서 시작해서 오른쪽 아래까지 가야할 최소한의 동작으로 도착하는 프로그램 작성

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // K번만큼 말처럼 움직일 수 있음
		int W = sc.nextInt(); // 격자판 가로길이
		int H = sc.nextInt(); // 격자판 세로길이

		int[][] map = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt(); // 0은 평지, 1은 장애물
			}
		}

//		System.out.println("K: " + K + " W : " + W + " H : " + H);
//		for(int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인

		// 원숭이의 동작수 최소값 출력하기. 시작지점에서 도착지점까지 갈 수 없는 경우 -1 출력

		boolean[][][] visited = new boolean[K + 1][H][W];
		visited[0][0][0] = true; // 처음 방문
		Queue<Monkey> q = new LinkedList<>();
		q.add(new Monkey(0, 0, 0, 0)); // K가 0일떄부터 시작
		int check = 0;
		while (!q.isEmpty()) {

			Monkey m = q.poll();

			// 도착했다면 cnt 출력후 종료
			if (m.x == H - 1 && m.y == W - 1) {
				// 끝에 도착했다면
				System.out.println(m.cnt);
				return;
			}
			
			if (m.k < K) {
				// K만큼 말처럼 이동
				for (int i = 0; i < 8; i++) {
					int nr = m.x + jump[i][0];
					int nc = m.y + jump[i][1];

					int cnt = m.cnt;

					int mK = m.k + 1;
//					if(mK == K) continue;
//					if(m.k == K) continue;

					// 범위체크
					if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
						continue; // 범위 벗어나면
					}

//					System.out.println("체크 횟수: " + check++);
					// 장애물
					if (map[nr][nc] == 1) {
						continue;
					}

					// 방문한곳
					if (visited[mK][nr][nc]) {
						continue;
					}

					// 범위 안이고 장애물도 아니고 방문도 안했으면
					visited[mK][nr][nc] = true;
					q.add(new Monkey(mK, cnt + 1, nr, nc));
				}
			}

			// K를 다 사용했다면 이제 4방으로만 이동 가능
			for (int i = 0; i < 4; i++) {
				int nr = m.x + dr[i];
				int nc = m.y + dc[i];

				int cnt = m.cnt;
				int mK = m.k;

				// 범위체크
				if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
					continue; // 범위 벗어나면
				}
				
//				System.out.println("nr, nc : " + nr + " " + nc + " map[nr][nc] : " + map[nr][nc]);
				// 장애물
				if (map[nr][nc] == 1) {
					continue;
				}

				// 방문한곳
				if (visited[mK][nr][nc]) {
					continue;
				}

				// 범위 안이고 장애물도 아니고 방문도 안했으면
				visited[mK][nr][nc] = true;
				q.add(new Monkey(mK, cnt + 1, nr, nc));

			}

		} // end of bfs

		System.out.println(-1);
	} // end of main
} // end of class
