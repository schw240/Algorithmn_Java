package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어 {
	
	static int N, M; // N X N 크기, 물고기 M마리
	static int[][] map;
	static StringTokenizer st = null;
	static int ans = 0;
	
	
	public static void main(String[] args) throws Exception {
		
		// 아기상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 출력하기
		// 0 빈칸, 1~6 물고기크기, 9 아기상어 위치
		
		
		// 처음 아기상어 크기는 2, 1초에 1칸 이동
		// 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없음, 자신보다 작은 물고기만 먹을 수 있음
		// 크기가 같은 물고기는 먹을 수 는 없지만 지나갈 수 는 있음
		
		// 더이상 먹을 수 있는 물고기가 없다면 엄마상어에게 도움 요청
		// 먹을수 있는 물고기 1마리면 먹음, 1마리보다 많다면 가장 가까운 거리의 물고기 먹음
		// 거리가 가까운 물고기가 많다면 가장 위의 있는 물고기, 여러마리면 가장 왼쪽에 있는 물고기
		
		// 자신의 크기와 같은 수의 물고기를 먹으면 크기 1 증가
		// 몇초동안 엄마상어에게 도움을 요청하지 않고 물고기를 잡아먹는지?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		Queue<Shark> q = new LinkedList<>();
		int size = 2; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					q.add(new Shark(i, j, size));
					map[i][j] = 0;
				}
			}
		}
		
		int eat = 0;
		int time = 0;
		
		while(true) {
			LinkedList<Shark> s = new LinkedList<>();
			int[][] dist = new int[N][N]; // 거리
			
			while(q.size() > 0) {
				Shark sh = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = sh.r + dr[i];
					int nc = sh.c + dc[i];
					
					// 범위 안이고 지나가거나 먹을수있는 경우
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && dist[nr][nc] == 0 && map[nr][nc] <= size) {
						dist[nr][nc] = dist[sh.r][sh.c] + 1;
//						System.out.println(dist[nr][nc]);
						
						// 먹이감 밢견
						if(map[nr][nc] >= 1 && map[nr][nc] <= 6 && map[nr][nc] < size) {
							// 물고기이고 자기 사이즈보다 작을떄
							s.add(new Shark(nr, nc, dist[nr][nc]));
							q.add(new Shark(nr, nc, dist[nr][nc]));
							continue;
						}
						
						// 먹이는 없지만 지나갈수는 있음
						q.add(new Shark(nr, nc, dist[nr][nc]));
					}
				}
				
			}
			
			// 더이상 먹을게 없는경우
			if(s.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Shark eatFish = s.get(0);
			for(int i = 1; i < s.size(); i++) {
				if(eatFish.dist > s.get(i).dist) {
					eatFish = s.get(i);
				}
				
				if(eatFish.dist == s.get(i).dist) {
					if(eatFish.r > s.get(i).r) {
						eatFish = s.get(i);
						continue;
					} else if(eatFish.r == s.get(i).r) {
						if(eatFish.c > s.get(i).c);
						eatFish = s.get(i);
					}
				}
				
			}
			
			time += eatFish.dist;
			eat++;
			
			map[eatFish.r][eatFish.c] = 0;
			if(eat == size) {
				size++;
				eat = 0;
			}
			
			q.add(new Shark(eatFish.r, eatFish.c, size));
			
			
		}
		
		
		
		// 확인
//		System.out.println(N);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		
		
		
		
	} // end of main
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static class Shark {
		int r, c, dist; 

		Shark(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	} // end of Fish
	
} // end of class
