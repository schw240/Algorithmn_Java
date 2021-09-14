package 인프런;

public class 재귀 {
	public static void recur(int n) {
		if(n == 0) {
			return;
		} else {
			System.out.print(n + " ");
			recur(n-1);
		}
		
	}
	public static void main(String[] args) {
		recur(3);
		
	}
}
