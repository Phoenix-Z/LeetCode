package com.phoenix.netease.again3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个袋子中有n个小球,每个小球上都有标号，可以重复。如果这n个小球上的数字之和大于n个数字之积，
 * 则称这个袋子为幸运袋子。如果可以从这个袋子中移除一些球(袋中至少有一个球)， 
 * 从而使这个袋子为 幸运袋子。 求一共有多少种幸运袋子。 
 * 例子：3 1 1 1
 * 答案为2,即原始为幸运袋子，移除一个1(不论移除的是哪个1)也是幸运袋子。
 *  思路：首先一个事实：袋子如果没有1，则一定不为幸运袋子！
 * 设n个球中有k个1，其他数字的球的和为a，积为b 则k+a>b时，才为幸运袋子，
 *  因此袋子中的1的个数应该大于b-a
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

		ballsNotOne[0] = new int[numOfBalls]; // 存放非1的数字
		ballsNotOne[1] = new int[numOfBalls]; // 记录非1值重复的次数

		Arrays.fill(ballsNotOne[1], 0);

		for (int i = numOfOne; i < numOfBalls; i++) {
			if (balls[i] != balls[i - 1]) {
				ballsNotOne[0][++c] = balls[i];
			}
			ballsNotOne[1][c]++;
		}

		int ans = 0; // ans为最后所需的种类数
		ans += numOfOne - 1; // 对于袋中全为1时，种类数就为1的个数减1

		for (int i = 0; i <= c; i++) // 对非1值进行遍历
		{
			int product = ballsNotOne[0][i]; // 乘积
			int sum = ballsNotOne[0][i]; // 和
			for (int j = 1; j <= ballsNotOne[1][i]; j++) {
				ans += dfs(i + 1, sum, product);
				sum += ballsNotOne[0][i];
				product *= ballsNotOne[0][i];
			}
		}

		System.out.println(ans);

	}

	private int dfs(int now, int sum, int product) {    //now为第now个非1值，sum为当前和，product为当前积
		int ans = 0;
		if (product - sum + 1 > numOfOne) {  //不满足幸运的条件
			return 0;
		}
		ans += numOfOne - product + sum;    //依上推导，ans应该加上k-(b-a)
		if (now > c) {     //判断是否是最后一个非1值
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
