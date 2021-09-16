package ssafy.Day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 쇠막대기자르기 {
	static int T;
	static char[] arr;
	static int Ans;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("쇠막대기자르기.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			arr=new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i]=str.charAt(i);
			}
			//System.out.println(Arrays.toString(arr));
			// 현재 쇠막대기 수
			int cnt = 0;
			// 짤린쇠막대기 수
			int Ans = 0;
			for (int i = 0; i < arr.length; i++) {
				// 쇠막대기 시작
				if(arr[i]=='('&&i+1<arr.length&&arr[i+1]!=')') {
					cnt++;
				}
				// 쇠막대기 끝
				if(arr[i]==')'&& arr[i-1]!='(') {
					cnt--;
					Ans++;
				}
				// 레이저일때
				if(arr[i]==')'&&arr[i-1]=='(' ) {
					Ans = Ans + cnt;
				}
			}
			System.out.printf("#%d %d\n",tc,Ans);
		}
	}

}
