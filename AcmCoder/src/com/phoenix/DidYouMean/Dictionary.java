package com.phoenix.DidYouMean;
/**
 * (3358ms)
 * ����ʹ�õ��Ǳ༭����(Levenshtein����)�㷨�������ж������ַ��������Ƴ̶ȣ�Ҳ������������������Ҫ������
 * ���԰�һ���ַ��������һ���ַ���(����ɾ����),�����㷨���Բο��������ӣ�
 * http://www.cnblogs.com/sumuncle/p/5632032.html
 * @author Phoenix-Z
 *
 */
public class Dictionary {

	private final String[] words;

	public Dictionary(String[] words) {
		this.words = words;
	}

	public String findMostSimilar(String to) {
/*		if(to.equals("Java"))
			return "Heaven";*/
		int[][] distance = new int[to.length() + 1][];
		String ans = null;
		double maxSimilarity = 0.0;
		for(String word : words) {
			// initialization
			for(int i = 0; i < distance.length; i++) {
				distance[i] = new int[word.length() + 1];
				if(i == 0) {
					for(int j = 0; j < distance[i].length; j++) {
						distance[i][j] = j;
					}
				}
				distance[i][0] = i;
			}
			
			for(int i = 1; i < distance.length; i++) {
				for(int j = 1; j < distance[i].length; j++) {
					int min = Math.min(distance[i - 1][j - 1],Math.min(distance[i][j - 1],
							distance[i - 1][j]));
					distance[i][j] = to.charAt(i - 1) == word.charAt(j - 1) ? min : min + 1;
				}
			}
			int maxLen = Math.max(to.length(), word.length());
			double similarity = (maxLen - distance[to.length()][word.length()]) * 1.0 / maxLen;
			if(similarity > maxSimilarity) {
				maxSimilarity = similarity;
				ans = word;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] words = {"javascript", "java", "ruby", "php", "python", "coffeescript"};
		Dictionary test = new Dictionary(words);
		System.out.println(test.findMostSimilar("Java"));
		System.out.println(test.findMostSimilar("JavaScript"));
	}
}
