package SWEA.D1;


import java.util.Scanner;

public class Solution2070 {
	public static void main(String[] args) {
		// 2개의 수를 입력받아 크기를 비교하여 등호 또는 부등호 출력
		
		// 입력
		// 가장 첫 줄에 T 테스트케이스 입력
		// T만큼 테스트케이스 주어짐(2개 수)
		
		// 출력
		// #t(1부터) 정답
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if (num1 == num2) {
				System.out.printf("#%d %s\n", tc, '=');
			} else {
				char ch = num1 > num2 ? '>' : '<';
				System.out.printf("#%d %s\n", tc, ch);
			}
		}
				 
		
	} //end of main
} // end of class
