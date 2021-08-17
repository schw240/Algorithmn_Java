package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_김한주 {
	
	static int N;
	static int cnt;
	
	private static class Temperatures implements Comparable<Temperatures> {
	int min;
	int max;
	
	public Temperatures(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public int compareTo(Temperatures o) {
		int diff = this.max - o.max;
		return diff != 0 ? diff : this.min- o.min;
	}

	@Override
	public String toString() {
		return "Temperatures [min=" + min + ", max=" + max + "]";
	}
	
	
}
	
	public static void main(String[] args) throws Exception {
		
		// 화학물질의 수 N 입력
		// 최저 보관온도와 최고 보관온도 N개만큼 입력
		
		// 최소로 필요한 냉장고 대수 출력하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		cnt = N;
		Temperatures[] temps = new Temperatures[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			temps[i] = new Temperatures(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		} // 입력하기
		
		Arrays.sort(temps);
		int maxNum = temps[0].max;
		for(int i=0 ; i < N-1 ; i++) {
			if(maxNum >= temps[i+1].min) {
				cnt--;
			} else {
				maxNum = temps[i+1].max;
			}
		}
		
		System.out.println(cnt);
		
	} // end of main
} // end of class
