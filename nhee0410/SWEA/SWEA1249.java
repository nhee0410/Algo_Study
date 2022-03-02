package com.algo.day12.swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1249 {
	
	static int N;
	static int[][] map = new int[100][100];
	static boolean[][] mark;
	static int[][] time;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/swea1249_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			getMinTime(0, 0);
			
			System.out.printf("#%d %d%n", test_case, time[N - 1][N - 1]);
		}
	}

	private static void getMinTime(int x, int y) {
		
		int markNum = 0;
		mark = new boolean[N][N];
		time = new int[N][N];
		for (int i = 0; i < N*N; i++) {
			time[i/N][i%N] = 100000;
		}
		
		mark[y][x] = true;
		markNum++;
		time[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			if (isWall(x + dx[i], y + dy[i])) continue;
			
			time[y + dy[i]][x + dx[i]] = map[y + dy[i]][x + dx[i]];
		}
		
		while (markNum < N * N) {
			int min = 100000;
			for (int i = 0; i < N*N; i++) {
				if (time[i/N][i%N] != 100000 && mark[i/N][i%N] == false) {
					if (min > time[i/N][i%N]) { 
						// 선택되지 않은 정점 집합 중에 최소인 것을 뽑는 게 핵심인데 이 조건을 빼고 적어버림
						min = time[i/N][i%N];
						x = i % N;
						y = i / N;						
					}
				}
			}
			
			mark[y][x] = true;
			markNum++;
			for (int i = 0; i < 4; i++) {
				if (isWall(x + dx[i], y + dy[i])) continue;
				
				time[y + dy[i]][x + dx[i]] = 
						Math.min(time[y][x] + map[y + dy[i]][x + dx[i]], time[y + dy[i]][x + dx[i]]);
			}
			
			if (time[N - 1][N - 1] != 100000) break;
		}
	}

	private static boolean isWall(int i, int j) {
		return i < 0 || i >= N || j < 0 || j >= N;
	}
}

/* 문제 이해
 	 도로 곳곳이 파손,
 	 S -> G 가기 위한 도로 복구 작업을 빠른 시간 내에 수핼
 	 도로가 파여진 깊이에 비례해서 복구 시간 증가
 	 
 	 S에서 G로 가는 경로 중 복구 시간이 가장 짧은 경로에 대한 총 복구 시간 구하기
 	 
 	 지도 정보에는 각 칸마다 파여진 도로의 깊이가 주어진다.
 	 이동하는 시간에 비해 복구하는 데 필요한 시간은 매우 크다
 	 (마치 weighted graph 같네요)
 	 이동은 상하좌우로 할 수 있다.
 	 
 	 지도의 크기는 최대 100 x 100
 	 
 	 어... 이걸 어떻게 완전 탐색으로 경로를 구하지?
 */