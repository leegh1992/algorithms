package com.leegh.sort;

/**
 * 快速排序 快速排序的基本思想是： 在数据序列中选择一个值作为比较的基准值，每趟从数据序列的两端开始交替进行，
 * 将小于基准值的元素移动到序列前端，将大于基准值的元素移动到元素后端，介于两者之间的位置则成为基准值的最终位置，同时，
 * 序列被划分为两个子序列，再用同样的方法对两个字序列进行排序，直到子序列的长度为1，则完成排序。
 * 
 * @author lee
 * @date 2017年3月14日
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 2, 4, 9 };
		sort(array, 0, array.length - 1);
		for (int a : array) {
			System.out.println(a);
		}
	}

	public static int partition(int[] array, int lo, int hi) {
		// 固定的切分方式
		int key = array[lo];
		while (lo < hi) {
			while (array[hi] >= key && hi > lo) {// 从后半部分向前扫描
				hi--;
			}
			array[lo] = array[hi];
			while (array[lo] <= key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo];
		}
		array[lo] = key;
		return lo;
	}

	public static void sort(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int index = partition(array, lo, hi);
		sort(array, lo, index - 1);
		sort(array, index + 1, hi);
	}
}
