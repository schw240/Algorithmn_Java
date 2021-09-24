package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_김한주 {
	
	static int R,C,T;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int cleaner = -1;
	static Queue<Dust> q;
	
	
	static class Dust {
		int x, y, size;

		public Dust(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		// R X C 크기의 격자판
		// 미서먼지가 확산되며 미세먼지가 있는 모든칸에서 동시에 일어난다.
		// 4방향으로 확산되고 공기청정기가 있거나 없는 칸으로는 확산되지 않는다.
		// 확산되는 양은 A(r,c) / 5 -> 소수점 버림
		// 확산되고나서 (r,c)에 남은 미세먼지의 양은 A(r,c) - A(r,c)/5 * 확산된 방향의 개수
		
		// 공기청정기에서 바람이 나오고 위쪽은 반시계, 아래쪽은 시계방향으로 순환
		// 바람이 불면 바람의 방향대로 한칸씩 이동
		// 공기청정기로 들어간 미세먼지는 정화됨
		
		// R,C,T T초후, R,C는 크기, 공기청정기가 설치된곳은 -1, 나머지는 미세먼지의 양
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 공기청정기 위치저장
				if(cleaner == -1 && map[i][j] == -1) {
					cleaner = i;
				}
			}
		} // 입력 완료
		
		// T초동안 동작하게 하기
		for(int t = 0; t < T; t++) {
			
			// 미세먼지 공간 확인
			checkDust();
			// 미세먼지 확산
			move();
			// 공기청정기 가동
			cleaning();
		}
		
		
		
		
		// 출력: T초가 지난 후 구사과 방에 남아있는 미세먼지 양 출력
		int ans = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
		
	} private static void cleaning() {
		// TODO Auto-generated method stub
		
		// 미세먼지 바람의 방향대로 한칸씩 이동
		// 위쪽은 반시계 아래는 시계 방향으로 이동
		
		int top = cleaner;
		int down = cleaner + 1;
		
		// 아래로 당기기
		for(int i = top - 1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 왼쪽으로 당기기
		for(int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 위로
        for (int i = 0; i < top; i++) {
        	map[i][C - 1] = map[i + 1][C - 1];
        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
        	map[top][i] = map[top][i-1];
        }
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;


        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1]; 
        }
        // 아래로 당기기
        for (int i = R - 1; i > down; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            map[down][i] = map[down][i - 1];
        }
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[down][1] = 0;


		
		
	} // end of cleaning

	// end of main

	private static void move() {
		// TODO Auto-generated method stub
		
		
		// R X C 크기의 격자판
		// 미서먼지가 확산되며 미세먼지가 있는 모든칸에서 동시에 일어난다.
		// 4방향으로 확산되고 공기청정기가 있거나 없는 칸으로는 확산되지 않는다.
		// 확산되는 양은 A(r,c) / 5 -> 소수점 버림
		// 확산되고나서 (r,c)에 남은 미세먼지의 양은 A(r,c) - A(r,c)/5 * 확산된 방향의 개수
		
		// bfs
		while(q.size() > 0) {
			
			Dust d = q.poll();
			
			int amount = d.size / 5;
			int cnt = 0;
			
			for(int i = 0; i < 4; i++) {
				int nr = d.x + dr[i];
				int nc = d.y + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
					// 범위 벗어나면
					continue;
				}
				
				if(map[nr][nc] == -1) {
					continue; // 공기청정기있는위치인경우
				}
				
				map[nr][nc] += amount; // 확산된양 더해주기
				cnt++;
			}
			// 확산 방향개수 곱해서 기존 양에서 빼주기
			map[d.x][d.y] -= amount * cnt; 
			
		}
		
	} // end of move

	private static void checkDust() {
		// TODO Auto-generated method stub
		
		q = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue; // 공기청정기나 없는곳은 제외
				q.add(new Dust(i, j, map[i][j])); // 미세먼지 전부 큐에 넣기
			}
		}
		
	} // end of checkDust
	
	
	
	
} // end of class
