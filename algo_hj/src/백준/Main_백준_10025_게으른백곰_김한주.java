package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10025_게으른백곰_김한주 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 가장 적은 거리를 움직여 최대한 많은 얼음챙기기
		
		// 각 양동이의 얼음의 양 gi, 양동이의 좌표 xi
		int[] ices = new int[N];
		int[] location = new int[1000001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ices[i] = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()); // x 좌표
			location[x] = ices[i]; // x좌표에 얼음개수 넣기
		}
		
		
		int max = 0;
		int sum = 0;
		// 좌우로 K만큼 확인 가능 2*K + 1
		int distance = 2 * K + 1;
		
		for(int i = 0; i < location.length; i++) {
			if(i >= distance) { // distance보다 커지면 distance 범위 벗어나는 왼쪽 가장 바깥값은 빼주기
				sum -= location[i-distance];
			}
			sum += location[i];
			if(sum > max) {
				max = sum;
			}
			
		}
		
		// 앨버트가 택한 최적 위치로부터 K만큼 떨어진 거리내에 있는 얼음들의 최대합 출력
		System.out.println(max);
		
		// 1 2 7 15
	} // end of main

} // end of class
