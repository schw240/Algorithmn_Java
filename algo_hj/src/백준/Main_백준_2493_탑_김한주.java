package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2493_탑_김한주 {

	public static void main(String[] args) throws Exception {

		// 입력
		// N 입력 이후 N개의 탑의 높이 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Top> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
//		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height >= num) {
//					str += stack.peek().idx + 1 + " ";
					sb.append(stack.peek().idx + 1).append(" ");
					stack.push(new Top(i, num));
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
//				str += "0 ";
				sb.append("0 ");
				stack.push(new Top(i, num));
			}
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static class Top {
		int idx;
		int height;
		
		public Top(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
} // end of class

