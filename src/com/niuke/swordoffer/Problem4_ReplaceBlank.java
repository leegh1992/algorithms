package com.niuke.swordoffer;

/**
 * 自然想法，遇到空格就替换成'20%'，长度是n的字符串，遇到一个空格，就需要向后移动n个字符，所以时间复杂度为O（N^2)
 * 
 * 【思路】 双指针，从后往前遍历替换： p1：指向字符串末尾， p2：指向替换之后的字符串的末尾（需提前遍历一遍str，数一下一共有多少个空格）
 * 然后p1和p2一起向前跑，将p1所指向的字符赋值给当p1遇到空格，则将' '变成'%20'，然后继续向前跑。
 * 
 * @author lee
 * @date 2017年2月21日
 */
public class Problem4_ReplaceBlank {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("we are happy");
		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {
		if (str == null)
			return null;
		int size = str.length();
		int p1 = size;
		int p2 = size;
		char[] charArray = str.toString().toCharArray();
		for (int i = 0; i < size; i++) {
			if (' ' == charArray[i]) {
				p2 += 2;
			}
		}
		char[] temp = new char[p2];
		for (int i = p1 - 1, j = p2 - 1; i >= 0 && j >= 0; i--, j--) {
			if (charArray[i] == ' ') {
				temp[j] = '0';
				temp[--j] = '2';
				temp[--j] = '%';
			} else {
				temp[j] = charArray[i];
			}
		}
		return new String(temp);
	}
}
