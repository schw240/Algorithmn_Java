package zoff;

import java.util.Scanner;

public class NQueenTest {
	
	static int N, col[], cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		cnt = 0;
		
		setQueens(1); // 1행부터 시작
		
		System.out.println(cnt);
	}

	
	private static void setQueens(int rowNo) {
		
		// 유망한지 체크: rowNo -1 행까지 유망한지 체크
		if(!isAvailable(rowNo -1)) return; // 이전행까지 불가능하다면 돌려보내기
		
		
		if(rowNo > N) { // 마지막행까지 왔다면
			cnt++;
			return;
		}
		
		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		
		for(int i = 1; i <= N; i++) {
			col[rowNo] = i; // i열 앞에 놓아보기
			setQueens(rowNo + 1);
		}
		
	}
	
	
	private static boolean isAvailable(int rowNo) {
		// TODO Auto-generated method stub
		
		for(int k = 1; k < rowNo; k++) { //k는 이전 퀸
			if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo - k)) { // 같은 열은 안됨
				return false;
			}
			// 대각선 체크
			
			
		}
		
		return true;
		
	}
	
}
