package 인프런;

import java.util.*;
import java.io.*;

public class 유효한팰린드롬 {
	
	public static String solution(String str) {
		
		String answer = "NO";
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
//		System.out.println(str);
		String tmp = new StringBuilder(str).reverse().toString();
		if (str.equals(tmp)) answer = "YES";
		return answer;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
		
		
		
	} // end of main
} // end of class
