package SWEA.D1;


import java.util.Scanner;

public class Solution2068 {
	public static void main(String[] args) {
		// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력
		
		Scanner sc = new Scanner(System.in);

//	[입력]	
//	
//	가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
//	
//	각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int[] nums = new int[10];
			
			for(int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}
		//	[출력]
		//	출력의 각 줄은 '#T'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		//	(T는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
			
			int max = 0;
			
			for(int i = 0; i < 10; i++) {
				if (nums[i] > max) {
					max = nums[i];
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
			
			
		} // end of 입력
	
		
		
		
	} // end of main
} // end of class
