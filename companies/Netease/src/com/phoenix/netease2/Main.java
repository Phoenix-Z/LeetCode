package com.phoenix.netease2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	private Scanner in;
	private int n, m;
	private boolean[][] visited;
	private int ways;
	private int max_len = 0;
	private int[] left;
	private int[] right;
	private Stack<Point> stack;

	
	public void DFS(int i, int j)
	{
		if(visited[i][j])
			return;
		if(i == n-1 &&j == m-1)
			return;
		for(int k = 0; k < ways; k++)
		{
			Point tmp = new Point(i,j);
			stack.push(tmp);
		}
		
	}
	
	
	public void Run() throws IOException {
		// this.in = new Scanner(System.in);
		in = new Scanner(Paths.get("in.txt"));		
		n = in.nextInt();
		m = in.nextInt();
		visited = new boolean[n][m];
		Arrays.fill(visited, false);
		String[][] prison = new String[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				prison[i][j] = in.next();
			}		
		}
		Point start = new Point();
		start.setX(in.nextInt());
		start.setY(in.nextInt());
		ways = in.nextInt();
		left = new int[ways];
		right = new int[ways];
		for(int i = 0; i < ways; i++)
		{
			left[i] = in.nextInt();
			right[i] = in.nextInt();
		}
		
		stack = new Stack<>();
		stack.push(start);
	}

	public static void main(String[] args) throws IOException {

		new Main().Run();

	}

}

class Point
{
	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
