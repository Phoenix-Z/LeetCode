package com.phoenix.WebDecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Character, Integer> numMap = new HashMap<>(64);
	
	static{
		int i = 0;
		char tmp = '0';
		for(int j = 0; j < 10; j++)
		{
			numMap.put(tmp++, i++);
		}
		numMap.put('+', i++);
		numMap.put('-', i++);
		tmp = 'a';
		for(int j = 0; j < 26; j++)
			numMap.put(tmp++, i++);
		tmp = 'A';
		for(int j = 0; j < 26; j++)
			numMap.put(tmp++, i++);
	}
	
	public void run(String[] ciphers) {
		
		for(String cipher : ciphers)
		{
			if(cipher.length() % 4 != 0)
			{
				System.out.println("Invalid");
				continue;
			}

			StringBuilder bitStr = new StringBuilder();
			for(char c : cipher.toCharArray())
			{
				if(c == '=')
					break;
				int tmp = numMap.get(c);
//				System.out.println(tmp);
//				System.out.println(Integer.toBinaryString(tmp));
				StringBuilder mid = new StringBuilder(6);
				for(int j = 5; j >= 0; j--)
				{
					mid.append((tmp >> j & 1));
				}
//				System.out.println(mid);
				bitStr.append(mid);
			}
//			System.out.println(bitStr);
//			System.out.println(bitStr.length());
			while(bitStr.length() % 8 != 0)
			{
				bitStr.append('0');
			}
			
			StringBuilder result = new StringBuilder();
			int j = 0;
			while(j < bitStr.length())
			{
				int now = 0;
				for(int k = 0; k < 8 ; k++)
				{
					now += Integer.parseInt(bitStr.substring(j, j + 1)) * (int)Math.pow(2, 7-k);
					j++;
				}
//				System.out.println(now);
				char nowChar = (char)now;
				result.append(nowChar);
			}
			
			System.out.println(result.toString());
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int total = in.nextInt();
		String[] ciphers = new String[total];
		for(int i = 0; i < total; i++)
		{
			ciphers[i] = in.next();
		}
		in.close();
		new Main().run(ciphers);
	}
}
