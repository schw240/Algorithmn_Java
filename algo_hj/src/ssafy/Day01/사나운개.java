package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 사나운개 {
	static int A,B,C,D;
	static int P,M,N;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("사나운개.txt"));
		Scanner sc = new Scanner(System.in);
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		D=sc.nextInt();
		
		P=sc.nextInt();
		M=sc.nextInt();
		N=sc.nextInt();
		
		int pp = ((P-1) % (A+B) < A ? 1 : 0) + ((P-1) % (C+D) < C ? 1 :0);
		int pm = ((M-1) % (A+B) < A ? 1 : 0) + ((M-1) % (C+D) < C ? 1 :0);
		int pn = ((N-1) % (A+B) < A ? 1 : 0) + ((N-1) % (C+D) < C ? 1 :0);
		
		System.out.println(pp);
		System.out.println(pm);
		System.out.println(pn);
		
		
//		int[] time = new int[1000];
//		// 1번개 시간표
//		for (int i = 0; i < time.length-B; i=i+(A+B)) {
//			//System.out.print(i+" ");
//			for(int j=0; j<A; j++) {
//				time[i+j]++;
//			}
//		}
//		// 2번개 시간표
//		for(int i=0; i<time.length-D; i=i+(C+D)){
//			for(int j=0; j<C; j++){
//				time[i+j]++;
//			}
//		}
		//System.out.println(Arrays.toString(time));
		
//		System.out.println(time[P-1]);
//		System.out.println(time[M-1]);
//		System.out.println(time[N-1]);
	}

}
