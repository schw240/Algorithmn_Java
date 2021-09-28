package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {
	
	
	static int N, ans;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		// Si,j 는  i번 사람과 j번 사람이 같은 팀에 속했을 때 팀에 더해지는 능력치
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인
		
		ans = Integer.MAX_VALUE;
		
		// N명이 모이고 N/2 명씩 나누어서 축구 팀 정하기
		dfs(0,0);
		
		// 스타트팀과 링크팀의 능력치의 차이의 최소값 출력하기
		
		
		
		System.out.println(ans);
	} // end of main
	
	public static void dfs(int idx, int cnt) {
		if(cnt == N / 2) {
			// 다 뽑았으므로 능력치 체크하기
			int start = 0;
			int link = 0;
			
//			System.out.println(Arrays.toString(visited));
			
			for(int i = 0; i < N; i++) {
				// S(i,j) i번 사람과 j 번 사람이 같은 팀에 속했을 때 더해지는 능력치
				// 모든 쌍의 능력치는 S(i,j)의 합이다. 
				
				// 1,2    3,4팀이면
				// S(1,2) + S(2,1) ,     S(3,4) + S(4,3)
				for(int j = i+1; j < N; j++) {
					if(visited[i] == true && visited[j] == true) {
						start += map[i][j];
						start += map[j][i];
					} else if(visited[i] == false && visited[j] == false){
						link += map[i][j];
						link += map[j][i];
					}
				}
			}
			
			
			
			// 값 차이 구하기
			int tmp = Math.abs(start - link);
			
//			System.out.println(tmp);
			
			// 만약 0이면 최소값이므로 잘나눈거니까 바로 종료시키기
			if(tmp == 0) {
				System.out.println(tmp);
				System.exit(0);
			}
			
//			System.out.println(tmp);
			ans = Math.min(tmp, ans);
			
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
} // end of class
