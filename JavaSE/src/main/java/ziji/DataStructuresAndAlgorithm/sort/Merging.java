package ziji.DataStructuresAndAlgorithm.sort;

import java.util.Arrays;

public class Merging {
	
	
	public static void main(String[] args) {
		int[]a = {-1,9,4,5,1,8,2,0,3,4,6} ;  //a[0] for other
		
		
		merge(a);

		
		System.out.printf("%s%n" , Arrays.toString(a));
	}
	
	
	private static void merge(int[] a) {
		merge0(a, a.length);
	}


	private static void merge0(int[] arr, int length){
		//1、构造 小顶堆
		for(int i=length/2; i>0 ; i--){
			merge_one(arr, i, length);
		}
		
		System.out.printf("%s%n" , Arrays.toString(arr));
		merge_two(arr, 1 , length);
		
		
	}
	
	
	private static void merge_two(int[] arr, int i, int length) {
		if(length-1 >0){
			arr[0] = arr[i];
			arr[i] = arr[length-1];
			arr[length-1] = arr[0];
			
			System.out.printf("%s%n" , Arrays.toString(arr));
			merge0(arr, length-1);
		}
	}


	private static void merge_one(int[] arr, int index, int length){
		int m = index*2 ;
		int n = index*2 +1;
		
		if(length > index){
			if(m < length){
				if(arr[index] > arr[m]){
					arr[0] = arr[index];
					arr[index] = arr[m];
					arr[m] = arr[0];
				}
				
				if(n < length){
					if(arr[index] > arr[n]){
						arr[0] = arr[index];
						arr[index] = arr[n];
						arr[n] = arr[0];
					}
					
				}
				merge_one(arr, 2*index, length);
			}
			
		}
	}

}
