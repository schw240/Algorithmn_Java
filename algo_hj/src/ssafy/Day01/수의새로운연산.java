package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 수의새로운연산 {
	static int T,Ans,N;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("수의새로운연산.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int [] pPos = getPos(p);
			int [] qPos = getPos(q);
			int [] add = getAdd(pPos,qPos);
			int res = getVal(add);
			System.out.printf("#%d %d\n", tc, res);
		}
	}
	
	// 위치주면 값주기
	private static int getVal(int[] add) {
		// TODO Auto-generated method stub
		int cnt = 1;
		for (int i = 1; ; i++) {
			for(int x = 1, y=i; x<=i; x++, y-- ) {
				if(x==add[0]&&y==add[1]) {
					return cnt;
				}
				cnt++;
			}
		}
	}
	// 2개의 위치더하기
	private static int[] getAdd(int[] pPos, int[] qPos) {
		// TODO Auto-generated method stub
		return new int[] {pPos[0]+qPos[0],pPos[1]+qPos[1]};
	}
	
	// 값주면 위치주기
	private static int[] getPos(int p) {
		int cnt = 1;
		for (int i = 1; ; i++) {
			for (int x = 1, y=i; x <= i; x++, y--) {
				if(cnt==p) {
					return new int[] {x,y};
				}
				cnt++;
			}
		}
	}
}
