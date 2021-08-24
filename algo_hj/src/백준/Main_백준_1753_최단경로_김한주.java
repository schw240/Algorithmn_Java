package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_김한주 {
	
    static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];
    
	public static void main(String[] args) throws Exception {
		
		// 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하기
		
		// 정점의 개수 V, 간선의 개수 E
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 시작 정점의 번호 K
		int K = Integer.parseInt(br.readLine());
		
        visit = new boolean[V+1]; //방문 여부 
        list = new LinkedList[V+1]; // 
        distance = new int[V+1]; // 거리 배열
        Arrays.fill(distance, -1);
        
        
        for(int i = 1; i <= V; i++) {
            list[i] = new LinkedList<>();
        }
		
		for(int i = 0; i < E; i++) {
			// 각 간선을 나타내는 세개의 정수(u,v,w) u에서 v로 가는 가중치 w인 간선
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
            list[u].add(new Node(v, w));
			// 첫째줄부터 V개의 줄에 걸쳐 i번째 줄에 i번 정점으로의 최단 경로의 경로값 출력하기
			// 시작점 자신은 0으로 출력하고 경로가 존재하지 않는 경우에는 INF를 출력
		}
		
		dijkstra(K);
		StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
        	if(distance[i] == -1) {
        		System.out.println("INF");
        	} else {
        		System.out.println(distance[i]);
        	}
        }
		
	} // end of main
	
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));  // 우선 순위의 가중치에 시작 정점을 삽입
        distance[start] = 0; // 시작점의 거리 = 0
        
        while(!pq.isEmpty()) { 
            Node now = pq.poll(); // 정점을 꺼냄
            if(!visit[now.number]) {  // 정점을 방문하지 않았으면 
                visit[now.number] = true; // 방문처리
                for(Node next : list[now.number]) { 
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) { //이어져있고 현재 값보다 작으면
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int number, weight;
        
        Node(int n, int w) {
            this.number = n; // 정점의 번호
            this.weight = w; // 가중치
        }
        
        public int compareTo(Node n) { // 가중치의 오름차순
            return weight - n.weight;
        }
    }
} // end of class
