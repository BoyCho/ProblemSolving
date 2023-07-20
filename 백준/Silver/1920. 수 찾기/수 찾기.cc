#include <algorithm>
#include <iostream>

using namespace std;

int A[100001];
int n;
/*
int binarySearch(int target) {
	int st = 0;
	int en = n - 1;

	while (st <= en) {
		int mid = (st + en) / 2;
		
		if (target < A[mid]) en = mid - 1;
		else if (target > A[mid]) st = mid + 1;
		else return 1;
	}
	return 0;
}
*/
int main()
{
	int m;

	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> n;

	for (int i = 0; i < n; i++) cin >> A[i];
	sort(A, A + n);

	cin >> m;
	while (m--) {
		int t;
		cin >> t;
		cout << binary_search(A, A + n, t) << '\n';;
	}
}