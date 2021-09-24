package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로 {
	
	static int N; // 배달해야하는 장소의 수
	static int[][] map; // NXN 크기의 장소와 장소를 이동하는 비용이 공백으로 구분하여 주어짐 , 비용은 양방향이 아닌 단방향으로 가기 위한 비용
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE; // 최소값 정답
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		// 배달해야하는 장소를 한번씩만 방문해서 물건을 모두 배달하고 다시 회사로 돌아와야한다.
		// 배달하는 장소에만 도착할 수 있다면 물건은 모두 배달할 수 있고 크기나 개수는 고려X
		
		// 방문 순서를 정해야한다. 
		// 모든 물건을 배달하고 회사로 돌아오기 위한 최소의 비용을 계산하는 프로그램 작성하기
		
		
		// 순서에 따라서 모든곳을 들려보기 -> DFS 순열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		// 확인
//		System.out.println(N);
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		dfs(0,0,0);
		sb.append(answer + "\n");
		bw.write(sb.toString());
		bw.close();
		
	} // end of main


	// 회사에서 출발하여 오늘 배달해야하는 모든 장소를 들르므로
	// 0은 회사임 그 다음부터 처리

	private static void dfs(int start, int idx, int cost) {
		// TODO Auto-generated method stub
		
		// 중간 비용이 정답보다 크면 return
		if (cost >= answer) {
			return;
		}
		
		if(idx == N-1) { // 다 고른경우
			if(map[start][0] != 0) {
				answer = Math.min(answer, cost + map[start][0]);
			}
			
			return;
		}
		
		for(int i = 1; i < N; i++) { // 0은 회사이므로 1부터
			if(map[start][i] != 0 && visited[i] == false) {
				visited[i] = true;
				dfs(i, idx + 1, map[start][i] + cost);
				visited[i] = false;
			}
		}
		
		
		
	}
	
	
	
	
	
} // end of class


/* 
 * 
5
0 14 4 10 20 
14 0 7 8 7 
4 5 0 7 16 
11 7 9 0 2 
18 7 17 4 0
 * 
 * */
 