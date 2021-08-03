package SWEA.D1;


import java.util.Arrays;
import java.util.Scanner;

public class Solution2063 {
	public static void main(String[] args) {

//		중간 값 출력
//		[입력]
//
//		입력은 첫 줄에 N 이 주어진다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] nums = new int[N];
//		둘째 줄에 N 개의 점수가 주어진다.
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		
//		[출력]
//		N 개의 점수들 중, 중간값에 해당하는 점수를 정답으로 출력한다.
		int mid = N / 2;
		
		Arrays.sort(nums);
		System.out.println(nums[mid]);
		
		
		
	} // end of main
} // end of class
