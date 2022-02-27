// 1248. [S/W 문제해결 응용] 3일차 - 공통조상 (70분)
package com.algo.day11.swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1248 {
	
	static int V;
	static int[][] edgeInfo;
	static int lowestCommonAncestor;
	static int subTreeSize;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/swea1248_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			V = sc.nextInt();
			edgeInfo = new int[V + 1][3];
			
			int E = sc.nextInt();
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			for (int i = 0; i < E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				
				if (edgeInfo[parent][0] == 0) {
					edgeInfo[parent][0] = child;
				}
				else if (edgeInfo[parent][0] != 0) {
					edgeInfo[parent][1] = child;
				}
				
				edgeInfo[child][2] = parent;
			}

			getLowestCommonAncestor(v1, v2);
			getSubTreeSize();
			
			System.out.printf("#%d %d %d%n", test_case, lowestCommonAncestor, subTreeSize);
		}
	}

	private static void getSubTreeSize() {
		subTreeSize = 0;
		
		int[] stack = new int[V + 1];
		int[] visited = new int[V + 1];
		int top = -1;
		stack[++top] = lowestCommonAncestor;
		int v;
		while (top > -1) {
			v = stack[top--];
			subTreeSize++;
			if (visited[v] == 0) {
				visited[v] = 1;
				for (int i = 0; i < 2; i++) {
					if (edgeInfo[v][i] != 0 && visited[edgeInfo[v][i]] == 0) {
						stack[++top] = edgeInfo[v][i];
					}
				}
			}
		}
	}

	private static void getLowestCommonAncestor(int v1, int v2) {
		lowestCommonAncestor = 0;
		
		int[] v1ToRoot = new int[V];
		int v1Distance = 0;
		int currentNode = v1;
		while (true) {
			if (edgeInfo[currentNode][2] == 0)	break;
			
			v1ToRoot[v1Distance] = edgeInfo[currentNode][2];
			currentNode = v1ToRoot[v1Distance++];
		}

		int[] v2ToRoot = new int[V];
		int v2Distance = 0;
		currentNode = v2;
		while (true) {
			if (edgeInfo[currentNode][2] == 0)	break;
			
			v2ToRoot[v2Distance] = edgeInfo[currentNode][2];
			currentNode = v2ToRoot[v2Distance++];
		}
	
		if (v1Distance == 0 || v2Distance == 0) {
			lowestCommonAncestor = 1;
		}
		else {
			loopOut:
			for (int i = 0; i < v1Distance; i++) {
				for (int j = 0; j < v2Distance; j++) {
					if (v1ToRoot[i] == v2ToRoot[j]) {
						lowestCommonAncestor = v1ToRoot[i];
						break loopOut;
					}
				}
			}			
		}
	}
}

/* 문제 이해
	두 정점의 공통 조상 중 가장 가까운 것 찾기 = 갈림길 찾기 (DFS 알고리즘 변형 같아)
	
	이진 트리가 주어지고 두 정점이 주어질 때 (두 정점이 서로 조상과 자손인 경우는 없다)
		1. 이들의 공통 조상 중 가장 가까운 정점(depth가 가장 높은 정점)을 찾고
		2. 그 정점을 루트로 하는 서브 트리의 크기를 알아내기
 */