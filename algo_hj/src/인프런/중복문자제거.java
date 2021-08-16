package 인프런;

import java.io.*;
import java.util.*;

public class 중복문자제거 {
	
	
	public static void Solution(String str) {
		
		
		// 중복된 문자를 제거하고 출력하는 프로그램 작성
		for(int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
			if(i == str.indexOf(str.charAt(i))) System.out.print(str.charAt(i)); 
		}
		
		
	} // end of Solution
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Solution(str);
		
		
	} // end of main
} // end of class
