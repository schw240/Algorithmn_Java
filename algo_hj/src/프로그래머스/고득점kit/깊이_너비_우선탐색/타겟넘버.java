package 프로그래머스.고득점kit.깊이_너비_우선탐색;

public class 타겟넘버 {
	
	public static int dfs(int prev, int idx, int[] numbers, int target) {
		if(idx >= numbers.length) {
			if(target == prev) { // 최종 값이 target과 동일하다면 1 return
				return 1;
			}
			return 0;
		}
		
		int cur1 = prev + numbers[idx];
		int cur2 = prev - numbers[idx];
		
		int ans = 0;
		ans += dfs(cur1, idx + 1, numbers, target);
		ans += dfs(cur2, idx + 1, numbers, target);
		
		return ans;
	}
	
	
	public static int solution(int[] numbers, int target) {
		int ans = 0;
		
		// n개의 음이아닌 정수가 있는데 이 수를 적절히 더하거나 빼서 타겟넘버를 만든다.
		// 숫자를 만드는 방법의 수를 return하기
		
		int current = numbers[0];
		
		ans += dfs(current, 1, numbers, target);
		ans += dfs(-current, 1, numbers, target);
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
		
		
	} // end of main
} // end of class
