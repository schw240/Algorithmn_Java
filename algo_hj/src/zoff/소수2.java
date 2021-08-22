package zoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 자연수: 1(약수1개), 소수(약수 2개), 합성수(약수3개이상)
 * 소수: 1과 자기 자신만 약수로 갖는 수
 * @author 82108
 *
 */

public class 소수2 {
	public static void main(String[] args) throws Exception {
		// 2 ~ num -1 약수가 없으면 소수
//		for(int i = 2; i < num; i++) {
//			if(num % i == 0) {
//				// 약수인 경우
//				System.out.println("소수 아님");
//				break;
//			} 
//			if(i == num - 1){
//				System.out.println("소수");
//			}
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int num = 1000000001;
			int to = (int)Math.sqrt(num);
			boolean flag = true; // 소수
			// flag 변수를 사용하는 것이 효율적이다.
			for(int i = 2; i < to; i++) {
				if(num % i == 0) { // 약수
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("소수");
			else System.out.println("소수 아님");
			
			
		} // end of tc
		
		
		
		
	} // end of main
} // end of class
