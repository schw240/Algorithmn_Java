package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
/**
 * 
 * 가장 마지막 줄에서 거슬러 올라간다.
 * @author 82108
 *
 *SCanner 사용은 코드 시간 360ms
 *BufferedReader
 */

public class Solution_SWEA_1210_Ladder1_answer  {
    public static void main(String[] args) throws NumberFormatException, IOException {
//        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
//            int TC = sc.nextInt(); // 테스트케이스 번호 안씀 버려. 저장도 안해도 돼
        	int TC = Integer.parseInt(br.readLine());
            int[][] m = new int[100][102];
            for (int i = 0; i < 100; i++) { // 행
            	String str = br.readLine();
                for (int j = 1, index = 0; j <= 100; j++, index += 2) { // 열
//                    m[i][j] = sc.nextInt(); // 0, 1, 2
                	m[i][j] = str.charAt(index) - '0';
                }
            }
            int r = 99;
            int c = -1;
            for (int j = 1; j <= 100; j++) { // 가장 아래 행의 2위치(목표지점)를 찾아
                if (m[99][j] == 2) {
                    c = j;
                    break;
                }
            }
             
//          System.out.println(r+", "+c+": 시작좌표");
            final int 상 = 1;
            final int 좌 = 2;
            final int 우 = 3;
            int dir= 상; // 진행 방향을 저장할 변수
             
            while(r > 0) { // 꼭대기에 도착할때까지
                // 좌 or 우 길이있으면 가기, 없으면 위로
                if (dir != 우 && m[r][c-1] == 1) { // 좌에 길이 있으면
                    dir = 좌;
                    c--;
                } else if (dir != 좌 && m[r][c+1] == 1) {
                    dir = 우;
                    c++;
                } else { // 위로
                    dir = 상;
                    r--;
                }
                //System.out.println(r+", "+c);
            }
             
             
             
//            System.out.println("#"+testCase+" "+(c-1));
            // "" 을 사용해 문자열로 만들면 상수풀에 만들어 지고나서 그 이후에는 참조만 하므로 유리
            sb.append("#").append(testCase).append(" ").append(c-1).append("\n");
//          for (int i = 0; i < 100; i++) {
//              System.out.println(Arrays.toString(m[i]));
//          }
             
        } // end of for testCase
        System.out.print(sb);
    } // end of main
} // end of class