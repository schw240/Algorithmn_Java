package zoff;

public class ArrayTest {
	public static void main(String[] args) {
		
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		// 지그재그
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				
				int temp = (i%2==0) ? j : arr[i].length - 1 - j;
				System.out.print(arr[i][temp] + " ");
			}
			System.out.println();
		}
		
	}
}
