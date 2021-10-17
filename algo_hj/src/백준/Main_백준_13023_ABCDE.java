package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_13023_ABCDE {
	
	
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int ans = 0;
	private static boolean flag;
	 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		

		for(int i = 0; i < N; i++) {
			// 각 연결리스트 정점 숞회
			visited = new boolean[N];
			dfs(0, i);
		}
		
		System.out.println(0);
		
		
		
	} // end of main
	
	
	private static void dfs(int cnt, int start) {
		if(cnt == 4) {
			
			System.out.println(1);
			System.exit(0);
		}
		
		visited[start] = true;
		for(int i = 0; i < list[start].size(); i++) {
			int tmp = list[start].get(i);
			if(!visited[tmp]) {
				visited[tmp] = true;
				dfs(cnt + 1, tmp);
				visited[tmp] = false;
			}
		}
		
		
	} // end of dfs
	
} // end of class


//5 4
//0 1
//1 2
//2 3
//3 4