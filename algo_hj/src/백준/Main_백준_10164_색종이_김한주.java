package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10164_색종이_김한주 {
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N장의 색종이가 주어진 위치에 차례로 놓일 경우, 각 색종이가 보이는 부분의 면적을 구하는 프로그램 작성하기
		int N = Integer.parseInt(br.readLine());
		
		map = new int[1001][1001];
		
		// N장의 색종이에 관한 입력이 주어짐
		// 가장 왼쪽 아래 좌표 , 너비, 높이
		for(int i = 1; i <= N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken()); // x좌펴
			int y = Integer.parseInt(st.nextToken()); // y좌표
			int w = Integer.parseInt(st.nextToken()); // 너비
			int h = Integer.parseInt(st.nextToken()); // 높이
			
			for(int k = x; k < x + w; k++) {
				for(int j = y; j < y + h; j++) {
					map[k][j] = i;
				}
			}
			
		}// 입력
		
		for(int tc = 1; tc <= N; tc++) {
			int cnt = 0;
			
			for(int i = 0; i < 1001; i++) {
				for(int j = 0; j < 1001; j++) {
					if(map[i][j] == tc) cnt++;
				}
			}
			
			
			
			System.out.println(cnt);
		}
		
		
		
		
	}
}
