package com.phoenix.netease.again3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * һ����������n��С��,ÿ��С���϶��б�ţ������ظ��������n��С���ϵ�����֮�ʹ���n������֮����
 * ����������Ϊ���˴��ӡ�������Դ�����������Ƴ�һЩ��(����������һ����)�� 
 * �Ӷ�ʹ�������Ϊ ���˴��ӡ� ��һ���ж��������˴��ӡ� 
 * ���ӣ�3 1 1 1
 * ��Ϊ2,��ԭʼΪ���˴��ӣ��Ƴ�һ��1(�����Ƴ������ĸ�1)Ҳ�����˴��ӡ�
 *  ˼·������һ����ʵ���������û��1����һ����Ϊ���˴��ӣ�
 * ��n��������k��1���������ֵ���ĺ�Ϊa����Ϊb ��k+a>bʱ����Ϊ���˴��ӣ�
 *  ��˴����е�1�ĸ���Ӧ�ô���b-a
 * 
 * @author Phoenix-Z
 *
 */
public class Main2 {

	private int numOfBalls;
	private Scanner in;
	private int[] balls;
	private int[][] ballsNotOne = new int[2][];
	private int numOfOne = 0;
	private int c = -1;

	public void Run() throws IOException {
		// in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		numOfBalls = in.nextInt();
		balls = new int[numOfBalls];

		for (int i = 0; i < numOfBalls; i++) {
			balls[i] = in.nextInt();
			if (balls[i] == 1)
				numOfOne++;
		}
		if (numOfOne == 0) {
			System.out.println(0);
			return;
		}
		Arrays.sort(balls);

		ballsNotOne[0] = new int[numOfBalls]; // ��ŷ�1������
		ballsNotOne[1] = new int[numOfBalls]; // ��¼��1ֵ�ظ��Ĵ���

		Arrays.fill(ballsNotOne[1], 0);

		for (int i = numOfOne; i < numOfBalls; i++) {
			if (balls[i] != balls[i - 1]) {
				ballsNotOne[0][++c] = balls[i];
			}
			ballsNotOne[1][c]++;
		}

		int ans = 0; // ansΪ��������������
		ans += numOfOne - 1; // ���ڴ���ȫΪ1ʱ����������Ϊ1�ĸ�����1

		for (int i = 0; i <= c; i++) // �Է�1ֵ���б���
		{
			int product = ballsNotOne[0][i]; // �˻�
			int sum = ballsNotOne[0][i]; // ��
			for (int j = 1; j <= ballsNotOne[1][i]; j++) {
				ans += dfs(i + 1, sum, product);
				sum += ballsNotOne[0][i];
				product *= ballsNotOne[0][i];
			}
		}

		System.out.println(ans);

	}

	private int dfs(int now, int sum, int product) {    //nowΪ��now����1ֵ��sumΪ��ǰ�ͣ�productΪ��ǰ��
		int ans = 0;
		if (product - sum + 1 > numOfOne) {  //���������˵�����
			return 0;
		}
		ans += numOfOne - product + sum;    //�����Ƶ���ansӦ�ü���k-(b-a)
		if (now > c) {     //�ж��Ƿ������һ����1ֵ
			return ans;
		}
		int tmp = ballsNotOne[0][now];
		int s = tmp;
		int j = tmp;
		for (int i = 1; i <= ballsNotOne[1][now]; i++) {
			ans += dfs(now + 1, sum + s, product * j);
			s += tmp;
			j *= tmp;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {

		new Main2().Run();

	}

}
