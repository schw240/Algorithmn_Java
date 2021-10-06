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
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		
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
			flag = false;
			dfs(i, 0);
			
			if(flag) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
		
		
		
		
		
		
	} // end of main
	
	
	private static void dfs(int cnt, int start) {
		
		if(cnt == 5) {
			flag = true;
		} else {
			for(int i = 0; i < list[start].size(); i++) {
				if(!visited[list[start].get(i)]) {
					visited[start] = true;
					dfs(cnt + 1, list[start].get(i));
					if(flag) return;
					visited[start] = false;
				}
			}
		}
		
	} // end of dfs
	
} // end of class
