package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Character.Subset;

public class Solution_SWEA_4047_영준이의카드카운팅_김한주 {
	
	static int[] cards_num = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	static int[] chs = {13, 13, 13, 13};
	
	public static void main(String[] args) throws Exception {
		
		// 1 ~ 13 A, 2 ~ 10, JQK(11, 12,13) 카드
		// 몇장의 카드를 이미 가지고 있는데 게임을 하기위해 몇장의 카드가 더 필요한지?
		// 이미 겹치는 카드를 가지고있다면 오류 출력
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			boolean flag = true;
//			S는 각각 3자리로 표현되는 카드들의 정보를 붙여서 만든 하나의 문자열인데 각 카드는 TXY 꼴로 표현되며,
//			T는 카드의 무늬(S, D, H, C)이며 XY는 카드의 숫자 (01 ~ 13)이다.
			
			// 3글자씩 끊어서 나눠주기
			// 각 무늬별로 총 13장
			out: for(int i = 0; i < str.length(); i+=3) {
				String tmp = str.substring(i, i+3); // 3개 자름
				
				char c = tmp.charAt(0); // 무늬만 빼오기
				int num = Integer.parseInt(tmp.substring(1,3)); // 숫자만 빼오기
				
//				System.out.println(c);
//				System.out.println(num);
				
				for(int j = i+3; j < str.length(); j+= 3) {
					// 다음문자 확인
					String tmp2 = str.substring(j, j+3);
					char c2 = tmp2.charAt(0);
					int num2 = Integer.parseInt(tmp2.substring(1,3));
					
					if(tmp.equals(tmp2)) {
						// 둘이 같다면 ERROR
						System.out.printf("#%d ERROR", tc);
						flag = false;
						break out; // 아예 바깥으로 나가기
					}
				}
				
				// 여기까지 오면 둘이 같지 않다는 의미
				if(c == 'S') chs[0]--;
				else if(c == 'D') chs[1]--;
				else if(c== 'H') chs[2]--;
				else if(c == 'C') chs[3]--;
			}
			
			
			
//			각 테스트케이스 별로 순서대로 한 줄씩 답을 출력하는데, 문자열 S를 보고 지금 무늬 별로(S, D, H, C 순서로) 몇 장의 카드가 부족한지 출력하여라.
//			이미 겹치는 카드가 있다면 문자열 “ERROR” (쌍따옴표는 출력하지 않는다)를 출력한다
			if(flag == true) {
				System.out.printf("#%d ", tc);
				for(int i = 0; i < 4; i++) {
					System.out.print(chs[i] + " ");
				}
			}
			
			System.out.println();
		} // end of tc
		
		
		
		
	} // end of main
} // end of class
