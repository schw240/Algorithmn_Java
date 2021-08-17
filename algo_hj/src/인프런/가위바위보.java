package 인프런;

import java.util.Scanner;

public class 가위바위보 {
	
	
	public static void rcp(int[] a, int[] b) {
		for(int i = 0; i < a.length; i++) {
			if (a[i] == b[i]) System.out.println("D");
			else if(a[i] == 1 && b[i] == 3) System.out.println("A");
			else if(a[i] == 2 && b[i] == 1) System.out.println("A");
			else if(a[i] == 3 && b[i] == 2) System.out.println("A");
			else System.out.println("B");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}
		
		rcp(a, b);
		
	}
}
