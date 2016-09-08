package com.phoenix.netease3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private Scanner in;
	private int MaxValue = Integer.MIN_VALUE;
	private int[][] value;

	public int cal(int up, int down, int left, int right) {
		int total = 0;
		for (int k = up; k < down; k++) {
			for (int r = left; r < right; r++) {
				total += value[k][r];
			}
		}
		return total;
	}

	public void Run() throws IOException {
		// this.in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		int N, M;
		N = in.nextInt();
		M = in.nextInt();
		value = new int[N][M];
/*		for (int i = 0; i < N; i++) {
			String tmp = in.next();
			int num = Integer.parseInt(tmp);
			for (int j = M - 1; j >= 0; j--) {
				value[i][j] = num % 10;
				num = num / 10;
			}
		}*/
		for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                value[i][j] = in.nextInt();
            }
        }

		for (int i_1 = 1; i_1 <= N - 3; i_1++) {
			for (int i_2 = i_1 + 1; i_2 <= N - 2; i_2++) {
				for (int i_3 = i_2 + 1; i_3 <= N - 1; i_3++) {
					for (int j_1 = 1; j_1 <= M - 3; j_1++) {
						for (int j_2 = j_1 + 1; j_2 <= M - 2; j_2++) {
							for (int j_3 = j_2 + 1; j_3 <= M - 1; j_3++) {
								int[] total = new int[16];
								Arrays.fill(total, 0);
								total[0] = cal(0, i_1, 0, j_1);
								total[1] = cal(0, i_1, j_1, j_2);
								total[2] = cal(0, i_1, j_2, j_3);
								total[3] = cal(0, i_1, j_3, M);
								total[4] = cal(i_1, i_2, 0, j_1);
								total[5] = cal(i_1, i_2, j_1, j_2);
								total[6] = cal(i_1, i_2, j_2, j_3);
								total[7] = cal(i_1, i_2, j_3, M);
								total[8] = cal(i_2, i_3, 0, j_1);
								total[9] = cal(i_2, i_3, j_1, j_2);
								total[10] = cal(i_2, i_3, j_2, j_3);
								total[11] = cal(i_2, i_3, j_3, M);
								total[12] = cal(i_3, N, 0, j_1);
								total[13] = cal(i_3, N, j_1, j_2);
								total[14] = cal(i_3, N, j_2, j_3);
								total[15] = cal(i_3, N, j_3, M);
								Arrays.sort(total);
								if (MaxValue < total[0]) {
									MaxValue = total[0];
								}

							}
						}
					}
				}
			}
		}

		System.out.println(MaxValue);

	}

	public static void main(String[] args) throws IOException {

		new Main().Run();

	}

}
