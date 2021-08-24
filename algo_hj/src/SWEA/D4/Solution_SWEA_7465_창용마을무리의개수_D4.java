package SWEA.D4;

import java.util.Scanner;

public class Solution_SWEA_7465_창용마을무리의개수_D4 {
	
	static int[] parent;
	
	public static void main(String[] args) {
		
		// 마을에 몇개의 무리가 존재하는지?
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 마을에 사는 사람 수, 서로를 알고있는 사람 수
			int N = sc.nextInt();
			int M = sc.nextInt();
			parent = new int[N+1];
			boolean[] ans = new boolean[N+1]; 
			for(int i=1; i<N+1; i++) 
				parent[i] = i;
			for(int i=0; i<M; i++) {
				// 서로를 알고있는 사람의 번호
				int A = sc.nextInt();
				int B = sc.nextInt();
				if ( find(A) != find(B) ) {
					union(A,B);
				}
			}
			int cnt = 0;
			for(int i=1; i<N+1; i++) {
				int A = find(i);
				if ( !ans[A] ) { 
					cnt++;
				}
				ans[A] = true;
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	} // end of main
	
	static int find(int n) {
		if ( n == parent[n] ) {
			return n;
		} else {
			return parent[n] = find(parent[n]);
		}
	} // end of find
	
	static void union(int n1,int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if ( p1 != p2 ) { 
			parent[p2] = p1; 
		}
	} // end of union
	
} // end of class