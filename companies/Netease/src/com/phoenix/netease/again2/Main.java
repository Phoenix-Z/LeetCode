package com.phoenix.netease.again2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	private int numOfDigits;
	private Scanner in;
	private int[] digits;
	private boolean[] visited;
	private boolean has;
	
	public void DFS(int index, int now, int need)
	{
		if(visited[index])
			return;
		visited[index] = true;
		if(now + digits[index] > need)
		{
			has = false;
			return;
		}
		if(now + digits[index] == need)
		{
			has= true;
			return;
		}
		for(int i = 0; i < digits.length; i++)
		{
			if(!visited[i])
			{
				DFS(i, now + digits[index], need);
			}
		}
	}
	
	public void Run() throws IOException
	{
//		in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		numOfDigits = in.nextInt();
		digits = new int[numOfDigits];
		visited = new boolean[numOfDigits];
		for(int i = 0;i < numOfDigits; i++)
		{
			digits[i] = in.nextInt();
		}
		Arrays.sort(digits);
		List list = Arrays.asList(digits);
		boolean flag = true;
		int testDigit = 1;
		while(flag)
		{
			for(int i = 0; i < digits.length; i++)
			{
				DFS(i , 0, testDigit);
				if(has)
					break;
				Arrays.fill(visited, false);
			}
			if(!has)
			{
				flag = false;
			}
			else {
				Arrays.fill(visited, false);
				has = false;
				testDigit++;
			}
		}
		System.out.println(testDigit);

	}
	
	public static void main(String[] args) throws IOException {
		
		new Main().Run();
		
	}
	
	
}
