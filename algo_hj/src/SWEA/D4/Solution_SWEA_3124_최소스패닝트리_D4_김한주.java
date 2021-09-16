package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_최소스패닝트리_D4_김한주 {

	static int N, E; // 정점 수, 간선 수
	static int[] parent; // disjoint-set에서 각 정점의 부모(대표자) 정보 저장하는 배열
	static boolean[] visit; // 선택한 정점 재방문 안할 때 쓰는 배열
	static ArrayList<Edge> mst;
	static PriorityQueue<Edge> pq;
	private static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			visit = new boolean[N + 1];
			parent = new int[N + 1];
			pq = new PriorityQueue<>(new EdgeComparator());
			mst = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new Edge(a, b, c));// 간선들을 가중치로 정렬하는 우선순위 큐에 다 집어넣기.
			}

			kruskal();
			long sum = 0;
			for (int i = 0; i < mst.size(); i++) {
				sum += mst.get(i).value;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

	static void kruskal() {
		for (int i = 1; i <= N; i++) { // 일단 모든 정점들은 각각 다 대표로 만들어진다
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			Edge edge = pq.poll(); // 가중치 작은 순서대로 간선이 나옴
			if (find(edge.start) == find(edge.end)) { // 간선의 대표자가 같으면 사이클이 생기므로 스킵.
				continue;
			}
			union(edge.start, edge.end); // 사이클이 안생기는 간선의 양 접점을 하나로 합병
			mst.add(edge);// 선택된 간선을 mst에 추가
		}

	}

	// 특정 원소가 포함된 집합의 대표자 찾기 메소드
	static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]); // find가 실행되는 시점의 소속집합 전체의 대표자를 부모로 기억시켜서 효율성 증가.
		return parent[n];
	}

	// n1과 n2가 소속된 두 집합을 합병하는 메소드
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 != p2) { // 두 집합의 대표자가 다른 경우 합병 진행
			parent[p1] = p2;
		}
	}

	// 우선순위 큐가 간선들을 가중치 순으로 줄세울 수 있게 해주는 비교기능 내장 클래스
	static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1;
		}

	}

	// 하나의 간선정보를 하나의 객체에 묶기 위한 내부 클래스.
	static class Edge {
		int start, end, value;

		Edge(int s, int e, int v) {
			start = s;
			end = e;
			value = v;
		}
	} // end of main
} // end of class
