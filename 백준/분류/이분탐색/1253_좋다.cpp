#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	long long x[2005] = { 0 };
	int n, cnt = 0;

	cin >> n;
	for (int i = 0; i < n; i++) cin >> x[i];

	sort(x, x + n);

	if (n < 3) { cout << cnt; return 0; }
	if (!x[0] && !x[2]) cnt++;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j) continue;
			int low = lower_bound(x, x + n, x[i] - x[j]) - x;

			if (low == j || low == i)continue;
			if (x[low] + x[j] == x[i]) {
				cnt++; break;
			}
		}
	}
	cout << cnt;
}