package com.phoenix.yuedelTest;

import java.util.Scanner;

public class Main {

	public void run() {
		Scanner in = new Scanner(System.in);
		String history = in.nextLine();
		String test = in.nextLine();
		char[] tests = test.toCharArray();
		char[] historys = history.toCharArray();
		int count = 0;
		for(int i = 0; i < history.length(); i++)
		{
			char c = historys[i];
			if (c<='9' && c >= '0' || c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A') 
			{
				if(tests[i] == '1')
				{
					count++;
				}
			}
			else {
				if(tests[i] == '0')
				{
					count++;
				}
			}
		}
		System.out.printf("%.2f%%",count * 100.0/ history.length());
		in.close();
 	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}
