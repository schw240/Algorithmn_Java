package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2636_치즈_김한주 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {

		// 정사각형 칸들로 이루어진 사각형 모양의 판이 있고
		// 그 위에 얇은 치즈(회색)이 놓여있다.
		// r친 부분에는 치즈가 놓여있지 않으며 치즈에는 하나 이상의 구멍이 있을 수 있다.

		// 치즈는 공기중에 놓으면 녹는데 1시간 이후 녹아 없어진다.
		// 치즈의 구멍속에는 공기가 없지만 구멍을 둘러싼 치즈가 녹아서 구멍이 열리면 구멍으로 공기가 들어간다.

		// 입력으로 사각형 모양의 판의 크기 가로, 세로길이
		// 둘째줄부터 가로줄의 모양이 윗줄부터 차례로 주어진다.
		// 치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[W][H];
		
		int cheese = 0;
		for (int i = 0; i < W; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < H; j++, index += 2) {
				map[i][j] = s.charAt(index); // 이렇게 하면 아스키형식의 데이터가 들어감
				if(map[i][j] == '1') cheese += 1;
			}
		}

//		bw.write(W + " " + H + "\n");
//		for(int i = 0; i < W; i++) {
//			bw.write(Arracs.toString(map[i]) + "\n");
//		} // 확인

		// 첫줄 치즈가 모두 녹아 없어지는데 걸리는 시간
		// 둘째줄 모두 녹기 한시간 전에 남아있는 치즈 조각이 놓여있는 칸의 개수
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[W][H];
		q.offer(new int[] {0, 0});
		int cnt = 0; 
		int time = 0;
		
		// 치즈가 다 없어질떄까지 반복
		while(true) {
			
			for(int i = 0; i < W; i++) {
				Arrays.fill(visited[i], false);
			}
			
			map[0][0] = -1;
			visited[0][0] = true;
			cnt = 0;
			
			while(q.size() > 0) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr >= 0 && nc >= 0 && nr < W && nc < H && !visited[nr][nc]) {
						visited[nr][nc] = true;
						
						// 바깥공기와 내부공기를 분리해주어야함
						if(map[nr][nc] == '0') {
							map[nr][nc] = -1; 
							q.add(new int[] {nr, nc});
						} else if(map[nr][nc] == '1') {
							// 겉면인경우
							map[nr][nc] = -1; // 녹여서 없애주기
							cnt++; // 녹인 치즈개수
						} else if(map[nr][nc] == Integer.parseInt("-1")) {
							q.offer(new int[] {nr, nc});
						}
					}
				}
			}
			time += 1;
			if(cnt == cheese) {
				System.out.println(time);
				System.out.println(cnt);
				break;
			} else {
				cheese -= cnt;
			}
			
			q.add(new int[] {0,0});
		} // end of while
		

	} // end of main
} // end of class
