package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1037_오류교정_김한주 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 행의합, 열의합 구하기
		// 행렬의 정보를 읽어 이것이 패리티 성질을 가지고있는지 없는지 판단하기
		// 그렇지 않다면 하나의 비트를 바꿔서 이 행렬이 패리티 성질을 가질 수 있는가 확인하고 그렇지 않을 경우 행렬은 잘못된 행렬이라고 판단

		int[][] map = new int[N][N];
		int r = 0;
		int check = 0; // 짝수인지 확인용
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
			if (sum % 2 != 0) {
				r = i;
				check += 1;

			}
		}

		if (check > 1) {
			System.out.println("Corrupt");
			return;
		} else {
			check = 0;
			int c = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[j][i];
				}
				if (sum % 2 != 0) {
					c = i;
					check += 1;
				}
			}
			if (check > 1) {
				System.out.println("Corrupt");
				return;
			} else if (check == 1) {
				System.out.println("Change bit (" + (r + 1) + "," + (1 + c) + ")");
			} else
				System.out.println("OK");
		}

//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		} // 확인

	} // end of main
} // end of class
