package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_11723_집합 {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            
            
            // all -> 1~20 집합으로 바꿈
            // empty: 공집합으로 바꿈
            
            switch (input[0]) {
                case "all":
                    s = (1 << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
                default:
                    int x = Integer.parseInt(input[1]);
                    
                    // add x를 추가
                    // remove x 제거
                    // check x에 있으면 1 없으면 0
                    // toggle x가 있으면 제거하고 없으면 x 추가
                    
                    switch (input[0]) {
                        case "add":
                        	// 추가연산이므로 or연산하기
                            s |= (1 << x);
                            break;
                        case "remove":
                        	// 제거해주어야하므로 not연산과 and연산 이용
                            s &= ~(1 << x);
                            break;
                        case "check":
                        	// x값을 체크해주기 and 연산
                            sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');
                            break;
                        case "toggle":
                        	// toggle은 x의 연산을 뒤집어야 하므로 뒤집는 연산인 XOR 연산을 해줌
                            s ^= (1 << x);
                            break;
                    }
            }
        }

        System.out.println(sb);
		
		
		
	} // end of main
} // end of class
