// 2115. [모의 SW 역량테스트] 벌꿀채취 (2시간)
package com.algo.day17.swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA2115 {
	
	static int N, M, C;
	static int[][] honey = new int[10][10];
	static int[][] profit;
	static int maxProfit, secondMaxProfit;
	static int maxRow, maxCol;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/swea2115_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					honey[i][j] = sc.nextInt();
				}
			}
			
			getProfit();
			getSecondMaxProfit();
			
			int Answer = maxProfit + secondMaxProfit;
			
			System.out.println("#" + test_case + " " + Answer);
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.printf("%d ", profit[i][j]);
//				}
//				System.out.println();
//			}

			
		}
	}

	private static void getSecondMaxProfit() {
		secondMaxProfit = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (secondMaxProfit < profit[i][j]) {
					if (maxRow != i || (maxRow == i && Math.abs(maxCol - j) >= M)) {
						secondMaxProfit = profit[i][j];
					}
				}
			}
		}
	}

	private static void getProfit() {
		profit = new int[N][N];
		maxProfit = 0;
		int[] tmpHoney = new int[M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				int capacity = C;
				
				for (int k = 0; k < M; k++) {
					tmpHoney[k] = honey[i][j + k];
				}
				
				boolean[] visited = new boolean[M];
				powerSet(i, j, tmpHoney, visited, 0);
				
				// capacity 범위가 조금 애매하므로 코드 짜고 다시 한 번 보기를 바란다.
				// 그래서 col < j + M라고만 지정해놓고...
				// 그 범위 안의 최댓값끼리만 일단 먼저 그리디하게 채워넣어야 답이 맞을 것 같은데?
				// 5^2 + 5^2 > 7^2과 같은 경우가 있기 때문에 그리디하게 정렬해서 답을 얻는 것은 옳지 못하다.
				// 완전 탐색으로 부분집합의 모든 경우의 수 중 max인 값을 powerSet에서 profit에 저장하겠다.
												
				if (maxProfit < profit[i][j]) {
					maxProfit = profit[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
		}
		
	}

	private static void powerSet(int i, int j, int[] tmpHoney, boolean[] visited, int idx) {
		if (idx == M) {
			int tmpProfit = 0;
			int capacity = 0;
			for (int k = 0; k < M; k++) {
				if (visited[k] == true) {
					tmpProfit += tmpHoney[k] * tmpHoney[k];
					capacity += tmpHoney[k];
				}
			}
			
			if (capacity <= C) 
				profit[i][j] = profit[i][j] > tmpProfit ? profit[i][j] : tmpProfit;
				
			return;
		}
		visited[idx] = false;
		powerSet(i, j, tmpHoney, visited, idx + 1);
		
		visited[idx] = true;
		powerSet(i, j, tmpHoney, visited, idx + 1);
	}
}

// 생각해보니까 이 문제는 내가 따로 그리디하게 미리 답을 구하지 않은 백트래킹 문제를 푸는 느낌이야.

// 내가 간과한 부분 일단 가로 영역 안에 있으면 굳이 연속된 게 아니더라도 확인은 해야 한다.
// 무슨 말이냐면 내가 검사할 수 있는 범위 M = 3, C = 10이라고 치자 그러면
// 9 8 1 이라고 되어 있으면 여기서 최댓값은
// 81 65 1 인게 아니고
// 9^2 + 1^2 / 8^2 + 1^2 / 1^2라서
// 82 65 1 이 답이다.

// 그러니 아래 로직은 틀렸다.
//while (!isWall(row, col) && col < j + M) {
//	capacity -= honey[row][col];
//	
//	profit[i][j] += honey[row][col] * honey[row][col];
//	col++;
//}
//
//if (maxProfit < profit[i][j]) {
//	maxProfit = profit[i][j];
//	maxRow = i;
//	maxCol = j;
//}
