package zoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import zoff.벽부수고이동하기.Point;
import zoff.토마토.Tomato;

public class diceTest {
	
	// 인접행렬 N은 정점개수
	static boolean[][] adjMatrix; // 인접행렬(가중치없음)
	
	
	static int N, numbers[], input[];
	static boolean[] isSelected;
	static int totalCnt;
	
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // 주사위 던진 횟수
//		numbers = new int[N];
//		totalCnt = 0;
//		
//		int M = sc.nextInt();
//		input = new int[N];
//		for(int i = 0; i < N; i++) {
//			input[i] = sc.nextInt();
//		}
//		
//		switch(M) {
//		case 1: // 주사위던지기1 중복순열
//			dice1(0);
//			break;
//			
//		case 2: // 주사위던지기2 순열
//			isSelected = new boolean[7];
//			dice2(0);
//			break;
//		case 3: // 주사위던지기3 중복조합
//			dice3(0, 1);
//			break; 
//		case 4: // 주사위던지기4 조합
//			isSelected = new boolean[7];
//			dice4(0, 1);
//			break;
//		}
//		
//		System.out.println("경우의 수: " + totalCnt);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(br.readLine()); // 간선 개수
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}
		
		bfs();
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(0, visited);
		
	} // end of main
	
	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		q.offer(0);
		visited[0] = true;
		
		while(q.size() > 0) {
			int cur = q.poll();
			
			System.out.println((char)(cur + 65));
		
			for(int i = 0; i < N; i++) {
				if(!visited[i] // 미방문 
						&& adjMatrix[cur][i]) { // 인접행렬
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	private static void dfs(int cur, boolean[] visited) {
		System.out.println((char)(cur + 65));
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[cur][i]) {
				
				visited[i] = true;
				dfs(i, visited);
			}
		}
		
	}
	
	
	private static void dice1(int cnt) {
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) {
		
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			// 중복체크
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void dice3(int cnt, int start) {
		
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i); // 현재 선택한 수부터 처리
		}
	}
	
	private static void dice4(int cnt, int start) {
		
		if(cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
	
	private static void generateSubset(int cnt) {
		
		if(cnt == N) {
			//부분집합완성
			totalCnt++;
			for(int i = 0; i < N; i++) {
				System.out.println((isSelected[i] ? input[i]:'X') + " ");
			}
			
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
	
	private static void dijkstra() {
		
	}
	
	
	
//	private static int N;
//	private static int M;
//	static int ans = Integer.MAX_VALUE;
//	static int[][] map;
//	static int[] dr = {1,-1,0,0};
//	static int[] dc = {0,0,1,-1};
//	
//	
//	public static void main(String[] args) {
//		
//		
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		map = new int[N+1][M+1];
//		
//		for(int r = 1; r <=N; r++) {
//			String next = sc.next();
//			for(int c = 1; c <= M; c++) {
//				map[r][c] = Integer.parseInt(next.charAt(c-1) + "");
//			}
//		}
//		
//		// print(map);
//		
//		// bfs
//		Queue<Point> q = new LinkedList<>();
//		boolean[][][] v = new boolean[N+1][M+1][2];
//		q.add(new Point(1, 1, 1, 0));
//		v[1][1][0] = true; // 안부수고간건 0번에 처리 부수고간건 1번에 처리
//		while(q.size() > 0) {
//			Point p =  q.poll();
//			if(p.r == N && p.c == M) {
//				// 끝점에 도착한것
//				ans = Math.min(ans,  p.cnt); 
//				break;
//			}
//			
//			// 이동
//			for(int d = 0; d < 4; d++) {
//				int nr = p.r + dr[d];
//				int nc = p.c + dc[d];
//				
//				if(nr > 0 && nr <= N && nc > 0 && nc <= M) {
//					// 지도 영역 안에있음
//					if(map[nr][nc] == 0 && !v[nr][nc][p.puk]) {
//						// 새 위치가 0이고 방문하지 않았다면
//						q.add(new Point(nr, nc, p.cnt + 1, p.puk));
//					} else if(map[nr][nc] == 1 && p.puk == 0) { // 벽을 한번은 부술 수 있음
//						// 부순적이 없다면
//						v[nr][nc][1] = true; // 1이 부쉈다는 의미
//						q.add(new Point(nr, nc, p.cnt + 1, 1));
//					}
//				}
//				
//			}
//			
//			
//			
//		} // end of while
//		
//		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//		
//		
//	} // end of main
//	
//	static class Point {
//		int r, c, cnt; // 몇칸 이동했는지 셀 cnt
//		int puk;
//		
//		Point(int r, int c, int cnt, int puk) {
//			this.r = r;
//			this.c = c;
//			this.cnt = cnt;
//			this.puk = puk;
//		}
//	}
//	
//	private static void print(int[][] map) {
//		for(int r = 1; r <= N; r++) {
//			for(int c = 1; c <= M; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
//	}
	
//	
//	public class 토마토 {
//		private static int N;
//		private static int M;
//		static int ans = -1;
//		static int[][] map;
//		
//		
//		public static void main(String[] args) {
//			
//			// 퍼져나간다면 bfs문제 (step by step) 
//			// 퍼져나가는 길이 몇개인가요? 하면 dfs
//			
//			// 상자의 크기가 1000보다 작다 -> bfs
//			// 만약 백트래킹이 걸리지 않은 상태에서 10 이상이 넘거간다면 dfs로 풀게되면 백트래킹 없는 완전탐색으로는 스택오버플로우가 나올 가능성이 큼
//			
//			Scanner sc = new Scanner(System.in);
//			M = sc.nextInt();
//			N = sc.nextInt();
//			map = new int[N][M];
//			
//			for(int r = 0; r < map.length; r++) {
//				for(int c = 0; c < map[r].length; c++) {
//					map[r][c] = sc.nextInt();
//				}
//			}
//			
////			print(map);
//			
//			Queue<Tomato> q = new LinkedList<>();
//			// bfs
//			// 시작점을 큐에다가 넣어주기
//			for(int r = 0; r < map.length; r++) { // 토마토가 있는 위치 큐에다가 다 넣어주기
//				for(int c = 0; c < map[r].length; c++) {
//					if(map[r][c] == 1) {
//						// 큐에다가 담아주기
//						// 위치값을 가져와야함. r,c
//						q.add(new Tomato(r, c, 0)); // day 기본값 0
//					}
//				}
//			}
//			
//			
//			
//			
//			while(q.size() > 0) {
//				Tomato t = q.poll();
//				
//				ans = Math.max(ans, t.day);
//				for(int d = 0; d < 4; d++) {
//					// 토마토가 퍼져나가는 새로운 좌표값
//					int nr = t.r + dr[d];
//					int nc = t.c + dc[d];
//					
//					if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) { // nr, nc의 새 위치가 익지 않은 토마토일때만 뻗어가기
//						// 범위안에있을 때
//						q.add(new Tomato(nr, nc, t.day + 1));
//						map[nr][nc] = 1;
//					}
//					
//				}
//				
//				
//			} // end of while
//			
//			if(check(map) == false) ans = -1;
//			
//			System.out.println(ans);
//			
//		} // end of main
//		
//		private static boolean check(int[][] map2) { // 지도에 0으로 남아있는 토마토가 있는지 확인하기
//
//			for(int i = 0; i < map.length; i++) {
//				for(int j = 0; j < map[i].length; j++) {
//					if (map[i][j] == 0) {
//	                    return false;
//	                }
//				}
//			}
//			
//			return true;
//		}
//
//		static int[] dr = {1,-1,0,0};
//		static int[] dc = {0,0,1,-1};
//		
//		
//		// 토마토의 위치값을 저장해줄 위치값을 위한 클래스를 만들어줌
//		static class Tomato {
//			int r, c, day; // 토마토의 좌표, 몇일날 익는지의 정보를 저장할 day
//			
//			Tomato(int r, int c, int day) {
//				this.r = r;
//				this.c = c;
//				this.day = day;
//			}
//			
//		}
//		
//		
//		private static void print(int[][] map) {
//			for(int r = 0; r < map.length; r++) {
//				for(int c = 0; c < map[r].length; c++) {
//					System.out.println(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//		}
//		
//	} // end of class

//	
//	public class DP2_LISTest1 {
//		
//		
//		public static void main(String[] args) {
//			
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			int[] arr = new int[N];
//			int[] LIS = new int[N]; // 각 원소를 끝으로 하는 최장길이
//			
//			for(int i = 0; i < N; i++) {
//				arr[i] = sc.nextInt();
//			}
//			
//			
//			
//			int max = 0;
//			for(int i = 0; i < N; i++) {
//				LIS[i] = 1;
//				for(int j = 0; j < i; i++) { // j는 i의 앞쪽 원소
//					if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
//						LIS[i] = LIS[j] + 1;
//					}
//				} // i를 끝으로 하는 최장길이 값 계산 완료
//				if(max < LIS[i]) max = LIS[i];
//			}
//			System.out.println(max);
//			
//		}
//		
//		
//		
//	}

//	
//	package zoff;
//
//	import java.util.Scanner;
//
//	public class DP2_MinCoinTest {
//		
//		
//		public static void main(String[] args) {
//			
//			Scanner sc = new Scanner(System.in);
//			int money = sc.nextInt();
//			int[] D = new int[money + 1];
//			
//			D[0] = 0; 
//			for(int i = 1; i <= money; i++) {
//				int min = Integer.MAX_VALUE;
//				if(i >= 1 && D[i-1] < min) min = D[i-1] + 1;
//				if(i >= 4 && D[i-4] < min) min = D[i-4] + 1;
//				if(i >= 6 && D[i-6] < min) min = D[i-6] + 1;
//				
//				
//				D[i] = min;
//			}
//			
//			System.out.println(D[money]);
//			
//			
//		}
//	}

	
//	
//	package zoff;
//
//	import java.util.Scanner;
//
//	public class DP3_KnapsackTest {
//
//		
//		public static void main(String[] args) {
//			
//			
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			int W = sc.nextInt();
//			
//			int[] weights = new int[N+1];
//			int[] profits = new int[N+1];
//			
//			for(int i = 1; i <= N; i++) {
//				weights[i] = sc.nextInt();
//				profits[i] = sc.nextInt();
//			}
//			
//			int[][] D = new int[N+1][W+1];
//			
//			for(int i = 1; i <= N; i++) {
//				for(int w = 1; w <= W; w++) {
//					 
//					if(weights[i] <= w) { // 해당 값을 넣을 수 있다.
//						D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w-weights[i]]);
//					} else { // 해당 물건을 가방에 넣을 수 없다.
//						D[i][w] = D[i-1][w];
//					}
//				}
//			}
//			
//			
//			System.out.println(D[N][W]);
//		}
//	}

//	
//	package zoff;
//
//	import java.util.ArrayList;
//	import java.util.Arrays;
//	import java.util.Scanner;
//
//	public class MeetingRoomTest {
//		
//		static class Meeting implements Comparable<Meeting> {
//			int start, end;
//
//			public Meeting(int start, int end) {
//				super();
//				this.start = start;
//				this.end = end;
//			}
//
//			@Override
//			public int compareTo(Meeting o) {
//				// TODO Auto-generated method stub
//				int value = this.end - o.end; // 내거에서 상대거를 빼기
//				if(value != 0) return value; // 종료시간이 다르면
//				return this.start - o.start; // 종료시간이 같다면 시작시간이 빠른순서로.
//			}
//
//			@Override
//			public String toString() {
//				return "Meeting [start=" + start + ", end=" + end + "]";
//			}
//			
//			
//			
//		}
//		
//		
//		public static void main(String[] args) {
//			
//			
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			
//			Meeting[] meetings = new Meeting[N];
//			for(int i = 0; i < N; i++) {
//				meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
//			}
//			
//			
//			for(Meeting meeting : getSchedule(meetings)) {
//				System.out.println(meeting);
//			}
//			
//			
//		}
//		
//		
//		
//		static ArrayList<Meeting> getSchedule(Meeting[] meetings) {
//			ArrayList<Meeting> list = new ArrayList<>();
//			
//			Arrays.sort(meetings); // 종료시간 기준 오름차순 정렬
//			
//			list.add(meetings[0]); // 청회의 추가
//			
//			for(int i = 1, size = meetings.length; i < size; i++) {
//				if(list.get(list.size()-1).end <= meetings[i].start) {
//					list.add(meetings[i]);
//				}
//			}
//			return list;
//		}
//	}

//	
//	package zoff;
//
//	public class R03_HanoiTest {
//		
//		private static void hanoi(int n, int start, int temp, int dest) {
//			
//			if(n == 0) {
//				return;
//			}
//			
//			hanoi(n-1, start, dest, temp); // 자신의 위쪽의 n-1개 원판 들어내기: 임시기둥으로
//			System.out.println(n + ":" + start + " -> " + dest); // 자신의 원판 목적기둥으로 옮기기
//			hanoi(n-1, temp, start, dest); // 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기: 목적 기둥으로 옮기기
//			
//		}
//		
//		public static void main(String[] args) {
//			hanoi(3, 1, 2, 3);
//		}
//	}
//	
//	package 백준;
//
//	import java.io.BufferedReader;
//	import java.io.InputStreamReader;
//	import java.util.LinkedList;
//	import java.util.Queue;
//	import java.util.StringTokenizer;
//
//	public class Main_백준_17144_미세먼지안녕_김한주 {
//		
//		static int R,C,T;
//		static int[][] map;
//		static int[] dr = {-1,1,0,0};
//		static int[] dc = {0,0,-1,1};
//		
//		static int cleaner = -1;
//		static Queue<Dust> q;
//		
//		
//		static class Dust {
//			int x, y, size;
//
//			public Dust(int x, int y, int size) {
//				super();
//				this.x = x;
//				this.y = y;
//				this.size = size;
//			}
//			
//			
//		}
//		
//		public static void main(String[] args) throws Exception {
//			
//			// R X C 크기의 격자판
//			// 미서먼지가 확산되며 미세먼지가 있는 모든칸에서 동시에 일어난다.
//			// 4방향으로 확산되고 공기청정기가 있거나 없는 칸으로는 확산되지 않는다.
//			// 확산되는 양은 A(r,c) / 5 -> 소수점 버림
//			// 확산되고나서 (r,c)에 남은 미세먼지의 양은 A(r,c) - A(r,c)/5 * 확산된 방향의 개수
//			
//			// 공기청정기에서 바람이 나오고 위쪽은 반시계, 아래쪽은 시계방향으로 순환
//			// 바람이 불면 바람의 방향대로 한칸씩 이동
//			// 공기청정기로 들어간 미세먼지는 정화됨
//			
//			// R,C,T T초후, R,C는 크기, 공기청정기가 설치된곳은 -1, 나머지는 미세먼지의 양
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			R = Integer.parseInt(st.nextToken());
//			C = Integer.parseInt(st.nextToken());
//			T = Integer.parseInt(st.nextToken());
//			
//			map = new int[R][C];
//			
//			for(int i = 0; i < R; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
//				for(int j = 0; j < C; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//					
//					// 공기청정기 위치저장
//					if(cleaner == -1 && map[i][j] == -1) {
//						cleaner = i;
//					}
//				}
//			} // 입력 완료
//			
//			// T초동안 동작하게 하기
//			for(int t = 0; t < T; t++) {
//				
//				// 미세먼지 공간 확인
//				checkDust();
//				// 미세먼지 확산
//				move();
//				// 공기청정기 가동
//				cleaning();
//			}
//			
//			
//			
//			
//			// 출력: T초가 지난 후 구사과 방에 남아있는 미세먼지 양 출력
//			int ans = 0;
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					if(map[i][j] == -1) continue;
//					ans += map[i][j];
//				}
//			}
//			
//			System.out.println(ans);
//			
//		} private static void cleaning() {
//			// TODO Auto-generated method stub
//			
//			// 미세먼지 바람의 방향대로 한칸씩 이동
//			// 위쪽은 반시계 아래는 시계 방향으로 이동
//			
//			int top = cleaner;
//			int down = cleaner + 1;
//			
//			// 아래로 당기기
//			for(int i = top - 1; i > 0; i--) {
//				map[i][0] = map[i-1][0];
//			}
//			// 왼쪽으로 당기기
//			for(int i = 0; i < C - 1; i++) {
//				map[0][i] = map[0][i+1];
//			}
//			// 위로
//	        for (int i = 0; i < top; i++) {
//	        	map[i][C - 1] = map[i + 1][C - 1];
//	        }
//	        // 오른쪽으로 당기기
//	        for (int i = C - 1; i > 1; i--) {
//	        	map[top][i] = map[top][i-1];
//	        }
//	        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
//	        map[top][1] = 0;
//
//
//	        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
//	        // 위로 당기기
//	        for (int i = down + 1; i < R - 1; i++) {
//	            map[i][0] = map[i + 1][0];
//	        }
//	        // 왼쪽으로 당기기
//	        for (int i = 0; i < C - 1; i++) {
//	            map[R - 1][i] = map[R - 1][i + 1]; 
//	        }
//	        // 아래로 당기기
//	        for (int i = R - 1; i > down; i--) {
//	            map[i][C - 1] = map[i - 1][C - 1];
//	        }
//	        // 오른쪽으로 당기기
//	        for (int i = C - 1; i > 1; i--) {
//	            map[down][i] = map[down][i - 1];
//	        }
//	        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
//	        map[down][1] = 0;
//
//
//			
//			
//		} // end of cleaning
//
//		// end of main
//
//		private static void move() {
//			// TODO Auto-generated method stub
//			
//			
//			// R X C 크기의 격자판
//			// 미서먼지가 확산되며 미세먼지가 있는 모든칸에서 동시에 일어난다.
//			// 4방향으로 확산되고 공기청정기가 있거나 없는 칸으로는 확산되지 않는다.
//			// 확산되는 양은 A(r,c) / 5 -> 소수점 버림
//			// 확산되고나서 (r,c)에 남은 미세먼지의 양은 A(r,c) - A(r,c)/5 * 확산된 방향의 개수
//			
//			// bfs
//			while(q.size() > 0) {
//				
//				Dust d = q.poll();
//				
//				int amount = d.size / 5;
//				int cnt = 0;
//				
//				for(int i = 0; i < 4; i++) {
//					int nr = d.x + dr[i];
//					int nc = d.y + dc[i];
//					
//					if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
//						// 범위 벗어나면
//						continue;
//					}
//					
//					if(map[nr][nc] == -1) {
//						continue; // 공기청정기있는위치인경우
//					}
//					
//					map[nr][nc] += amount; // 확산된양 더해주기
//					cnt++;
//				}
//				// 확산 방향개수 곱해서 기존 양에서 빼주기
//				map[d.x][d.y] -= amount * cnt; 
//				
//			}
//			
//		} // end of move
//
//		private static void checkDust() {
//			// TODO Auto-generated method stub
//			
//			q = new LinkedList<>();
//			
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					if(map[i][j] == -1 || map[i][j] == 0) continue; // 공기청정기나 없는곳은 제외
//					q.add(new Dust(i, j, map[i][j])); // 미세먼지 전부 큐에 넣기
//				}
//			}
//			
//		} // end of checkDust
//		
//		
//		
//		
//	} // end of class


//	
//	package 백준;
//
//	import java.io.BufferedReader;
//	import java.io.InputStreamReader;
//	import java.util.StringTokenizer;
//
//	public class Main_백준_17208_카우버거알바생 {
//		private static int[][][] dp;
//		private static int[] burger;
//		private static int[] fries;
//		private static int N;
//		private static int M;
//		private static int K;
//
//		public static void main(String[] args) throws Exception {
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			N = Integer.parseInt(st.nextToken()); // 주문의 수
//			M = Integer.parseInt(st.nextToken()); // 치즈버거 개수
//			K = Integer.parseInt(st.nextToken()); // 감자튀김 개수
//			
//			burger = new int[101];
//			fries = new int[101];
//			
//			dp = new int[101][301][301];
//			
//			for(int i = 0; i < N; i++) { // 치즈버거 요구개수 x, 감자튀김 요구개수 y
//				st = new StringTokenizer(br.readLine(), " ");
//				burger[i] = Integer.parseInt(st.nextToken());
//				fries[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			// 주방에 남은 치즈버거와 감자튀김을 사용해 처리할 수 있는 최대 주문의 개수
//			int ans = knapsack(0, M, K);
//			
//			
//			
//			System.out.println(ans);
//			
//		} // end of main
//
//		private static int knapsack(int start, int b, int f) {
//			// TODO Auto-generated method stub
//			if(start == N) {
//				return 0;
//			}
//			
//			if(dp[start][b][f] >= 1) {
//				return dp[start][b][f];
//			}
//			
//			int res = 0;
//			
//			if(burger[start] <= b && fries[start] <= f) {
//				res = knapsack(start + 1, b - burger[start], f - fries[start]) + 1; // 주문 처리
//			}
//			
//			res = Math.max(res, knapsack(start + 1, b, f));
//			dp[start][b][f] = res;
//			return res;
//		}
//	} // end of class
//
//	package zoff;
//
//	import java.util.Scanner;
//
//	public class NQueenTest {
//		
//		static int N, col[], cnt;
//		public static void main(String[] args) {
//			
//			Scanner sc = new Scanner(System.in);
//			N = sc.nextInt();
//			col = new int[N+1];
//			cnt = 0;
//			
//			setQueens(1); // 1행부터 시작
//			
//			System.out.println(cnt);
//		}
//
//		
//		private static void setQueens(int rowNo) {
//			
//			// 유망한지 체크: rowNo -1 행까지 유망한지 체크
//			if(!isAvailable(rowNo -1)) return; // 이전행까지 불가능하다면 돌려보내기
//			
//			
//			if(rowNo > N) { // 마지막행까지 왔다면
//				cnt++;
//				return;
//			}
//			
//			// 현재 퀸 1열부터 N열까지 놓아보기
//			// 놓았으면 다음 퀸 놓으러 가기
//			
//			for(int i = 1; i <= N; i++) {
//				col[rowNo] = i; // i열 앞에 놓아보기
//				setQueens(rowNo + 1);
//			}
//			
//		}
//		
//		
//		private static boolean isAvailable(int rowNo) {
//			// TODO Auto-generated method stub
//			
//			for(int k = 1; k < rowNo; k++) { //k는 이전 퀸
//				if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo - k)) { // 같은 열은 안됨
//					return false;
//				}
//				// 대각선 체크
//				
//				
//			}
//			
//			return true;
//			
//		}
//		
//	}

	
	
	
//	package zoff;
//
//	public class MakeSpaceTest {
//		
//		static int white, green;
//		static int[][] spaces;
//		
//		
//		public static void main(String[] args) {
//			
//			int n = 8;
//			spaces = new int[][] {
//				{1,1,0,0,0,0,1,1},
//				{1,1,0,0,0,0,1,1},
//				{0,0,0,0,1,1,0,0},
//				{0,0,0,0,1,1,0,0},
//				{1,0,0,0,1,1,1,1},
//				{0,1,0,0,1,1,1,1},
//				{0,0,1,1,1,1,1,1},
//				{0,0,1,1,1,1,1,1}
//			};
//			
//			cut(0,0,n);
//			
//			System.out.println(green);
//			System.out.println(white);
//		}
//		
//		
//		private static void cut(int r, int c, int size) { // 행좌표, 열좌표, 크기
//			
//			int sum = 0;
//			
//			for(int i = r; i < r + size; i++) {
//				for(int j = c; j < c + size; j++) {
//					sum += spaces[i][j];
//				}
//			}
//			
//			// 같은 색인지 체크
//			if(sum == size * size) {
//				// 같으면 초록색
//				green++;
//			} else if(sum == 0) {
//				// 0이면 전부 하양
//				white++;
//			} else {
//				// 색이 섞여있다는 의미이므로 재귀
//				// 4분할 하여 각각의 사각형으로 처리
//				int half = size / 2; 
//				
//				cut(r, c, half); // 1사분면(현재 r,c를 4각형의 1사분면 시작좌표로 잡음)
//				cut(r, c + half, half); // 2사분면 시작점은 행은 그대로이고 열을 half만큼 이동한 위치
//				cut(r + half, c, half);
//				cut(r + half, c + half, half);
//			}
//			
//			
//		}
//		
//		
//		
//	}


// 플로이드 워셜	
//	package 프로그래머스.고득점kit.그래프;
//
//	import java.util.Arrays;
//
//	public class 순위 {
//	    static int INF = Integer.MAX_VALUE;
//		
//		public static int solution(int n, int[][] results) {
//			
//			int INF = 100001; 
//			int answer = 0; 
//			int[][] fw = new int[n+1][n+1];
//			
//			//모든 경로 INF로 채우기 
//			for(int[] arr : fw) { 
//				Arrays.fill(arr, INF); 
//			}
//
//			//플로이드 워샬 표 채우기 
//			for(int[] arr : results) { 
//				fw[arr[0]][arr[1]] = 1; 
//			}
//
//
//			for(int k = 1; k < fw.length; k++) { //거치는 경로
//				for(int i = 1; i < fw.length; i++) { //시작 정점
//					for(int j = 1; j < fw.length; j++) { //도착 정점 ex) k-1, i-2, j-3 이면 2->3 > 2->1->3을 비교
//						if(fw[i][j] > fw[i][k] + fw[k][j]) { 
//							fw[i][j] = fw[i][k] + fw[k][j]; 
//						}
//					}
//				}
//			}
//
//			for(int i = 1; i < fw.length; i++) {
//
//				boolean flag = true;	
//				for(int j = 1; j < fw[i].length; j++) {
//					if(i == j) continue;
//					if(fw[i][j] == INF && fw[j][i] == INF) {
//						flag = false;
//						break;
//					}
//				}
//				if(flag) answer++;	
//			}
//				
//			
//			return answer;
//						
//						
//		}
//		
//		public static void main(String[] args) {
//			
//			int n = 5;
//			int[][] results = {
//					{4,3},
//					{4,2},
//					{3,2},
//					{1,2},
//					{2,5}
//			};
//			System.out.println(solution(n, results));
//			
//			
//		}
//	}

//	package 프로그래머스.고득점kit.동적계획법;
//
//	import java.util.HashSet;
//	import java.util.Set;
//
//	public class N으로표현 {
////		static int answer = -1;// 전역변수로 설정
//	//
////		public static void dfs(int N, int number, int cnt, int sum) {
////			if (cnt > 8) {// 8번안에 끝내야한다
////				answer = -1;
////				return;
////			}
////			if (sum == number) {
////				if (answer == -1 || cnt < answer) {// 처음이거나 기존answer보다 더 최솟값을 발견했다면
////					answer = cnt;
////					return;
////				}
////			}
////			int NN = 0;
////			for (int i = 0; i < 8 - cnt; i++) {// 8번안에 끝내야하므로
////				NN = 10 * NN + N;// 숫자 N으로 만들 수 있는 수
////				dfs(N, number, cnt + i + 1, sum + NN);
////				dfs(N, number, cnt + i + 1, sum - NN);
////				dfs(N, number, cnt + i + 1, sum * NN);
////				dfs(N, number, cnt + i + 1, sum / NN);
////			}
////		} // end of dfs
//	//
////		public static int solution(int N, int number) {
//	//
////			dfs(N, number, 0, 0);
////			return answer;
//	//
////		}
//		
//		public static int solution(int N, int number) {
//		       int answer = -1;
//		        Set<Integer>[] setArr = new Set[9];
//		        int t = N;
//		        for(int i = 1; i < 9; i++) {
//		            setArr[i] = new HashSet<>();
//		            setArr[i].add(t);
//		            t = t * 10 + N;
//		        }
//		        for(int i = 1; i < 9; i++) {
//		            for(int j = 1; j < i; j++) {
//		                for(Integer a : setArr[j]) {
//		                    for(Integer b : setArr[i - j]) {
//		                        setArr[i].add(a + b);
//		                        setArr[i].add(a - b);
//		                        setArr[i].add(b - a);
//		                        setArr[i].add(a * b);
//		                        if(b != 0) {
//		                            setArr[i].add(a / b);
//		                        }
//		                        if(a != 0) {
//		                            setArr[i].add(b / a);
//		                        }
//		                    }
//		                }
//		            }
//		        }
//		        for(int i = 1; i < 9; i++) {
//		            if(setArr[i].contains(number)) {
//		                answer = i;
//		                break;
//		            }
//		        }
//		        return answer;
//		}
//
//		public static void main(String[] args) {
//			int N = 5;
////			int N = 2;
//			int number = 12;
////			int number = 11;
//
//			System.out.println(solution(N, number));
//		} // end of main
//	} // end of class

	
//	package 백준;
//
//	import java.io.BufferedReader;
//	import java.io.InputStreamReader;
//	import java.util.LinkedList;
//	import java.util.Queue;
//	import java.util.StringTokenizer;
//
//	public class Main_백준_16236_아기상어 {
//		
//		static int N, M; // N X N 크기, 물고기 M마리
//		static int[][] map;
//		static StringTokenizer st = null;
//		static int ans = 0;
//		
//		
//		public static void main(String[] args) throws Exception {
//			
//			// 아기상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 출력하기
//			// 0 빈칸, 1~6 물고기크기, 9 아기상어 위치
//			
//			
//			// 처음 아기상어 크기는 2, 1초에 1칸 이동
//			// 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없음, 자신보다 작은 물고기만 먹을 수 있음
//			// 크기가 같은 물고기는 먹을 수 는 없지만 지나갈 수 는 있음
//			
//			// 더이상 먹을 수 있는 물고기가 없다면 엄마상어에게 도움 요청
//			// 먹을수 있는 물고기 1마리면 먹음, 1마리보다 많다면 가장 가까운 거리의 물고기 먹음
//			// 거리가 가까운 물고기가 많다면 가장 위의 있는 물고기, 여러마리면 가장 왼쪽에 있는 물고기
//			
//			// 자신의 크기와 같은 수의 물고기를 먹으면 크기 1 증가
//			// 몇초동안 엄마상어에게 도움을 요청하지 않고 물고기를 잡아먹는지?
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			N = Integer.parseInt(br.readLine());
//			map = new int[N][N];
//			
//			Queue<Shark> q = new LinkedList<>();
//			int size = 2; 
//			
//			for(int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for(int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//					if(map[i][j] == 9) {
//						q.add(new Shark(i, j, size));
//						map[i][j] = 0;
//					}
//				}
//			}
//			
//			int eat = 0;
//			int time = 0;
//			
//			while(true) {
//				LinkedList<Shark> s = new LinkedList<>();
//				int[][] dist = new int[N][N]; // 거리
//				
//				while(q.size() > 0) {
//					Shark sh = q.poll();
//					
//					for(int i = 0; i < 4; i++) {
//						int nr = sh.r + dr[i];
//						int nc = sh.c + dc[i];
//						
//						// 범위 안이고 지나가거나 먹을수있는 경우
//						if(nr >= 0 && nr < N && nc >= 0 && nc < N && dist[nr][nc] == 0 && map[nr][nc] <= size) {
//							dist[nr][nc] = dist[sh.r][sh.c] + 1;
////							System.out.println(dist[nr][nc]);
//							
//							// 먹이감 밢견
//							if(map[nr][nc] >= 1 && map[nr][nc] <= 6 && map[nr][nc] < size) {
//								// 물고기이고 자기 사이즈보다 작을떄
//								s.add(new Shark(nr, nc, dist[nr][nc]));
//								q.add(new Shark(nr, nc, dist[nr][nc]));
//								continue;
//							}
//							
//							// 먹이는 없지만 지나갈수는 있음
//							q.add(new Shark(nr, nc, dist[nr][nc]));
//						}
//					}
//					
//				}
//				
//				// 더이상 먹을게 없는경우
//				if(s.size() == 0) {
//					System.out.println(time);
//					return;
//				}
//				
//				Shark eatFish = s.get(0);
//				for(int i = 1; i < s.size(); i++) {
//					if(eatFish.dist > s.get(i).dist) {
//						eatFish = s.get(i);
//					}
//					
//					if(eatFish.dist == s.get(i).dist) {
//						if(eatFish.r > s.get(i).r) {
//							eatFish = s.get(i);
//							continue;
//						} else if(eatFish.r == s.get(i).r) {
//							if(eatFish.c > s.get(i).c);
//							eatFish = s.get(i);
//						}
//					}
//					
//				}
//				
//				time += eatFish.dist;
//				eat++;
//				
//				map[eatFish.r][eatFish.c] = 0;
//				if(eat == size) {
//					size++;
//					eat = 0;
//				}
//				
//				q.add(new Shark(eatFish.r, eatFish.c, size));
//				
//				
//			}
//			
//			
//			
//			// 확인
////			System.out.println(N);
////			for(int i = 0; i < N; i++) {
////				System.out.println(Arrays.toString(map[i]));
////			}
//			
//			
//			
//			
//			
//		} // end of main
//		
//		static int[] dr = {1,-1,0,0};
//		static int[] dc = {0,0,1,-1};
//		
//		static class Shark {
//			int r, c, dist; 
//
//			Shark(int r, int c, int dist) {
//				this.r = r;
//				this.c = c;
//				this.dist = dist;
//			}
//		} // end of Fish
//		
//	} // end of class

	
}
