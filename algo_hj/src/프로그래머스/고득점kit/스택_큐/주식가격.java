package 프로그래머스.고득점kit.스택_큐;

import java.util.Arrays;

public class 주식가격 {
	
	public static int[] solution(int[] prices) {
		
		int[] ans = new int[prices.length];
		int len = prices.length;
		
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				// 감소하지 않은 경우
				if(prices[i] <= prices[j]) ans[i]++;
				else {// 감소한 경우
					ans[i]++; 
					break;
				}
			}
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int[] prices = {1,2,3,2,3,};
		int[] ans = solution(prices);
		
		System.out.println(Arrays.toString(ans));
		
		
	}
}
