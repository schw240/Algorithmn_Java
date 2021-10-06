package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1197_최소스패닝트리 {
	
	
	static int V, E; // 정점의 개수, 간선의 개수
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	
	static class Node implements Comparable<Node> {
		int to;
		int value;
		
		public Node(int to, int value) {
			super();
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.value, o.value);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 인접리스트 생성 V + 1개
		list = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, value));
			list[to].add(new Node(from, value));
		}
		
		int ans = prim();
		System.out.println(ans);
		
	} // end of main
	
	
	private static int prim() {
		int res = 0;
		visited = new boolean[V+1];
		pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));
		
		int cnt = 0;
		while(pq.size() > 0) {
			Node cur = pq.poll();
			
			// 방문한 경우
			if(visited[cur.to]) {
				continue;
			}
			
			res += cur.value;
			visited[cur.to] = true;
			cnt += 1;
			
			
			if(cnt == V) return res; // 모든 노드를 방문했다면 
			
			for(int i = 0; i < list[cur.to].size(); i++) {
				Node next = list[cur.to].get(i);
				if(visited[next.to]) continue; // 방문한 곳이라면 
				
				pq.add(next);
			}
		}
		
		return res;
	}
	
} // end of class
