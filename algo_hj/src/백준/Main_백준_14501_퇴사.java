package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14501_퇴사 {
	
	static int N;
	static int[] T, P;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// N + 1일날에 퇴사
		// 상담했을때 걸리는 기간 T
		// 받을 수 있는 금액 P
		T = new int[N];
		P = new int[N];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
		} // 입력완료
		
		dfs(0, 0);
		
		
		System.out.println(ans);
		
	} // end of main
	
	private static void dfs(int cnt, int num) {
		if(cnt >= N) {
			ans = Math.max(ans, num);
			return;
		}
		
		// 해당 인덱스 포함
		if(cnt + T[cnt] <= N) {
			dfs(cnt + T[cnt], num + P[cnt]);
		} else {
			dfs(cnt + T[cnt], num); // N을 넘어가면 num 합치지 않음
		}
		
		dfs(cnt + 1, num); // 해당 인덱스 미포함
		
		
	}
	
} // end of class
