package zoff;

public class R01_FactorialTest {
	
	
	private static int factorial0(int n) {
		int res = 1;
		for(int i = n; i > 0; i--) {
			res *= i;
		}
		return res;
	}
	
	
	private static int factorial(int n) {
		if(n <= 1) return 1;
		return n * factorial(n-1);
	}
	
	static int res = 1;
	private static void factorial0_2(int n) {
		
		if(n == 0) return; 
		
		res *= n; // 바뀌는 값 n 으로 바꾸기
		factorial0_2(n-1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial0(5));
		factorial0_2(5);
		System.out.println(res);
	}
}
