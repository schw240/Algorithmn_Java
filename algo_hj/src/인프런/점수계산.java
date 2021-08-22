package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수계산 {
	
	public static void solution(int N, int[] nums) {
		int ans = 0;
		int bonus = 0;
		for(int i = 0; i < N; i++) {
			if(nums[i] == 0) {
				bonus = 0;
			} else {
				bonus++;
				ans += bonus;
			}
		}
		
		
		System.out.println(ans);
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
} // end of class
