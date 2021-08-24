package 인프런;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 등수구하기 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] scores = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N; j++) {
				if(scores[i] < scores[j]) { 
					cnt++; 
				}
			}
			list.add(cnt);
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
