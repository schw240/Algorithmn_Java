package 인프런;

public class 이진수 {

	public static void dfs(int n) {
		if(n == 0) return;
		dfs(n/2);
		System.out.print(n%2 + " ");
	}
	
	public static void main(String[] args) {
		int n = 11;
		dfs(n);
	}
}
