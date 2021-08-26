package 프로그래머스.고득점kit.그리디;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
	
	static int[] parent;
	
	static int find(int n) {
		if ( n == parent[n] ) {
			return n;
		} else {
			return parent[n] = find(parent[n]);
		}
	} // end of find
	
	public static int solution(int n, int[][] costs) {
		int ans = 0;
		
		// n개의 섬 사이에 다리를 건설하는 비용(costs)가 주어질 때
		// 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용 return
		// 다리를 여러번 건너더라도 도달할 수 만 있다면 통행 가능함
		
		// costs에서 0,1에는 다리가 연결되는 두 섬의 번호,  2에는 두 섬을 연결하는 다리를 건설하는데 드는 비용
		
		Arrays.sort(costs, new Comparator<int[]>()  {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				// 가중치 기준으로 오름차순
				// Integer로 해주어야 compareTo 가능
				Integer a = o1[2];
				Integer b = o2[2];
				return a.compareTo(b);
			}
		});
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < costs.length; i++) {
			int from = find(costs[i][0]);
			int to = find(costs[i][1]);
			if(from != to) { // 둘의 부모가 다르면 둘을 연결시켜줌 부모가 달라야 최소 비용으로 통과할 수 있음
				parent[to] = from;
				ans += costs[i][2];
			}
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int ans = solution(n, costs);
		System.out.println(ans);
		
		
		
	} // end of main
} // end of class
