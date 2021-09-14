package 인프런;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기1BFS {
	
	static int ans = 0;
	static int[] ch = new int[10001];
	static int[] dis = {1, -1, 5};
	
	static Queue<Integer> q = new LinkedList<>();
	
	
	public static int bfs(int s, int e) {
		
		ch[s] = 1;
		q.offer(s);
		int L = 1;
		
		while(!q.isEmpty()) {
			int len = q.size();
			
			for(int i = 0; i < len; i++) {
				int x = q.poll();
				for(int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					if(nx == e) return L;
					if(nx >= 1 && nx <= 10000 && ch[nx] ==0) {
						ch[nx] = 1;
						q.offer(nx);
					}
				}
			}
			L++;
		}
	
		
		
		return L;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(bfs(s, e));
	}
}
