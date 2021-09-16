package zoff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
	private static int N;
	private static int M;
	static int ans = -1;
	static int[][] map;
	
	
	public static void main(String[] args) {
		
		// 퍼져나간다면 bfs문제 (step by step) 
		// 퍼져나가는 길이 몇개인가요? 하면 dfs
		
		// 상자의 크기가 1000보다 작다 -> bfs
		// 만약 백트래킹이 걸리지 않은 상태에서 10 이상이 넘거간다면 dfs로 풀게되면 백트래킹 없는 완전탐색으로는 스택오버플로우가 나올 가능성이 큼
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		print(map);
		
		Queue<Tomato> q = new LinkedList<>();
		// bfs
		// 시작점을 큐에다가 넣어주기
		for(int r = 0; r < map.length; r++) { // 토마토가 있는 위치 큐에다가 다 넣어주기
			for(int c = 0; c < map[r].length; c++) {
				if(map[r][c] == 1) {
					// 큐에다가 담아주기
					// 위치값을 가져와야함. r,c
					q.add(new Tomato(r, c, 0)); // day 기본값 0
				}
			}
		}
		
		
		
		
		while(q.size() > 0) {
			Tomato t = q.poll();
			
			ans = Math.max(ans, t.day);
			for(int d = 0; d < 4; d++) {
				// 토마토가 퍼져나가는 새로운 좌표값
				int nr = t.r + dr[d];
				int nc = t.c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) { // nr, nc의 새 위치가 익지 않은 토마토일때만 뻗어가기
					// 범위안에있을 때
					q.add(new Tomato(nr, nc, t.day + 1));
					map[nr][nc] = 1;
				}
				
			}
			
			
		} // end of while
		
		if(check(map) == false) ans = -1;
		
		System.out.println(ans);
		
	} // end of main
	
	private static boolean check(int[][] map2) { // 지도에 0으로 남아있는 토마토가 있는지 확인하기

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
                    return false;
                }
			}
		}
		
		return true;
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	// 토마토의 위치값을 저장해줄 위치값을 위한 클래스를 만들어줌
	static class Tomato {
		int r, c, day; // 토마토의 좌표, 몇일날 익는지의 정보를 저장할 day
		
		Tomato(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
	}
	
	
	private static void print(int[][] map) {
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				System.out.println(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
} // end of class
