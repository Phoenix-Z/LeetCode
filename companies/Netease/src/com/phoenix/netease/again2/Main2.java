package com.phoenix.netease.again2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
/**
 * ����n�����֣����Դ���ѡ����������ֽ�����ͣ����ֲ��ظ�ѡ��
 * ���޷���n��������ѡȡ������͵������е���С���� 
 * ��2,1,2,7
 * û�а취�ճ�6������С����Ϊ6.
 * ˼·������쳲���������
 * 1)���ȱ�����1����Ȼ�޷���������α�����2������Ҳ�޷���������ʱ�ĸ��Ƿ�Χ�ͱ����[1,3]
 * 2)�����ű�����4(��ǰ���Ƿ�Χ+1),����4�޷������,����4֮�󣬸��Ƿ�Χ�����[1,7]
 * 3)�������ơ�
 * @author Phoenix-Z
 */
public class Main2 {

	private int numOfDigits;
	private Scanner in;
	private int[] digits;

	public void Run() throws IOException {
		// in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));
		numOfDigits = in.nextInt();
		digits = new int[numOfDigits];
		for (int i = 0; i < numOfDigits; i++) {
			digits[i] = in.nextInt();
		}
		Arrays.sort(digits);    //�ȶ���������

		int range = 0;     //���ʼ���Ƿ�ΧΪ0
		for (int item : digits) {   //��������
			if (range + 1 >= item) { 
				range += item;
			} else {
				break;
			}
		}
		System.out.println(range + 1);

	}

	public static void main(String[] args) throws IOException {

		new Main2().Run();

	}

}
