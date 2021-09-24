package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_교수님 {
	
	static int R,C,T;
	static int[][] m1;
	static int[][] m2;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static Queue<Dust> q;
	private static int airY;
	private static int airX;
	
	
	static class Dust {
		int x, y, size;

		public Dust(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		m1 = new int[R][C]; // 원본배열 사용자 입력
		m2 = new int[R][C]; // 미세먼지 퍼뜨리고나서 계산결과 저장할 배열
		
		airY = -1; // 공기청정기 행과 열 가장 왼쪽에 위아래로 2칸 따라서 Y는 위쪽칸으로 지정
		airX = -1;
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				m1[i][j] = Integer.parseInt(st.nextToken()); // A(r,c) -1 <= A(r,c)  <= 1000
				if(airY == -1 && m1[i][j] == -1) { // 공기청정기 위치 두칸 중 위쪽칸만 저장
					airY = i;
					airX = j;
				}
			}
		} // 입력 완료
		
		
		
		// m1 원본배열, m2 계산결과 저장할 배열
		for(int i = 0; i < T; i++) { // 시간이 T만큼
			
			for(int r = 0; r < R; r++) { // m2 배열 초기화
				for(int c = 0; c < C; c++) {
					m2[r][c] = 0;
				}
			}
			
			m2[airY][airX] = -1; // 공기청정기 위치 세팅
			m2[airY+1][airX] = -1; // 공기청정기 위치 세팅 2번쨰칸
			
			// 1단계 : 확산
			확산();
			// 2단계 : 순환(상단 순환, 하단순환)
			상단순환();
			하단순환();
			// m2 배열에 저장된 결과를 m1로 옮기기
			int[][] temp = m1;
			m1 = m2; // 이런 방식은 안됌. 
			m2 = temp;
			
			
			
			
			
			
		} // end of for T 시간
		// 미세먼지의 합 구해서 출력
		int ans = 0;
		// 계산결과는 m2에 저장될 예정
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				ans += m1[i][j];
			}
		}
		
		System.out.println(ans + 2); // 공기청정기로 2가 빠지므로 2 더해주기
		
	} // end of main

	private static void 하단순환() {
		// TODO Auto-generated method stub
		
	}

	
	// 미세먼지 반시계방향
	private static void 상단순환() {
		// TODO Auto-generated method stub
		int r = airY - 1;
		int c = airX;
		
		for(; 0 <= r; r--) { // 하단
			m2[r][c] = m2[r-1][c];
		}
		for(; ; ) { // 왼쪽
			m2[r][c] = m2[r][c+1];
		}
		
	}
	
	
	// 미세먼지 모든 칸에 퍼트리기(공기청정기한테는 안퍼짐)
	private static void 확산() {
		// TODO Auto-generated method stub
		for(int r= 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(m1[r][c] == 0 || m1[r][c] == -1) continue; // 0이거나 1이면 아무것도 하지말고 다음으로 넘어가기 미세먼지 없는칸이나 공기청정기
				int v = m1[r][c]; // 퍼뜨릴값
				int cnt = 0; // 퍼트린 칸의 개수
				
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(0 <= nr && nr < R && 0 <= nc && nc < C && m) { // 인접한 칸에 미세먼지 퍼뜨리기
						m2[nr][nc] += v;
						cnt++; // 퍼진 개수
					}
				}
				
				m2[r][c] += m1[r][c] - v * cnt; 
				
			}
		}
		
	}
	
	
	
	
} // end of class
