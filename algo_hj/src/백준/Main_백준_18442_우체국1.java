package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18442_우체국1 {

	
	static int V,L, P;
	static int[] homes, polices, result, answer;
	static int ans = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		homes = new int[V];
		polices = new int[P];
		result = new int[P];
		answer = new int[P];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < V; i++) {
			homes[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
		for(int i = 0; i < P; i++) {
			System.out.print(answer[i] + " ");
		}
		
		
		
	} // end of main

	private static void dfs(int cnt, int start) {
		// TODO Auto-generated method stub
		
		// 숫자중에서 P개만큼 뽑은다음 마을과 마을사이의 거리를 구함
		
		if(cnt == P) {
			// P개만큼 뽑았으면 거리체크해서 갱신하기
			getDist();
			return;
		}
		
		for(int i = start; i < V; i++) {
			result[cnt] = homes[i];
			dfs(cnt+1, i + 1);
		}
		
	}
	
	private static void getDist() {
		
		int sum = 0;
		for(int v = 0; v < V; v++) {
			int min = Integer.MAX_VALUE;
			for(int p = 0; p < P; p++) {
				int diff = Math.min(Math.abs(homes[v] - result[p]), Math.min(homes[v], result[p]) + L - Math.max(homes[v], result[p]));
				if(min > diff) {
					min = diff;
				}
			}
			
			sum += min;
		}
		
		if(sum < ans) {
			ans = sum;
			answer = result.clone();
		}
	}
} // end of class
