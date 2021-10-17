package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기 {

	public static int N, M;
	public static int[][] map;
	public static int cnt = 0;
	public static int[] dr = { -1, 0, 1, 0 }; 
	public static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		// 0인경우 북 , 1인경우 동, 2인경우 남, 3인경우 서
		// 빈칸이 0, 벽이 1, 로봇청소기가 있는 칸은 항상 0, 맵의 가장 끝은 모두 벽
		st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solution(r, c, d);
        
        System.out.println(cnt);
		// 지도의 칸은 r,c로 나타낼 수 있고 r은 북족으로부터 떨어진 개수, c는 서쪽으로부터 떨어진 개수
		// 청소기는 바라보는 방향이 있으며 이 방향은 동서남북중 하나
		
		// 조건
		// 1. 현재 위치 청소
		// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 부터 차례대로 인접한 칸 탐색
		// 2-a 왼쪽 방향에 아직 청소하지 않은 공간이 있다면 그 방향으로 회전하고 1칸 전진하고 1번부터 진행
		// 2-b 왼쪽 방향에 청소할 공간이 없다면 그 방향으로 회전하고 2번으로 돌아감
		// 2-c 네 방향 모두 청소가 되어있거나 벽인 경우 바라보는 방향을 유지한 채로 한칸 후진하고 2번으로 돌아감
		// 2-d 네 방향 모두 청소가 되어있거나 벽이면서 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 멈춤
		// 이미 청소되어있는 칸과 벽은 할수 없음
		
		
	}

	private static void solution(int r, int c, int d) {
		// TODO Auto-generated method stub
		
		// 1. 현재 위치 청소
		if(map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		
		// 2. 왼쪽방향부터 차례대로 탐색
		boolean flag = false;
		int dir = d;
		for(int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4; // 왼쪽 먼저 탐색
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(nr > 0 && nr < N && nc > 0 && nc < M) {
				if(map[nr][nc] == 0) {
					solution(nr, nc, nd);
					flag = true;
					break;
				}
			}
			
			// b
			d = (d + 3) % 4;
		}
		
		// c,d 4 방향 모두 청소가 되어있거나 벽인 경우
		if(!flag) {
			int nd = (dir + 2) % 4; // 후진
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(nr > 0 && nr < N && nc > 0 && nc < M) {
				if(map[nr][nc] != 1) {
					// 바라보는 방향 유지한채 한칸 후진
					solution(nr, nc, dir);
				}
			}
		}
		
		
		
	}
}
