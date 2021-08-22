package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N번째소수구하기_김한주 {

	public static int[] solution(int N) {

		int[] arr = new int[N+1];
		int[] sosu = new int[N+1];
		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0) {
				sosu[i] = i;
				for (int j = i; j <= N; j += i) {
					arr[j] = 1;
				}
			}
		}
		
//		System.out.println(Arrays.toString(sosu));
		
		int[] ans = new int[N];
		int j = 0;
		
		for(int i = 0; i < sosu.length; i++) {
			if(sosu[i] != 0) {
				ans[j++] = sosu[i];
			}
		}
		
//		System.out.println(Arrays.toString(ans));
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// n번째 소수 구하기
		int ans[] = solution(10000);
		
		System.out.println(ans[N-1]);
	}
}
