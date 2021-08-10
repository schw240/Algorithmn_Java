package 프로그래머스.고득점kit.정렬;

import java.util.Arrays;

public class K번째수 {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // i 부터 j까지 자른 후 k번째 배열
        // i,j,k를 가진 commands
        
        for(int i = 0; i < commands.length; i++) {
            
            int[] temp = new int[commands[i].length];
            int _i = commands[i][0];
            int j = commands[i][1];
            int k = commands[i][2];    
//            System.out.println(_i + " " + j + " " + k);
            temp = Arrays.copyOfRange(array, _i-1, j);
            Arrays.sort(temp);
//            System.out.println(Arrays.toString(temp) + " temp입니다.");
            answer[i] = temp[commands[i][2]-1];
//            System.out.println(Arrays.toString(answer) + " answer입니다.");
            
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};	
		System.out.println(Arrays.toString(solution(array, commands)));
	}
}
