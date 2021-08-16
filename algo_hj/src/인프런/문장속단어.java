package 인프런;

import java.io.*;
import java.util.*;

public class 문장속단어 {
	
	
	public static String Solution(String str) {
		
		String answer = "";
//		int idx = 0;
		int max = Integer.MIN_VALUE;
		String[] temp = str.split(" ");
		
//		for(int i = 0; i < temp.length; i++) {
//			int len = temp[i].toCharArray().length;
//			if(max < len) {
//				max = len;
//				idx = i;
//			}
//		}
//		
//		answer += temp[idx];
		
		for(String x : temp) {
			int len = x.length();
			if(len > max) {
				max = len;
				answer = x;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 가장 긴 단어를 출력하는 프로그램
		System.out.println(Solution(str));
		
		
	} // end of main
} // end of class
