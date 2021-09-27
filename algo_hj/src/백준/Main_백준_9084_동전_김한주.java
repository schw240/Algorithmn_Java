package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_9084_동전_김한주 {
	
	static int T, N, M, ans;
	static int[] coins, dp;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1,5,10,50,100,500원
		// 동전의 종류가 주어질 때 주어진 금액을 만드는 모든 방법을 세는 프로그램 작성하기
		
		T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 동전 가즤의 수
			coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			} // 입력 완료
			
			M = Integer.parseInt(br.readLine());
			
			
			// 입력 확인
//			System.out.println(T);
//			System.out.println(N);
//			System.out.println(Arrays.toString(coins));
//			System.out.println(M);
			
			
			
			// 각 테스트 케이스에 대해 입력으로 주어지는 N가지 동전으로 금액 M을 만드는 모든 방법의 수를 한줄에 출력하시오
			ans = 0;
			dp = new int[M+1];
			
			
			// 10원을 2,3,4원으로 만든다고할때 만들수 있으면 누적한다는 개념으로??
			// 2원 
			// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
			// 0  1  0  1  0  1  0  1  0  1
			// 3원도 있다면
			// 0  1  1  1  1  2  1  2  2  2
			
			
			dp[0] = 1;
			for(int i = 0; i < N; i++) { // 2,3,4
 				for(int j = coins[i]; j <= M; j++) { // 2 ~ M
					dp[j] += dp[j - coins[i]]; // 누적시키면서 가야하므로
				}
			}
			
			System.out.println(dp[M]);
		} // end of tc
		
		
	} // end of main
	
	
	
} // end of class
