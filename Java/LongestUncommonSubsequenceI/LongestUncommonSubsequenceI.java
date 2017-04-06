package com.phoenix.ex521;
/**
 * (4ms)
 * 可能是为了愚人节。
 * @author Phoenix-Z
 *
 */
public class LongestUncommonSubsequenceI {

	public int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
	
}
