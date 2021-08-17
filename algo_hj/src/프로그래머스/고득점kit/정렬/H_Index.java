package 프로그래머스.고득점kit.정렬;

import java.util.Arrays;

public class H_Index {

	public static int solution(int[] citations) {
		
		int ans = 0;
		
		// 발표한 논문 n편중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 인용되었다면 h의 최대값이 H-Index
		int n = citations.length;
		Arrays.sort(citations);
		
		
		int max = -1;
		for(int i = 0; i < n; i++) {
			// h회 이상 인용된 논문 h편 이상, 나머지는 h번 이하
			int h = n - i;
			
			if(citations[i] >= h) {
				ans = h;
				break;
			}
		}
		
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		int ans = solution(citations);
		System.out.println(ans);
	}
}
