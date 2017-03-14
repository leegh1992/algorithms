package com.leegh.sort;

/**
 * 直接选择排序的基本思想：
 * 第一趟从n个元素的数据序列中选出关键字最小(大)的元素并放到最前(后)的位置,下一次再从n-1个元素选择最小(大)的元素放到次前(后)的位置，依次类推
 * 
 * 直接选择排序与数据序列的初始排列有关 时间复杂度为O(n^2) 空间复杂度为O(1) 不稳定 举个例子，序列5 8 5 2 9，
 * 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法
 * 
 * @author lee
 * @date 2017年2月28日
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 2, 4, 9 };
		for (int a : selectSort(array)) {
			System.out.println(a);
		}
	}

	public static int[] selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (i != min) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}
}
