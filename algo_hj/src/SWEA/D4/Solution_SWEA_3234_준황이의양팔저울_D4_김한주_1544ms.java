package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준황이의양팔저울_D4_김한주_1544ms {
	private static int cnt;

	public static void solution(int idx, int left, int right, int[] weights, boolean[] check) {
		
		if(idx == weights.length) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < weights.length; i++) {
			if(check[i]) continue;
			
			// 체크되지 않았다면
			check[i] = true;
			// 왼쪽에 놓고 확인
			System.out.println("i번째: " + i);
			System.out.println(idx + " "  + left + " " +  right);
			System.out.println(Arrays.toString(weights));
			System.out.println(Arrays.toString(check));
			solution(idx + 1, left + weights[i], right, weights, check); 
			if(right + weights[i] <= left) {
				solution(idx + 1, left, right + weights[i], weights, check);
			}
			
			check[i] = false;
			
		}
		
	} // end of solution


	public static void main(String[] args) throws Exception {

//		[입력]
//		첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//		각 테스트 케이스마다 첫 번째 줄에 N(1 ≤ N ≤ 9)가 주어진다.
//		두 번째 줄에는 각 무게추의 무게를 의미하는 N개의 자연수가 공백으로 구분되어 주어진다. 무게는 1이상 999이하이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 무게 추 개수

			int[] weights = new int[N]; // 무게 추
			boolean[] check = new boolean[N]; // 체크용 boolean 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
//				total += weights[i];
			} // 입력 완료

			// 하지만 양팔 저울에 갑자기 문제가 생겨서 무게 추를 올릴 때
			// 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
			// 준환이가 양팔 저울에 모든 무게추를 올리는 방법은 총 몇가지가 있을 까?
			cnt = 0;
			solution(0, 0, 0, weights, check);

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		} // end of tc

//		[출력]
//		각 테스트 케이스마다 무게추를 올리는 과정에서 오른쪽 위에 올라가있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않는 경우의 수를 출력한다.

		System.out.println(sb);
	} // end of main
} // end of class

