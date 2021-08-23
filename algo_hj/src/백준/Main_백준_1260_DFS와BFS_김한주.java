package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1260_DFS와BFS_김한주 {
	
	static int N, M, V;
	static boolean[][] adjMatrix; // 인접행렬
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
		
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			System.out.println("from: " + from + " to: " + to);
			adjMatrix[to][from] = adjMatrix[from][to] = true; // 서로 연결시켜주기 
		}
		
		boolean[] visited = new boolean[N+1];
		dfs(V, visited);
		System.out.println();
		bfs(V);
		
		// dfs로 탐색한 결과와 bfs로 탐색한 결과를 출력하는 프로그램 작성하기
		
		
		
		
		
	} // end of main
	
	public static void dfs(int cur, boolean[] visited) {
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for(int i = 0; i < N+1; i++) {
			if(!visited[i] && adjMatrix[cur][i]) { // 방문하지 않았고 연결되어있다면
				dfs(i, visited);
			}
		}
		
	} // end of dfs
	
	
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i = 0; i < N+1; i++) {
				if(!visited[i] && adjMatrix[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	} // end of bfs
	
} // end of class
