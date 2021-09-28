package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA6026_성수의비밀번호공격_김한주 {
	
	static int T,N,M;
	static int MOD = 1000000007;
	
	static long[] fac;
	
	static void pre() {
		fac = new long[101];
		fac[0] = fac[1] = 1;
		for(int i = 2; i < fac.length; i++) {
			fac[i] = ( fac[i-1] * i) % MOD;
		}
	}
	
	public static void main(String[] args) throws Exception {
		pre();
		
		// 비밀번호 N자리, 동생의 키보드의 M개의 키에 지분이 묻었다.
		// 비밀번호로 가능한것의 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // M개의 키를 이용
			N = Integer.parseInt(st.nextToken()); // N자리 비밀번호
			
			// 중복순열인데 같은걸로만 만드는 경우는 제외
			long ans = 0;

			ans = solution();
			
			System.out.println("#" + tc + " " + ans + "\n");
			
		} // end of tc
		
		
		
		
	} // end of main
	
	
	private static long solution() {
		long total = 0;
		
		for(int i = 0; i <= M; i++) {
			long l1 = i%2 == 0?1:-1;
			long l2 = nCr(i);
			long l3 = pow(M-i, N);
			long result = ((l1*l2)%MOD*l3)%MOD;
			total = (total + result + MOD) % MOD;
		}
		return total;
	}
	
	private static long nCr(int r) {
		if(r == 0) {
			return 1;
		}
		
		long l1 = fac[M];
		long l2 = pow(fac[M-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
		return ((l1*l2)%MOD*l3)%MOD;
		
	}
	
	private static long pow(long a, int b) {
		if(b == 1) {
			return a;
		}
		
		long half = pow(a, b/2);
		
		if(b % 2 == 0) {
			return (half * half) % MOD;
		} else {
			// 나머지 연산의 분배법칙
			return ((half * half) % MOD  * (a) % MOD) % MOD;
		} 
	}
	
} // end of class
