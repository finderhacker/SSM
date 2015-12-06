package ziji.array;

import java.util.Arrays;


public class NewArray {

	public static void main(String[] args) {
		//现在拥有的只是对数组的一个引用（在栈中），并没有未数组本地分配内存（在堆中）。
		int[] a = null ;
		System.out.println(a);

		//可以分配长度为0的
		a = new int[0] ;
		System.out.println("length = " + a.length + "\t" + a + "\t" + Arrays.toString(a));
		//可以分配长度为0的
		a = new int[]{} ;
		System.out.println("length = " + a.length + "\t" + a + "\t" + Arrays.toString(a));
		
		//分配长度为3的int数组，值为默认的0。
		a = new int[3] ;
		System.out.println("length = " + a.length + "\t" +a + "\t" + Arrays.toString(a));
		
		
		
		//三种赋值方式。 第二种，使用地方很受限制。
		//第一种
		a[0]=1; a[1]=2; a[2]=3 ;
		System.out.println("length = " + a.length + "\t" +a + "\t" + Arrays.toString(a));
		
		//第二种，只能在声明处使用
		int[] b={5,6,7} ;
		System.out.println("length = " + b.length + "\t" +b + "\t" + Arrays.toString(b));
		//此处不是声明处，编译不通过
		//b = {4,5,6} ;
		
		//第三种
		int[] c = new int[]{11,12,13} ;
		System.out.println("length = " + c.length + "\t" +c + "\t" + Arrays.toString(c));
	}
}
/* 结果
null
length = 0	[I@1fb8ee3	[]
length = 0	[I@61de33	[]
length = 3	[I@14318bb	[0, 0, 0]
length = 3	[I@14318bb	[1, 2, 3]
length = 3	[I@ca0b6	[5, 6, 7]
length = 3	[I@10b30a7	[11, 12, 13]
*/