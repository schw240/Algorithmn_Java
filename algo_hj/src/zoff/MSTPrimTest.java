package zoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		StringTokenizer st = null;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			
			minEdge[1] = Integer.MAX_VALUE;
		}
		
		int res = 0; // 최소신장트리 비용
		minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅
		
		for(int i = 0; i < N; i++) {
			// 1. 신장트리에 포함되지 않은 정점 중 최소 간선비용의 정점 찾기
			
		}
		
		
		
	} // end of main
	
} // end of class
