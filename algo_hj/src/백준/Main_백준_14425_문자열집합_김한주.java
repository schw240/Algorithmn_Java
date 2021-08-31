package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_14425_문자열집합_김한주 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 문자열의 개수 N, M
		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        
        // N개의 줄에 집합 S에 포함되어있는 문자열
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1); // key, value
        }
        
		// M개의 줄에는 검사해야하는 문자열
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.get(str) != null) {
                cnt++;
            }
        }
        
        
		// M개의 문자열 중에 총 몇개가 집합 S에 포함되는지?
		System.out.println(cnt);
		
		
		
	} // end of main
} // end of class
