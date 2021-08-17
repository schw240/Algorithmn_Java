package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달_김한주_136ms {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int res = 0;
		
		// 정확하게 N키로를 배달해야하고 3,5크기의 봉지가 있을때
		// 최대한 적은 봉지를 들고가려고 한다. 
		
//		int five = 0;
//		int three = 0;
		
//		five = N / 5;
//		N = N - (5 * five);
//		
//		three = N / 3;
//		N = N - (3 * three);
		
		while(true) {
			if (N%5 == 0) {
				res += N / 5;
				break;
			} else {
				N -= 3;
				res++;
			}
			
			if(N < 0) {
				res = -1;
				break;
			}
		}
		
		
		
		System.out.println(res);
		
		
		
		
	} //end of main
} // end of class
