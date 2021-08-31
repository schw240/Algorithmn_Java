package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대매출 {
public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 일동안의 매출기록 K일동안의 최대 매출액구하기
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 0; i < N-K + 1; i++) {
			int sum = 0;
			for(int k = i; k < K+i; k++) {
				sum += nums[k];
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
