package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_김한주3 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int N;
	static int max;
	static int location;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		// N^2 개의 방 NXN 형태
		// (i,j) 방에는 1~N^2 이하의 수 가 적혀있고 모든 방에 대해 서로 다름
		// 어떤 방에서 상하좌우로 이동 가능하고 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1만큼 커야함
		// 처음에 어떤 수가 적힌 방에 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램 작성

//		[입력]
//		첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//		각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (1 ≤ N ≤ 103)이 주어진다.
//		다음 N개의 줄에는 i번째 줄에는 N개의 정수 Ai, 1, … , Ai, N (1 ≤ Ai, j ≤ N2) 이 공백 하나로 구분되어 주어진다.
//		Ai, j는 모두 서로 다른 수이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료

//			for(int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			} // 확인

			// 어떤 방에서 출발해야 가장 많이 이동할 수 있는지??
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(map[i][j], 1, i, j); // 시작위치, cnt, 좌표
				}
			} // end of for 탐색 완료

//		[출력]
//		각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
//		한 칸을 띄운 후, 처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력한다.
//		이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다.
			System.out.println("#" + tc + " " + location + " " + max);

		} // end of tc

	} // end of main

	private static void dfs(int start, int cnt, int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위를 벗어나지 않고
				if(map[nx][ny] == (map[x][y] + 1) && visited[nx][ny] == false) { // 이동이 가능한 위치라면
					dfs(start, cnt + 1, nx, ny); // 이동
				}
			}
			
			if(cnt > max) { // 현재 cnt가 max보다 크다면 갱신
				max = cnt;
				location = start; // 시작위치 기억
			}
			if(cnt == max) { // 만약 이동거리가 같은 위치가 나오면
				location = Math.min(start, location);
			}
			visited[x][y] = false;			
		}
	}
	
} // end of class
