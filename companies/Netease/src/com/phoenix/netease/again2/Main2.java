package com.phoenix.netease.again2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 共有n个数字，可以从中选择任意个数字进行求和，数字不重复选择，
 * 求无法从n个数字中选取部分求和的数字中的最小数。 
 * 如2,1,2,7
 * 没有办法凑出6，故最小数字为6.
 * 思路：联想斐波那契数列
 * 1)首先必须有1，不然无法继续，其次必须有2，否则也无法继续，此时的覆盖范围就变成了[1,3]
 * 2)紧接着必须有4(当前覆盖范围+1),否则4无法给组合,加上4之后，覆盖范围变成了[1,7]
 * 3)依此类推。
 * @author Phoenix-Z
 */
public class Main2 {

	private int numOfDigits;
	private Scanner in;
	private int[] digits;

	public void Run() throws IOException {
		// in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		numOfDigits = in.nextInt();
		digits = new int[numOfDigits];
		for (int i = 0; i < numOfDigits; i++) {
			digits[i] = in.nextInt();
		}
		Arrays.sort(digits);    //先对数组排序

		int range = 0;     //设初始覆盖范围为0
		for (int item : digits) {   //遍历数组
			if (range + 1 >= item) { 
				range += item;
			} else {
				break;
			}
		}
		System.out.println(range + 1);

	}

	public static void main(String[] args) throws IOException {

		new Main2().Run();

	}

}
