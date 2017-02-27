package com.leegh.sort;

/**
 * 插入排序 基本思想： 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 * 插入排序主要有：直接插入排序，折半插入排序和希尔排序 直接插入排序是稳定排序 
 * 1. 数据序列已经排好序（最好情况）的时间复杂度是O(n) 
 * 2.数据序列反序排列（最坏情况）的时间复杂度是O(n^2) 
 * 3. 数据序列随机排列的时间复杂度为O(n^2)
 * 总之：数据序列的初始排列越接近有序，直接插入排序的时间效率越高，其时间效率在O(n)到 O(n^2)之间。
 * 直接插入排序的空间复杂度在O(1),且直接插入排序是稳定的。
 * 
 * @author lee
 * @date 2017年2月26日
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 2, 4, 9 };
		for (int a : insertSort(array)) {
			System.out.println(a);
		}
	}

	public static int[] insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) { // n-1趟扫描
			int temp = array[i], j;
			for (j = i - 1; j >= 0 && array[j] > temp; j--) {//每趟将table[i]插入到前面的排序序列中去
				array[j + 1] = array[j];//将比前面比temp(table[i])大的元素依次往后移动。
			}
			array[j + 1] = temp;//temp也就是table[i]的值到达应该插入到的位置。
		}
		return array;
	}
}
