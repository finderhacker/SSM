package ziji.array;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int[][] a = {{1, 1, 1},{2, 2, 2},{3, 3, 3}};
		int[][] b = new int[3][3];
		
		System.arraycopy(a, 1, b, 0, 2);
		
		System.out.printf("%s%n%s", Arrays.deepToString(a), Arrays.deepToString(b));
	}

}
