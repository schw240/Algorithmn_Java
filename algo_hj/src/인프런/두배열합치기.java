package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두배열합치기 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 배열의 크기
		
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // 배열의 크기 M
		
		int[] nums2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			nums2[i] = Integer.parseInt(st.nextToken());
		}
		
		// 받은 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하기
		int[] ans = new int[N+M];
		int idx = 0;
		int i = 0; // nums 인덱스
		int j = 0; // nums2 인덱스
		
		while(i < N && j < M) {
			if(nums[i] < nums2[j]) ans[idx++] = nums[i++];
			else ans[idx++] = nums2[j++];
		}
		while(i < N) ans[idx++] = nums[i++];
		while(j < M) ans[idx++] = nums2[j++];
		
		for(int k = 0; k < ans.length; k++) {
			System.out.print(ans[k] + " ");
		}
		
	} // end of main
} // end of class
