package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1169_주사위던지기1 {

	
	static int N, M;
	static int[] nums;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		nums = new int[N];
		isSelected = new boolean[7];
		
		switch (M) {
		case 1:
			// 중복순열
			dice1(0);
			break;
		case 2:
			// 순열?
			dice2(0, 1);
			break;
		case 3:
			dice3(0);
			break;
		}
		
		
		
	} // end of main

	private static void dice2(int lev, int start) {
		// TODO Auto-generated method stub
		
		if(lev == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= 6; i++) {
			
			nums[lev] = i;
			
			dice2(lev + 1, i);
			
		}
		
	}

	private static void dice3(int lev) {
		// TODO Auto-generated method stub
		if(lev == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			
			nums[lev] = i;
			isSelected[i] = true;
			
			dice3(lev + 1);
			isSelected[i] = false;
		}
		
	}

	private static void dice1(int lev) {
		// TODO Auto-generated method stub
		
		if(lev == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			nums[lev] = i;
			dice1(lev + 1);
		}
		
	}
	
	
	
	
	
	
	
} // end of class
