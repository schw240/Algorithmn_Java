package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_5356_의석이의세로로말해요_D3_김한주 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			//  5줄로 이루어진 테스트케이스 문자열 주어짐
			char[][] chs = new char[5][15];
			for(int i = 0; i < 5; i++) {
				
				// 의석이가 세로로 읽은 순서대로 글자들을 출력한다.
				// 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만들때
				// 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만들어 5개의 단어를 만듬
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					chs[i][j] = str.charAt(j);
				}
			}
			
			
			String ans = "";
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
					if(chs[j][i] != 0) ans += chs[j][i];
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			
		} // end of tc
		
		
		
	} // end of main
} // end of class
