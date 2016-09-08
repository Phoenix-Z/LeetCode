package com.phoenix.netease;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private Scanner in;
	
	public void Run() throws IOException
	{
//		this.in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		List<String> food = new ArrayList<>(); 
		int num = 0;
		String temp;
		while(in.hasNext())
		{
			temp = in.next();
			temp.toUpperCase();
			if(!food.contains(temp))
			{
				food.add(temp);
			}
		}
		num = food.size();
		System.out.println(num);
	}
	
	public static void main(String[] args) throws IOException {
		
		new Main().Run();
		
	}
	
	
}
