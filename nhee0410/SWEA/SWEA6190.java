package com.algo.practice.swea;

import java.util.Scanner;

public class SWEA6190 {
	
	static int[] A = new int[1000];
	static String str;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			int maxMonoIncNum = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					str = new String(Integer.toString(A[i] * A[j]));
					if (isMonoIncrese() && maxMonoIncNum < A[i] * A[j]) {
						maxMonoIncNum = A[i] * A[j];
					}
				}
			}
			
			// 오답의 원인 : %n 를 적지 않음...^ㅁ^
			System.out.printf("#%d %d%n", test_case, maxMonoIncNum);
		}
	}

	private static boolean isMonoIncrese() {
		
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) > str.charAt(i + 1)) 
			{
				return false;
			}
		}
		
		return true;
	}
}

// 오답 (이것만 두 번째...ㅎ)
// 채점용 input 파일로 채점한 결과 fail 입니다.
// (오답 : 50개의 테스트케이스 중 0개가 맞았습니다.)


/* 문제 이해
	단조 증가하는 수 = 각 숫자의 자릿수가 단순하게 증가 하는 수
	d1 <= d2 <= ... <= dk를 만족하면 단조 증가하는 수이다.
	
	양의 정수 A1, ... An이 주어진다.
	1 <= i <= j <= N인 두 i, j에 대해 Ai x Aj값이 단조 증하는 수인 거을 구하고
	(N x logN개의 수가 나올 수 있다.)
	한 정수의 최댓값은 30000인데 Ai x Aj의 최댓값은 9 x 10^8으로 int 최댓값을 넘기지 않는다.
 */
