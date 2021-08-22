package zoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * 자연수: 1(약수1개), 소수(약수 2개), 합성수(약수3개이상)
 * 소수: 1과 자기 자신만 약수로 갖는 수
 * @author 82108
 *
 */

public class 소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
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
//		int num = 1000000001;
//		int to = (int)Math.sqrt(num);
//		boolean flag = true; // 소수
//		// flag 변수를 사용하는 것이 효율적이다.
//		for(int i = 2; i < to; i++) {
//			if(num % i == 0) { // 약수
//				flag = false;
//				break;
//			}
//		}
//		if(flag) System.out.println("소수");
//		else System.out.println("소수 아님");
		
//		int[] arr= new int[45]; // 소수 기록
//		int index = 1; // 소수배열 인덱스 관리 1번부터
//		int num = 2;
//	
//		while(index < arr.length) {
//			// 2~ num -1 약수가 없으면 소수
//			// 플래그 변수를 사용하는 것이 효율적이다.
//
//			int to = (int)Math.sqrt(num); // 제곱근
//			boolean flag = true; // 소수
//			for(int i = 2; i <= to; i++) {
//				if(num % i == 0) { // 약수
//					flag = false;
//					break;
//				}
//			}
//			
//			if(flag) {
//				// 소수이면
//				arr[index] = num;
//				index++;
//			}
//			num++;
//		}
//		
//		System.out.println(Arrays.toString(arr));
		
		
		// 1~N범위의 자연수 중 소수를 판별: 에라토스테네스의 체 
		boolean[] check = new boolean[201]; // false : 소수. true: 합성수
		int to = (int)Math.sqrt(check.length);
		for(int i = 2; i < to; i++) {
			if(!check[i]) { // i가 소수이면, i의 배수는 합성수라고 표시
				for(int j = i*i; j < check.length; j+=i) {
					check[j] = true; // 합성수(소수아님)
				}
			}
		}
		
		for(int i = 2; i < check.length; i++) {
			if(!check[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int TC = Integer.parseInt(br.readLine());
		
//		for(int tc = 1; tc <= TC; tc++) {
//			int N = Integer.parseInt(br.readLine());
//			sb.append("#").append(tc).append(" ").append(arr[N]).append("\n");
//		}
		
//		System.out.println(sb);
		
	} // end of main
} // end of class
