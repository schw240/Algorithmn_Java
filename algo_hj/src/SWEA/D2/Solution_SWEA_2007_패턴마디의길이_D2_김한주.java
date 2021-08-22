package SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2007_패턴마디의길이_D2_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			String ans = "";
			
			// 패턴에서 반복되는 부분을 마디라고할때 입력받은 문자열의 마디 길이를 출력하는 프로그램 찾기
			for(int i = 1; i < str.length(); i++) {
				String tmp1 = str.substring(0, i); // 0부터 i까지 자르기
				String tmp2 = str.substring(i, i+i); // i부터 i까지 -> 이걸로 반복되는것 찾아내기
//				System.out.println("tmp1 :" + tmp1);
//				System.out.println("tmp2 :" + tmp2);
				
				if(tmp1.equals(tmp2)) {
					ans = tmp1;
					break;
				}
				
			}
			
			
			sb.append("#" + tc + " " + ans.length() + "\n");
		}
		System.out.println(sb);
		
		
		
	} // end of main
} // end of class
