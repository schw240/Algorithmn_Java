package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Virus {
	int row;
	int col;

	public Virus(int row, int col) {
		this.row = row;
		this.col = col;
	}

}

public class Main_백준_14502_연구소_김한주 {
	static int N, M, max;
	static int[][] map;
	static int[][] wall; // 벽을 놓을 맵
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static ArrayList<Virus> virusList;

	// 범위 검사
	public static boolean isValid(int row, int col) {
		if (row < 0 || row >= N || col < 0 || col >= M)
			return false;
		return true;
	}

	// map 깊은 복사
	public static int[][] copy(int [][] arr) {

		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

	// 벽을 세우는 경우
	public static void makeWall(int depth) {

		if (depth == 3) {
			spreadVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wall[i][j] == 0) { // 빈칸인 경우
					wall[i][j] = 1; // 벽 건설
					makeWall(depth + 1);
					wall[i][j] = 0; // 다음 경우의 수를 위해 복구
				}
			}
		}
	}

	// 벽을 세웠을 경우, virus 전염
	private static void spreadVirus() {

		int[][] copyWall = copy(wall); // 바이러스를 확장 시킬 복사 맵

		// virus를 담는 과정
		Queue<Virus> vq = new LinkedList<Virus>(); // virus를 담는 큐
		for (int i = 0; i < virusList.size(); i++) {
			vq.offer(new Virus(virusList.get(i).row, virusList.get(i).col));
		}

		// virus 전염 시작
		while (!vq.isEmpty()) {
			int row = vq.peek().row;
			int col = vq.poll().col;

			for (int k = 0; k < 4; k++) {
				int nextRow = row + dy[k];
				int nextCol = col + dx[k];

				// 범위 && 빈칸인 경우
				if (isValid(nextRow, nextCol) && copyWall[nextRow][nextCol] == 0) {
					copyWall[nextRow][nextCol] = 2;
					vq.offer(new Virus(nextRow, nextCol));
				}

			}
		} // end of spread

		// 안전구역 크기 체크 후 비교
		int sc = countSafe(copyWall);
		max = Math.max(max, sc);
	}

	// 안전구역 크기
	public static int countSafe(int[][] copyWall) {
		int sc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyWall[i][j] == 0) {
					sc++;
				}
			}
		}
		return sc;
	}

	public static void main(String[] args) throws IOException {
		
		// 상하좌우로 퍼짐
		// 벽을 3개 세울 수 있고 꼭 3개 세워야함
		// 0은 빈칸, 1은 벽, 2는 바이러스
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		virusList = new ArrayList<Virus>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 입력을 받으면서 바이러스 초기값 탐색
				if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
				}
			}
		} // end of input
		
//		System.out.println(N + " " + M);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} 
		

		// 3개의 벽을 세우기 위한 copy map
		wall = copy(map);

		// 벽 세우기 시작
		makeWall(0);

		
		// 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
		System.out.println(max);
	} // end of main

} // end of class
