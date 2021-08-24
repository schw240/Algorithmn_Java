package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str= "";
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N개의 집합
			int M = Integer.parseInt(st.nextToken()); // M개의 연산
			
			
			int[] arr = new int[N+1];
			for(int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				// 합집함은 0 a b - a가 포함되어있는 집합과 b가 포함되어있는 집합을 합친다는 의미
				// 같은 집합에 포함되어있는지 확인하는 연산 1 a b
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(x == 1) {
					// 같은 집합인지 확인
					if(find(arr, a, b)) str += "1";
					else str += "0";
				} else {
					// 0 합집합 연산
					union(arr, a, b);
				}
				
			}
			
			
			// 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속해서 출력하기
			
			
			System.out.println("#" + tc + " " + str);
		} // end of tc
		
		
		
		
	} // end of main
	
	
	public static int findSet(int[] p, int x) {
		if(x == p[x]) return x;
		else return p[x] = findSet(p, p[x]); 
	} // end of findSet
	
	public static void union(int[] p, int x, int y) {
		x = findSet(p, x);
		y = findSet(p, y);
		
		if(x > y) p[x] = y;
		else p[y] = x;
	}
	
	public static boolean find(int[] p, int x, int y) {
		return (findSet(p, x) == findSet(p, y));
	}
	
} // end of class
