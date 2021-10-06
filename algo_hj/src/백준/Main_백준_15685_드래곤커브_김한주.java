package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_15685_드래곤커브_김한주 {
	
	
	static int N;
	static int[][] map = new int[101][101];
	static int[] dr = {1, 0, -1, 0}; // 오른쪽이 1,0임
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		
		
		// 시작점, 시작방향, 세대 3가지 속성으로 이루어져있음
		
		// 0세대 드래곤 커브는 길이가 1인 선분, (0,0)에서 시작하고 시작방향은 오른쪽인 0세대 드래곤 커브
		// 1세대 드래곤버브는 0세대 커브 끝점을 기준으로 시계방향 90도 회전시킨 다음 0세대 드래곤 커브 끝점에 이어붙임
		// K세대 드래곤 커브는 K-1세대 드래곤 커브 끝점을 기준으로 90도 시계방향 회전시킨 다음 끝점에 붙인다.
		
		// N개 드래곤 커브
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 크기가 1X1인 정사각형의 네 꼭지점이 모두 드래곤 커브의 일부인 정사각형의 개수를 구하시오
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// x,y,d,g로 이루어져있으며 x,y는 시작점, d는 시작방향, g는 세대
			// 방향은 0,1,2,3중 하나이며 0은 x좌표가 증가(우), 1은 y좌표가 감소(상), 2 x좌표 감소(좌), 3 y좌표 증가(하)
			
			// 0세대 우
			// 1세대 우상
			// 2세대 우상 좌상
			// 3세대 우상좌상 좌하좌상 0121 2321
			
			// 이전 정보에서 반시계방향으로 회전? 1 -> 2, 0 -> 1
			// 0121 -> 2321(뒤에서부터 숫자가 1씩 증가해서 붙음)
			List<Integer> curves = new ArrayList<Integer>();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); // 좌표
			int d = Integer.parseInt(st.nextToken()); // 시작방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			curves.add(d); // 방향 넣어주기
			
			for(int j = 0; j < g; j++) { // 세대 개수만큼 넣어주기
				for(int k = curves.size() - 1; k >= 0; k--) {
					curves.add((curves.get(k) + 1) % 4); // 뒤에서 부터 꺼내가지고 1씩 증가시켜서 추가해주기
				}
				
			}
			
//			for(int j = 0; j < curves.size(); j++) {
//				System.out.print(curves.get(j) + " ");
//			}
//			
//			System.out.println();
			
			map[x][y] = 1;
			for(int j = 0; j < curves.size(); j++) {
//				System.out.println(curves.get(j));
				x += dr[curves.get(j)];
				y += dc[curves.get(j)];
//				System.out.println(x + " " + y);
				map[x][y] = 1; // 좌표 설정
				
			}
			
			
			
		}
		
		// 예제 1번
		// (3,3) 오른쪽 시작 1세대 0(우)1(상)								01
		// (4,2) 위 시작3세대 1(상)2(좌)3(하)2(좌)3(하)0(우)3(하)2(좌)		1232 3032
		// (4,2) 우 시작 1세대 2(좌)3(하)									23
		
		int ans = 0 ;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
					ans++; // 사각형이면 1증가
				}
			}
		}
		
		System.out.println(ans);
		
		
	} // end of main
	
} // end of class
