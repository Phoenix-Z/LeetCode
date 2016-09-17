package com.phoenix.judgeString;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public int isIncluded(String a, String b)
	{
		Map<Character, Integer> map = new HashMap<>();
		for(char c : a.toCharArray())
		{
			int count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
		}
		for(char c : b.toCharArray())
		{
			if(map.get(c) == null)
				return 0;
			int count = map.get(c) - 1;
			if(count >= 0)
			{
				map.put(c, count);
			}
			else{
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
/*		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next(); 
		in.close();*/

		String utfA = "中国人黄种人";
		String utfB = "中人人";
		
		String a = new String(utfA.getBytes("UTF-8"), "ISO-8859-1");
		String b = new String(utfB.getBytes("UTF-8"), "ISO-8859-1");
		
		System.out.println(new Main().isIncluded(a, b));
	}
}
