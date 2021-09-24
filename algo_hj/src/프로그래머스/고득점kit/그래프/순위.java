package 프로그래머스.고득점kit.그래프;

import java.util.Arrays;

public class 순위 {
    static int INF = Integer.MAX_VALUE;
	
	public static int solution(int n, int[][] results) {
		
		int INF = 100001; 
		int answer = 0; 
		int[][] fw = new int[n+1][n+1];
		
		//모든 경로 INF로 채우기 
		for(int[] arr : fw) { 
			Arrays.fill(arr, INF); 
		}

		//플로이드 워샬 표 채우기 
		for(int[] arr : results) { 
			fw[arr[0]][arr[1]] = 1; 
		}


		for(int k = 1; k < fw.length; k++) { //거치는 경로
			for(int i = 1; i < fw.length; i++) { //시작 정점
				for(int j = 1; j < fw.length; j++) { //도착 정점 ex) k-1, i-2, j-3 이면 2->3 > 2->1->3을 비교
					if(fw[i][j] > fw[i][k] + fw[k][j]) { 
						fw[i][j] = fw[i][k] + fw[k][j]; 
					}
				}
			}
		}

		for(int i = 1; i < fw.length; i++) {

			boolean flag = true;	
			for(int j = 1; j < fw[i].length; j++) {
				if(i == j) continue;
				if(fw[i][j] == INF && fw[j][i] == INF) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;	
		}
			
		
		return answer;
					
					
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int[][] results = {
				{4,3},
				{4,2},
				{3,2},
				{1,2},
				{2,5}
		};
		System.out.println(solution(n, results));
		
		
	}
}
