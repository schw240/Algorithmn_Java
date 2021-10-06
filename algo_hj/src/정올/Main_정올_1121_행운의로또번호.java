package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1121_행운의로또번호 {

	static int N, M; // M개 숫자, N개 선택
	static int ans;
	static int[][] dp;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		// 1~M까지의 숫자 중 N개를 골라서 이 숫자를 맞추면 상금을 타는 복권

		// 로또 번호를 오름차순으로 정렬했을 때 그 숫자가 앞의 수보다 2배이상 큰 숫자
		// 만족하는 개수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) { // 둘다 0이면 프로그램 종료
				System.exit(0);
			}

			numbers = new int[N];
			dp = new int[M][M];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			
			
//			ans = 0;

			// 숫자N개를 중복되지 않게 뽑고 (조합) 정렬하기
			// 정렬한 다음 숫자 비교하면서 만약 어떤 숫자가 앞의 숫자보다 2배이상 증가했다면 카운팅

//			System.out.println(dfs_dp(0, 1));
//			dfs(0,1);
//			System.out.println(ans);

		}

	} // end of main

	private static void dfs(int cnt, int start) {
		if (cnt == N) {
			// 여기서 숫자 확인하고 개수 카운팅
//			ans++;
			System.out.println(Arrays.toString(numbers));

			boolean flag = true;
			// 여기서 번호 확인해서 카운팅하기
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (numbers[j] < numbers[i] * 2) {
						flag = false;
					}
				}
				if (!flag)
					break;
			}

			if (flag)
				ans++;
			return;
		}
//		System.out.println(cnt + " " + start + " " + N);
		for (int i = start; i <= M; i++) {
			numbers[cnt] = i;
			dfs(cnt + 1, i * 2);

		}
	}

} // end of class
