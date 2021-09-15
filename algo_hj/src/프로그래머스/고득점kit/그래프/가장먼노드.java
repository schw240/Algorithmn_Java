package 프로그래머스.고득점kit.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

	public static int solution(int n, int[][] edge) {
		// n개의 노드가 있는 그래프
		// 1번 노드에서 가장 멀리 떨어진 노드의 개수 구하기
		// 가장 멀리 떨어진 노드란 최단 경로로 이동했을 때 간선의 개수가 가장 많은 노드 의미

		// 그래프 각 배열 리스트로 만들기
		int answer = 0;
		// 그래프 구현
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < edge.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		// 노드 연결
		int a, b;
		for (int[] node : edge) {
			a = node[0];
			b = node[1];
			list.get(a).add(b);
			list.get(b).add(a);
//            System.out.println(list);
		}

		int[] count = new int[n + 1]; // 1과의 거리 저장할 배열
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);// 시작점
		
		visited[0] = true; // 0은 사용 X 1부터 시작
		visited[1] = true; 
		
		int cur;
		
		while (!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur + " cur");
			for (int v : list.get(cur)) { // 현재 연결된 노드들 방문하지 않았다면
//				System.out.println(v + " v");
				if (!visited[v]) {
					count[v] = count[cur] + 1; // 1과의 길이 저장
					visited[v] = true;
					q.add(v);
				}
			}
		}

		int max = 0; // 1과 가장 멀리 떨어진 노드와의 길이 저장
		for (int cnt : count) {
			if (max < cnt) { // 더 큰 길이가 있다면 그게 max
				max = cnt;
				answer = 1;
			} else if (max == cnt)
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.println(solution(n, vertex));

	}
}
