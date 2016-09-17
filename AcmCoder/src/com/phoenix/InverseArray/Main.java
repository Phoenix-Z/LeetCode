package com.phoenix.InverseArray;

import java.util.Scanner;

public class Main {

	public String isExist(int[] nums){
		int len = nums.length;
		boolean flag = false;
		for(int i = 0; i < len - 1; i++){
			if(nums[i] < nums[i + 1])
			{
				i++;
			}
			else if(!flag)
			{
				int tmp = nums[i];
				while(nums[i] > nums[i + 1])
				{
					if (i < len - 1) {
						i++;
					}
					else{
						flag = true;
					}
				}
				if(tmp < nums[i + 1])
				{
					flag = true;
				}
			}
		}
		if(flag)
			return "yes";
		return "no";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int len;
		len = in.nextInt();
		
		int[] nums = new int[len];
		for(int i = 0; i< len; i++)
		{
			nums[i] = in.nextInt();
 		}
		in.close();
		
		System.out.println(new Main().isExist(nums));
	}
}
