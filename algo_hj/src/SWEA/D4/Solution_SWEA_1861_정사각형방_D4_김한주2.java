package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_김한주2 {

		static int[] dr = { -1, 0, 1, 0 };
		static int[] dc = { 0, 1, 0, -1 };
		static int N;
		static int start;
		static int location;
		static int[][] map;

		public static void main(String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			for (int tc = 1; tc <= T; tc++) {
				N = Integer.parseInt(br.readLine());
				map = new int[N][N];
				
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine(), " ");
					for (int j = 0; j < N; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				} // 입력 완료
				int max = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int cnt = 1;
						
						start = map[i][j];
						
						int x = i;
						int y = j;
						
						boolean flag = true;
						while(flag) {
							// 4방탐색
							for(int k = 0; k < 4; k++) {
								int nr = x + dr[k];
								int nc = y + dc[k];
								
								if(nr < 0 || nc < 0 || nr >= N || nc >= N) { // 범위를 벗어나면
									if(k == 3) {
										// 4방을 다 돌아도 없으면
										flag = false;
										break;
									}
									continue;
								}
								
								if(map[nr][nc] == map[x][y] + 1) { // 현재 위치보다 1보다 큰 값
									x = nr;
									y = nc;
									cnt += 1;
									break; // 여기서 바로 탈출
								}
								
								if(k == 3) { // 범위 안벗어나도 안멈추면 여기서 탈출
									flag = false;
									break;
								}
								
							} // end of for 4방탐색
						} // end of while
						
//						if(cnt > max) { // 현재 cnt가 max보다 크다면 갱신
//							max = cnt;
//							location = start; // 시작위치 기억
//						}
//						if(cnt == max) { // 만약 이동거리가 같은 위치가 나오면
//							location = Math.min(start, location);
//						}
						if(cnt > max || (max == cnt && location > start)) { // 현재 cnt가 max보다 크다면 갱신
							max = cnt;
							location = start; // 시작위치 기억
						}
					}
				} // end of for문 map 전체 순회

				sb.append("#").append(tc).append(" ").append(location).append(" ").append(max).append("\n");
			} // end of tc
			
			System.out.print(sb);

	
	} // end of main
} // end of class
