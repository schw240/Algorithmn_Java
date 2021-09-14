package 인프런;

import java.util.Scanner;

public class 경로탐색dfs {
	static int answer = 0;
	static int[][] graph;
	static int[] ch;
	private static int n;
	private static int m;
	
	public void dfs(int v) {
		if(v == n) answer++;
		else {
			for(int i = 1; i <= n; i++) {
				if(graph[v][i] == 1 && ch[i] == 0) {
					ch[i] = 1;
					dfs(i);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		경로탐색dfs T = new 경로탐색dfs();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n+1][n+1];
		ch = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		ch[1] = 1;
		T.dfs(1);
		System.out.println(answer);
		
	}
}
