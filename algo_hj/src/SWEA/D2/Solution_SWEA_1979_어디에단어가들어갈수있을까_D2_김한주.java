package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1979_어디에단어가들어갈수있을까_D2_김한주 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// N X N 크기의 단어 퍼즐을 만들려고 할 때
			// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken()); // 퍼즐 길이
			int K = Integer.parseInt(st.nextToken()); // 단어의 길이

			int[][] nums = new int[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료

//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(nums[i][j] + " ");
//				}
//				System.out.println();
//			} // 확인용

			int ans = 0;

			// 행확인
			for (int i = 0; i < N; i++) {
				out: for (int j = 0; j <= N-K; j++) {
					if (j != 0 && nums[i][j - 1] == 1)
						continue;
					if (j + K != N && nums[i][j + K] == 1)
						continue;
					for (int l = 0; l < K; l++) {
						if (nums[i][j + l] == 0)
							continue out;
					}

					ans++;
				}
			}

			// 열확인
			for (int i = 0; i < N; i++) {
				out: for (int j = 0; j <= N-K; j++) {
					if (j != 0 && nums[j-1][i] == 1)
						continue;
					if (j + K != N && nums[j+K][i] == 1)
						continue;
					for (int l = 0; l < K; l++) {
						if (nums[j+l][i] == 0)
							continue out;
					}
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);

		} // end of tc

	} // end of main
} // end of class
