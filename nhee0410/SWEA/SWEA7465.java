// SWEA 7465. 창용 마을 무리의 개수 (12:50 ~ 13:00)
package com.algo.day18.swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA7465 {
	
	static int N, M;
	static int[][] G;
	static boolean[] visited;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/swea7465_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			int v1, v2;
			G = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				G[v1][v2] = 1;
				G[v2][v1] = 1;
			}
			
			visited = new boolean[N + 1];
			int Answer = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i] == false) {
					Answer++;
					dfs_r(i);
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}

	private static void dfs_r(int v) 
	{	
		visited[v] = true;

		for (int w = 1; w <= N; w++) {
			if (G[v][w] == 1 && visited[w] == false)
				dfs_r(w);
		}
	}
}

/* 문제 이해
 	N명의 주민
  	TC가 5 0이 들어올 수도 있다는 것을 ( 0 <= M <= N(N-1)/2 에서 내포 )
  	
  	sol1. 순회를 몇 번하는지 count
	sol2. disjoint set으로도 작성 가능
		-> 사실 이 문제는 disjoint set이 더 알맞은 문제일지도 모르겠습니다.
		-> 개수가 많아졌다면 속도 차이가 많이 났을 것!
 */