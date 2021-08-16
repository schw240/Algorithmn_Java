package 인프런;

import java.util.Scanner;


public class 피보나치수열 {
	
	
	public static void fibo(int N) {

//		int[] answer = new int[N];
//		answer[0] = 1;
//		answer[1] = 1;
//		
//				
//		for(int i = 2; i < N; i++) {
//			answer[i] = answer[i-1] + answer[i-2];
//		}
//		
//		return answer;
		int a = 1, b = 1, c;
		System.out.print(a + " " + b + ' ');
		for(int i = 2; i < N; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int[] answer = fibo(N);
//		for(int i = 0; i < N; i++) {
//			System.out.print(answer[i] + " ");
//		}
		fibo(N);
	}
}
