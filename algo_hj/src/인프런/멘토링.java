package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멘토링 {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int cnt = 0;
				for(int k = 0; k < M; k++) {
					int pi = 0, pj = 0;
					for(int s = 0; s < N; s++) {
						if(map[k][s] == i) pi =s;
						if(map[k][s] == j) pj = s;
					}
					if(pi < pj) cnt++;
				}
				if(cnt == M) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
