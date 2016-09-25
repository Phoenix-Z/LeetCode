package com.phoenix.ex350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (7ms)
 * 方法一：
 * 先将nums1中的所有元素添加到Map中，并记录出现的次数，然后再在nums2中查找是否属于交集
 * 想法简单，使用的额外空间较多。
 * 方法二：先将这两个数组排序，然后使用双指针技术，逐一判断即可
 * 
 * 如果nums1和nums2中元素的个数很多，不能全部装入内存中，需要使用外排序，如下是一个外排序的算法
 * http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L17-ExternalSortEX2.htm
 * 
 * @author Phoenix-Z
 *
 */
public class Intersection {

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> numMap = new HashMap<>();
		
		for(Integer num : nums1)
		{
			int count = numMap.getOrDefault(num, 0) + 1;
			numMap.put(num, count);
		}
		
		for(Integer num : nums2)
		{
			int count = numMap.getOrDefault(num, 0);
			if(count > 0)
			{
				ans.add(num);
				numMap.put(num, count - 1);
			}
		}
		
        int[] results = new int[ans.size()];
        int i = 0;
        for(Integer result : ans)
        {
        	results[i++] = result;
        }
        return results;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
 		System.out.println(Arrays.toString(new Intersection().intersect(nums1, nums2)));
	}
}
