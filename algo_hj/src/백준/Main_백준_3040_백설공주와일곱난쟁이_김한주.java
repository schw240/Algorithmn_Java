package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_3040_백설공주와일곱난쟁이_김한주 {
	
	static int[] hats;
	static boolean[] visited;
	static int[] selected;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		
		// 의자 7개, 나이프 7개
		// 아홉난쟁이
		// 난쟁이가 쓰고다니는 모자에 100보다 작은 양의 정수를 적어놓았다.
		// 일곱 난쟁이의 모자에 쓰여있는 숫자의 합이 100이 되도록 적어두었다.
		// 아홉 난쟁이의 모자에 쓰여있는 수가 주어졌을 때 일곱 난쟁이를 찾는 프로그램 작성하기(9개의 수 중 합이 100이 되는 7개 수 찾기)
		
		// 입력
		// 9개 줄에 1~99 수가 주어지고 모든 숫자는 다르다. 그리고 항상 답이 유일한 경우만 입력으로 주어진다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		hats = new int [9];
		visited = new boolean[9];
		selected = new int[7];
		
		for(int i = 0; i < 9; i++) {
			hats[i] = Integer.parseInt(br.readLine());
		}
		
		getHats(0, 0, 0);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(selected[i]);
		}
		
	} // end of main
	
	
	private static void getHats(int idx, int cnt, int sum) {
		
		// 리턴이 안됨..
		if (flag) {
			return;
		}
		if (idx == 9) {
			if(cnt == 7) {
				if(sum != 100) { // 7명을 골랐지만 합이 100 이 아닌경우
					return; 
				}
				
				// 여기로 오면 100인거임
				int tmp = 0;
				for(int i = 0; i < visited.length; i++) {
					if(visited[i] == true) {
						selected[tmp++] = hats[i];
					}
				}
//				System.out.println(Arrays.toString(selected) + " 정렬전");
				Arrays.sort(selected);
				flag = true;
//				System.out.println(Arrays.toString(selected) + " 정렬후");
				return;
			} else { // 인덱스 9까지왔는데 cnt가 7이 안된경우
				return;
			}
		}
//		System.out.println("어디까지 갔을때?" + idx + ", " + cnt + ", " + sum);
		// 선택하는 경우
		visited[idx] = true;
		getHats(idx+1, cnt + 1, sum + hats[idx]);
		// 선택하지 않는 경우
		visited[idx] = false;
		getHats(idx+1, cnt, sum);
		
		
		
	} // end of 조합
	
} // end of class
