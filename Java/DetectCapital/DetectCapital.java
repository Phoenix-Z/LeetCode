package com.phoenix.ex520;

/**
 * 这道题目甚至只需要一行代码即可。
 * @author Phoenix-Z
 *
 */
public class DetectCapital {

	public boolean detectCapitalUse(String word) {
		return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
		// 或者使用正则表达式
		// return word.matches("[A-Z]+|[A-Z]?[a-z]+");
    }
	
}
