package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰수출력하기 {
	
	public static void solution(int N, int[] nums) {
		// 첫번째 수는 무조건 출력
		System.out.print(nums[0] + " ");
		for(int i = 1; i < N; i++) {
			if(nums[i] > nums[i-1]) System.out.print(nums[i] + " ");
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		solution(N, nums);

	} // end of main
}
