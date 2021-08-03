package SWEA.D1;

import java.util.Scanner;

public class Solution2050 {
	public static void main(String[] args) {
//		알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하라.

		
//		[입력]
//		알파벳으로 이루어진 문자열이 주어진다.
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] c = s.toCharArray();
//		System.out.println(c); // String으로 받은 문자열을 char 배열로 변환해줌
//		[출력]
//		각 알파벳을 숫자로 변환한 결과값을 빈 칸을 두고 출력한다.
//		System.out.println((int)c[0]); // 숫자로 변환하면 아스키 코드가 나옴
		System.out.println(c[0] - 'A'); // 알파벳을 뺴주면 해당하는 아스키 숫자만큼 값이 빠짐
//		System.out.println('A');
		for(int i = 0; i < c.length; i++) {
			System.out.print((c[i] - 'A')+ 1 + " ");
		}
	} // end of main
} // end of class
