package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_김한주 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int N;
	static int max;
	static int location;
//	static int min_location;
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
			int cnt = 1; // 첫번째 방도 포함
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					
//					visited[i][j] = true; // 처음 위치의 방부터 탐색하므로
//					int r = i;
//					int c = j;
//					System.out.println("시작위치: " + r + " , " + c);
//					System.out.println("현재 방 번호: " + map[r][c]);
//					System.out.println("현재 cnt: " + cnt);
//					for (int k = 0; k < 4; k++) {
//						int nr = r + dr[k];
//						int nc = c + dc[k];
//						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
//							// 이동하려는 위치가 현재값보다 1이 크고 방문하지 않았을 경우
//							if (map[nr][nc] == (map[r][c] + 1) && visited[nr][nc] == false) {
//								System.out.println("이동한 방 번호: " + map[nr][nc]);
//								System.out.println("증가 전 cnt: " + cnt);
//								cnt += 1; // 방 count 1 증가
//								System.out.println("증가 후cnt: " + cnt);
//								System.out.println("해당 좌표: " + nr + " , " + nc);
//								visited[nr][nc] = true; // 해당 위치 탐색 표시
//
//								if (max < cnt) {
//									max = cnt;
//									location = map[r][c];
//									if (min_location > location) {
//										min_location = location;
//									}
//								}
////							} else { // 아니라면
////								// 처음 위치 방부터 초기화
////								visited = new boolean[N][N]; // 계속 만들면 안좋을거같은데..
////								System.out.println("초기화됨??");
////								cnt = 1; //cnt 초기화
////							}
//							}
//							// 아니라면
//							// 처음 위치 방부터 초기화
//						} else {
//							visited = new boolean[N][N]; // 계속 만들면 안좋을거같은데..
//							System.out.println("초기화됨??");
//							cnt = 1; // cnt 초기화
//						}
//					} // 4방탐색 종료
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
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위를 벗어나지 않
				if(map[nx][ny] == (map[x][y] + 1) && visited[nx][ny] == false) {
					dfs(start, cnt + 1, nx, ny);
				}
			}
			
			if(cnt > max) {
				max = cnt;
				location = start;
			}
			if(cnt == max) {
				location = Math.min(start, location);
			}
			visited[x][y] = false;			
		}
	}
	
} // end of class
