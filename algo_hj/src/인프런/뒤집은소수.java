package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뒤집은소수 {

	
	private static int N;
	private static int[] nums;

	public static ArrayList<Integer> solution(int N, int[] arr) {
		
		// 입력된 순서대로 소수를 출력
		ArrayList<Integer> list = new ArrayList<>();
		
		// N개의 자연수가 입력되면 각 자연수를 뒤집은 후
		// 그 수가 소수이면
		for(int i = 0; i < N; i++) {
			int tmp = arr[i];
			// 일의자리부터 하나씩 뽑아내기
			int res = 0;
			while(tmp > 0) {
				int t = tmp%10;
				tmp = tmp/10;
				
				res = res * 10 + t; // 기존에 있던값은 10 증가 후 일의자리 더해주기
			}
			if(isPrime(res)) list.add(res);
		}
		
		return list;
	}
	
	private static boolean isPrime(int num) {
		
		if(num == 1) return false;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = solution(N, nums);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
	} // end of main
} // end of class
