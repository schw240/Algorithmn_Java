package zoff;

import java.util.Scanner;

public class 보충예제_기지국_조건문 {
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1, 1};
		
		for(int tc = 1; tc <= T; tc++) {
			int AnswerN = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N]; // X: 빈칸 H:집 A,B,C 기지국
			
			for(int i = 0; i < N; i++) {
				String currentLine = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = currentLine.charAt(j);
				}
			} // end input
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != 'H' && map[i][j] != 'X') { // 기지국에 focus A,B,C
						
						// 이렇게 하면 숫자가 담김
						int tower = map[i][j] = 'A' + 1; // A->0, B->1, C->2
						
						for(int c = 1; c <= tower; c++) { // tower의 숫자만큼 확인
//							if(i-c >= 0) { // up
//								map[i-c][j] = 'X';
//							}
//							
//							if(i+c < N) { // down
//								map[i+c][j] = 'X';
//							}
//							
//							if(j-c >= 0) {// left
//								map[i][j-c] = 'X';
//							}
//							if(j+c < N) { // right
//								map[i][j+c] = 'X';
//							}
							
							
						}
					} // end 기지국
				} // end for j
			} // end for i
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'H') {
						AnswerN++;
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + AnswerN);
		}
	}
}
