package zoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {
	
	static int N; // 정점의 개수
	static Node[] adjList; // 인접리스트(가중치X)
	
	static class Node {
		
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		int C = Integer.parseInt(br.readLine()); // 간선개수
		
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
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
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					// 아직 방문하지 않았고 현재 정점에서 방문할 수 있다면(인접정점)
					q.offer(temp.vertex); // 큐에 넣고 순서를 기다리고
					visited[temp.vertex] = true; // 방문했다고 처리함
				}
				
			}
		}
		
	} // end of bfs
	
	
	private static void dfs(int cur, boolean[] visited) {
		
		System.out.println((char)(cur + 65));
		
		for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				visited[temp.vertex] = true;
				dfs(temp.vertex, visited);
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
