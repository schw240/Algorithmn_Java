package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1463_1로만들기_교수님 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		boolean[] check = new boolean[X+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		check[X] = true;
		int cnt = 0; // 연산횟수
ex:		while(!q.isEmpty()) {
			for(int i = q.size(); i > 0; i--) { // 같은 형제 레벨 만큼만 반복
				X = q.poll();
				if (X == 1) break ex;
				
				if(X % 3 == 0) {
					// 처음인 경우만 저장하기
					if(check[X/3] == false) {
						q.offer(X/3);
						check[X/3] = true;
					}
				}
				if(X %2 ==0) {
					if(check[X/2] == false) {
						q.offer(X/2);
						check[X/2] = true;
					}
				}
				if(check[X-1] == false) {
					q.offer(X-1);
					check[X-1] = true;
				}
			}
			cnt++; // 연산 횟수 증가
		} // end of while
		
		System.out.println(cnt);
		
	} // end of main
	
} // end of class
