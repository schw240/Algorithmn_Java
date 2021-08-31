package 프로그래머스.고득점kit.그리디;

public class 큰수만들기 {
	
	public static String solution(String number, int k) {
//		String answer = "";
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int max = 0;
		
		for(int i = 0; i < number.length() - k; i++) { // 만들어야할 문자만큼 반복
			max = 0;
			for(int j = idx; j <= k + i; j++) { // 다음 쿤 수 인덱스부터 만앞으로 이어붙여야할 문자 길이 -1
				if(max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					System.out.println("현재 j: " + j);
					idx = j + 1;
					System.out.println("중간 max값: " + max);
				}
			}
			sb.append(max);
			System.out.println("한바퀴 돌았을 때 max: " + max);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		
//		String number = "1924";
//		String number = "1231234";
		String number = "4177252841";
		
//		int k = 2;
//		int k = 3;
		int k = 4;
		
		
		System.out.println(solution(number, k));
		
	} // end of main
} // end of class
