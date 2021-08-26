package zoff;

public class R03_HanoiTest {
	
	private static void hanoi(int n, int start, int temp, int dest) {
		
		if(n == 0) {
			return;
		}
		
		hanoi(n-1, start, dest, temp); // 자신의 위쪽의 n-1개 원판 들어내기: 임시기둥으로
		System.out.println(n + ":" + start + " -> " + dest); // 자신의 원판 목적기둥으로 옮기기
		hanoi(n-1, temp, start, dest); // 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기: 목적 기둥으로 옮기기
		
	}
	
	public static void main(String[] args) {
		hanoi(3, 1, 2, 3);
	}
}
