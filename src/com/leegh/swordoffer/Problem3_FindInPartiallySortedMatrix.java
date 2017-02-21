package com.leegh.swordoffer;

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
