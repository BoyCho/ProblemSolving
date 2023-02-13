#include <algorithm>
#include <iostream>
#include <map>

using namespace std;
long long va[200005];
map<long long, long long> ma;
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	long long k, cnt = 0;
	int n;

	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		cin >> va[i];
		va[i] += va[i - 1];
		if (va[i] == k) cnt++;
	}
	for (int i = 1; i <= n; i++) {
		cnt += ma[va[i] - k];
		ma[va[i]]++;
	}
	cout << cnt;
}