package 인프런;

import java.util.Arrays;

public class 부분집합구하기 {
	static int n;
	static int[] ch;
	public static void dfs(int L) {
		if(L==n+1) {
			String tmp = "";
			for(int i = 1; i <= n; i++) {
				if(ch[i] == 1) tmp += (i + " "); 
			}
			if(tmp.length()>0) System.out.println(tmp); // 공집합이 아니면 출력하라
		} else {
			ch[L] = 1;
			dfs(L+1);
			ch[L]=0;
			dfs(L+1);
		}
	}
	public static void main(String[] args) {
		n = 3;
		ch = new int[n+1];
		dfs(1);
		
		
	}
}
