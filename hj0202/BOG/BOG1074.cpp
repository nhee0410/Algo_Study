#include <iostream>
#include <cmath>
using namespace std;

int solveZ(int depth, int r, int c)
{
	if (depth - 1 < 0)
		return 1;

	int n = pow(2, depth);
	int nHalf = pow(2, depth - 1);

	// 1 area
	if (0 <= r && r < nHalf && 0 <= c && c < nHalf)
		return solveZ(depth - 1, r, c);

	// 2 area
	else if (0 <= r && r < nHalf && nHalf <= c && c < n)
		return nHalf * nHalf + solveZ(depth - 1, r, c - nHalf);

	// 3 area
	else if (nHalf <= r && r < n && 0 <= c && c < nHalf)
		return 2 * nHalf * nHalf + solveZ(depth - 1, r - nHalf, c);

	// 4 area
	else if (pow(2, depth - 1) <= r && r < n && nHalf <= c && c < n)
		return 3 * nHalf * nHalf + solveZ(depth - 1, r - nHalf, c - nHalf);

	return 0;
}

int main()
{
	int N, r, c;
	cin >> N >> r >> c;

	int result = solveZ(N, r, c) - 1;
	cout << result;
}
