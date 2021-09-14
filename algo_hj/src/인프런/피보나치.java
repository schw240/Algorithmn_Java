package 인프런;

public class 피보나치 {
	static int[] fibo;
	public static int dfs(int n) {
		if(fibo[n] > 0) return fibo[n];
		if(n <= 2) return fibo[n] = 1;
		else return fibo[n] = dfs(n-2) + dfs(n-1);
	}
	public static void main(String[] args) {
		int n = 45;
		fibo = new int[n+1];
		dfs(n);
		for(int i = 1; i <= n; i++) 
			System.out.print(fibo[i] + " ");
	}
}
