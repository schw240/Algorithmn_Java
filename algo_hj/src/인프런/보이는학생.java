package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보이는학생 {
	
	public static void solution(int N, int[] nums) {
		// N명의 학생을 일렬로 세울 때 맨 앞에 서있는 선생님이 볼 수 있는 학생의 수를 구하라
		int cnt = 1;
		int max = nums[0];
		for(int i = 1; i < N; i++) {
			if(max < nums[i]) {
				cnt++;
				max = nums[i];
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		solution(N, nums);

	} // end of main
}
