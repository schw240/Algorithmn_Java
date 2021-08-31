package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공통원소구하기 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums1[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] nums2 = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int[] ans = new int[N+M];
		int i1 = 0;
		int i2 = 0;
		int idx = 0;
		while(i1 < N && i2 < M) {
			if(nums1[i1] == nums2[i2]) {
				ans[idx++] = nums1[i1];
				i1++;
				i2++;
			} else if(nums1[i1] < nums2[i2]) {
				i1++;
			} else if(nums1[i1] > nums2[i2]) {
				i2++;
			}
			
		}
		
		for(int i = 0; i <ans.length; i++) {
			if(ans[i] > 0) {
				System.out.print(ans[i] + " ");
			}
		}
		
	}
}
