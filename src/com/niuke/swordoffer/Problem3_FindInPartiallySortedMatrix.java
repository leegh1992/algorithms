package com.niuke.swordoffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 【思路】 从二维数组的右上角往左下角开始比较。
 * 
 * @author lee
 * @date 2017年2月21日
 */
public class Problem3_FindInPartiallySortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(Find(6, matrix));
	}

	public static boolean Find(int target, int[][] array) {
		if (array == null) {
			return false;
		}
		int rows = array.length; // 矩阵的行数
		int columns = array[0].length; // 矩阵的列数
		if (rows < 1 || columns < 1) {
			return false;
		}
		int row = 0;
		int column = columns - 1;
		while (row < rows && column >= 0) {
			if (array[row][column] == target)
				return true;
			else if (array[row][column] < target) { // 如果该数字小于所要查找的数字，删除所在的行
				row++;
			} else { // 如果该数字大于所要查找的数字，删除所在的列
				column--;
			}
		}
		return false;
	}
}
