package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 오목 {
	static int[][] map;
	static int N = 20;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("오목.txt"));
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		// 이긴놈이 나왔는 확인하는 플래그
		boolean flag=false;
		//print(map);
		// 이중루프를 돌면서 1 or 2 가 나오면 4방향으로 오목인지 검색
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if(map[r][c]==1 || map[r][c]==2) {
					// 4방으로 탐색
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						int cnt = 1;
						// 1 ) 반대방향 확인 map[nr][nc] == map[r][c] 이라면 
						// 오목인지 확인할필요도 없다
						// int nr = r + dr[d]*-1;
						// int nc = c + dc[d]*-1;
						
						// 오목인지 확인전진 
						while(nr>0&&nr<N&&nc>0&&nc<N && map[nr][nc] == map[r][c]) {
							nr = nr+dr[d];
							nc = nc+dc[d];
							cnt ++;
						}
						if(cnt==5) {
							// 오목 발견
							// 2 ) 되돌아 가서 오목인지 확인
							int bCnt = 0;
							nr = nr + dr[d]*-1;
							nc = nc + dc[d]*-1;
							while(nr>0&&nr<N&&nc>0&&nc<N && map[nr][nc] == map[r][c]) {
								nr = nr+dr[d]*-1;
								nc = nc+dc[d]*-1;
								bCnt ++;
							}
							if(bCnt > 5) {
								continue;
							}
							// 이긴놈
							System.out.println(map[r][c]);
							System.out.println(r+" "+c);
							flag = true;
						}
					}
				}
			}
		}
		if(flag==false) {
			// 이긴놈 안나왔으면 비긴것임
			System.out.println(0);
		}
	}
	static int[] dr = {-1,0,1,1};
	static int[] dc = {1,1,1,0};
	
	private static void print(int[][] map) {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
