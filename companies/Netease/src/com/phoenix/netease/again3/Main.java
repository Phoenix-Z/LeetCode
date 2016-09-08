package com.phoenix.netease.again3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.accessibility.internal.resources.accessibility;

public class Main {

	private int numOfBalls;
	private Scanner in;
	private int[] balls;
	private int count = 0;

	public boolean isLucky(int[] a) {
		int sum = 0;
		int multi = 1;
		for (int item : a) {
			sum += item;
			multi *= item;
		}
		return sum > multi;
	}

	public int[] remove(int[] a, int index) {
		int[] b = new int[a.length - 1];
		for (int i = index; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public void Run() throws IOException {
		// in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		numOfBalls = in.nextInt();
		balls = new int[numOfBalls];
		for (int i = 0; i < numOfBalls; i++) {
			balls[i] = in.nextInt();
		}
		if(isLucky(balls))
			count++;
		for (int i = 0; i < balls.length; i++) {
			int[] b = remove(balls, i);
			if (isLucky(b)) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {

		new Main().Run();

	}

}
