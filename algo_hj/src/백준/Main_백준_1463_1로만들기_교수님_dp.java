package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1463_1로만들기_교수님_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int[] memo = new int[X+1];
		memo[1] = 0;
		
		for(int i = 2; i <= X; i++) {
			memo[i] = memo[i-1] + 1; // 이전꺼보다 연산 한번 더 했단 의미로 1 더해줌, -1 연산
			if(i % 2 == 0) {
				memo[i] = Math.min(memo[i/2] + 1, memo[i]);
			}
			if(i % 3 == 0) {
				memo[i] = Math.min(memo[i/3] + 1, memo[i]);
			}
		}
		
		System.out.println(memo[X]);
		
	} // end of main
	
} // end of class
