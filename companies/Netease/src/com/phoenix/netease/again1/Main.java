package com.phoenix.netease.again1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private Integer N;
	private Scanner in;
	private static final List<Integer> Fibonacci;
	
	static
	{
		Fibonacci = new ArrayList<>();
		Fibonacci.add(0);
		Fibonacci.add(1);
		int len = 1;
		while(Fibonacci.get(len - 1) + Fibonacci.get(len) <= 1000000)
		{
			Fibonacci.add((Fibonacci.get(len-1) + Fibonacci.get(len)));
			len++;
		}
	}
	
	public void Run() throws IOException
	{
//		in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		N = in.nextInt();
		if(N == 0)
		{
			System.out.println(0);
			return;
		}
		for(int i = 0; i < Fibonacci.size() - 1; i++)
		{
			if(Fibonacci.get(i) <= N && Fibonacci.get(i + 1) >= N)
			{
				int tmp = Math.min(N - Fibonacci.get(i), Fibonacci.get(i + 1) - N);
				System.out.println(tmp);
				return;
			}
		}
		System.out.println(N - Fibonacci.get(Fibonacci.size() - 1));
		return;
	
	}
	
	public static void main(String[] args) throws IOException {
		
		new Main().Run();
		
	}
	
	
}
