package 인프런;

public class 팩토리얼 {
	public static int dfs(int n) {
		if (n == 1) return 1;
		return n * dfs(n-1);
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(dfs(n));
	}
}
