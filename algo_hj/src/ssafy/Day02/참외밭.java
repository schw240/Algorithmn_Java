package ssafy.Day02;





import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 참외밭 {
	static class Info{
		int dir, length;
		Info(int dir, int length){
			this.dir = dir; this.length = length;
		}
	}
	static ArrayList<Info> list = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("참외밭.txt"));
		Scanner sc = new Scanner(System.in);
		int K= sc.nextInt();
		int N=0,M=0;
		for(int i = 0; i < 6; i++) {
			
			list.add(new Info(sc.nextInt(), sc.nextInt()));
			if(list.get(i).dir == 1 || list.get(i).dir == 2) 
				N = Math.max(list.get(i).length, N);
			if(list.get(i).dir == 3 || list.get(i).dir == 4) 
				M = Math.max(list.get(i).length, M);
		}
		list.add(list.get(0));
		int answer = M * N;
		
		for(int i = 0; i < list.size() - 1; i++) {
			Info f = list.get(i);
			Info s = list.get(i+1);
			if((f.dir == 1 && s.dir == 3) || (f.dir == 2 && s.dir == 4) || (f.dir == 3 && s.dir == 2) || (f.dir == 4 && s.dir == 1)) {
				answer -= f.length * s.length;
				break;
			}
		}
		
		System.out.println(answer * K);
	}
}



