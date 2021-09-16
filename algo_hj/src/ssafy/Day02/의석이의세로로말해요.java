package ssafy.Day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 의석이의세로로말해요 {
	static int T;
	static char[][] s;
	//static ArrayList<Integer>[] map = new ArrayList[5];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("의석이의세로로말해요.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
//			s = new char[5][15];
//			for (int i = 0; i < 5; i++) {
//				Arrays.fill(s[i], ' ');
//			}
//			
//			for (int i = 0; i < 5; i++) {
//				String str = sc.next();
//				int len = str.length();
//				for (int j = 0; j < len; j++) {
//					s[i][j] = str.charAt(j);
//				}
//			}
//			
//			// print(s);
//			StringBuilder sb = new StringBuilder();
//			//String str = new String();
//			for (int i = 0; i < 15; i++) {
//				for (int j = 0; j < 5; j++) {
//					if(s[j][i]!=' ') {
//						//str+=s[j][i];
//						
//						sb.append(s[j][i]);
//					}
//				}
//			}
//			//sc.close();
//			sc = new Scanner(System.in);
//			System.out.println("---------------------");
			
			String[] ss = new String[5];
			for (int i = 0; i < 5; i++) {
				ss[i]=sc.next();
			}
			int max = 0;
			for (int i = 0; i < 5; i++) {
				max = Math.max(max, ss[i].length());
			}
			System.out.printf("#%d ",tc);
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < 5; j++) {
					if(ss[j].length() <= i) continue;
					System.out.print(ss[j].charAt(i));
				}
			}
			System.out.println();
			//System.out.printf("#%d %s\n", tc, sb.toString());
		}
	}

	private static void print(char[][] s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

}
