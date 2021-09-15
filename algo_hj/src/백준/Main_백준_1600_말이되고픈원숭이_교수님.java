package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1600_말이되고픈원숭이_교수님 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] m = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			String s = br.readLine();
			for(int j = 0, index = 0; j < W; j++, index += 2) {
				m[i][j] = s.charAt(index); // '0'평지   '1' 장애물
			}
		} // 입력완료
		
		int minMoveCnt = -1; // 이동횟수의 최소값 범위 벗어나면 그냥 -1 출력하기
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<int[]> q = new LinkedList<int[]>(); // r,c,k,moveCnt
		q.offer(new int[] {0,0,K,0}); // 큐에 시작점 넣기
		visited[0][0][K] = true;
		
		int[] dr = {-1,-2,-2,-1,1,2,2,1,-1,1,0,0};
		int[] dc = {-2,-1,1,2,2,1,-2,-2,0,0,-1,1};
		
		while(q.size() >= 0) { // 이게 isEmpty보다 효율적임
			int[] arr = q.poll(); // int[]의 꺼내짐 r,c,K,moveCnt
			int r = arr[0];
			int c = arr[1];
			int kk = arr[2];
			int moveCnt = arr[3];
			
			if(r == H-1 && c == W-1) {
				// 우측 하단에 도착했따면
				minMoveCnt = moveCnt;
				break;
			}
			
			// 우측하단 좌표에 도착하면 종료, minMoveCnt 업데이트
			// 현 정점에 이동가능한 좌표 큐 넣기
			for(int i = 8; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 정점에 인접한, 방문하지 않은 정점, 평지일 경우만 진입(큐에 넣기)
				
				// 맵 범위 안이고, 방문하지 않았고 평지인경우만
				// 지금은 상하좌우만 이동
				if(0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][kk] && m[nr][nc] == '0') {
					q.offer(new int[] {nr, nc, kk, moveCnt+1});
					visited[nr][nc][kk] = true;
				}			
			}
			
			if(kk == 0) continue; // 말처럼 이동할 수 있는 횟수가 남아있으면 진행
			for(int i = 0; i < 8; i++) { // 말처럼 이동 0 ~ 7
				int nr = r + dr[i]; 
				int nc = c + dc[i];
				if(0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][kk] && m[nr][nc] == '0') {
					q.offer(new int[] {nr,nc,kk-1,moveCnt + 1});
					visited[nr][nc][kk] = true;
				}
			}
			
			
			
		}
		
		
		System.out.println(minMoveCnt);
		
	}// end of main
	
} // end of class
