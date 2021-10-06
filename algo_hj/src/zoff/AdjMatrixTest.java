package zoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	
	static int N; // 정점의 개수
	static boolean[][] adjMatrix; // 인접행렬(가중치X)
	
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(br.readLine()); // 간선개수
		
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] =  true;
		}
		
		System.out.println("=================bfs=====================");
		bfs();
		System.out.println("=================dfs=====================");
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(0, visited);
		
	}
	
	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		q.offer(0);
		visited[0] = true;
		
		while(q.size() > 0) {
			int cur = q.poll();
			System.out.println((char)(cur + 65));
			
			for(int i = 0; i < N; i++) { // 모든 정점을 들여다보고
				if(!visited[i] && adjMatrix[cur][i]) {
					// 아직 방문하지 않았고 현재 정점에서 방문할 수 있다면(인접정점)
					q.offer(i); // 큐에 넣고 순서를 기다리고
					visited[i] = true; // 방문했다고 처리함
				}
				
			}
		}
		
	} // end of bfs
	
	
	private static void dfs(int cur, boolean[] visited) {
		
		System.out.println((char)(cur + 65));
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[cur][i]) {
				visited[i] = true;
				dfs(i, visited);
			}
		}
		
	}
	
}



//7
//8
//0 1
//0 2
//1 3
//1 4
//2 4
//3 5
//4 5
//5 6
