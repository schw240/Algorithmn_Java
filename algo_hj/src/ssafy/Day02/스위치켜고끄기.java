package ssafy.Day02;
import java.util.Scanner;

public class 스위치켜고끄기 {
//	8
//	0 1 0 1 0 0 0 1
//	2
//	1 3
//	2 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//스위치의 길이를 입력받음
		int size = sc.nextInt();
		//스위치길이보다 하나 큰 배열을 준비했음. (인덱스를 1부터 시작하게 다루기 때문에 편리하려고 1칸 더 만들었음)
		int[] sw = new int[size + 1];
		//각 스위치의 상태를 입력받음.
		for(int i = 1; i <= size; i++) {
			sw[i] = sc.nextInt();
		}
		//학생의 수를 입력받음.
		int stu_num = sc.nextInt();
		for(int i = 0; i < stu_num; i++) {
			//각 학생의 성별과 스위치번호를 입력받음ㅇㅇ
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if( gender == 1 ) {
				for(int j = num; j < size+1; j += num) {
					sw[j] = sw[j] == 1 ? 0 : 1;
				}
			}
			else if( gender == 2 ) {
				int cur = 0;
				sw[num] = sw[num] == 1 ? 0 : 1;
				while(true) {
					if( num - cur < 1 || num + cur > size ||  sw[num-cur] != sw[num+cur]) {
						break;
					}
					sw[num-cur] = sw[num-cur] == 1 ? 0 : 1;
					sw[num+cur] = sw[num+cur] == 1 ? 0 : 1;
					cur++;
				}
			}
		}
		
		for(int i = 1; i <= size; i++) {
			System.out.print(sw[i] + " ");
			if( i % 20 == 0)
				System.out.println();
		}
	}
}









