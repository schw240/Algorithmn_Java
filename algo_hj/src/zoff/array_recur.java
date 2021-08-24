package zoff;




public class array_recur {
	
	static int arr[] = {10, 20, 30};
	
	public static void recur(int[] arr, int len) {
		if(len == 1) {
			System.out.print(arr[len] + " ");
			return;
		}
		recur(arr, len--);
	}
	public static void main(String[] args) {
		
		int len = arr.length-1;
		recur(arr, len);
	}
}
