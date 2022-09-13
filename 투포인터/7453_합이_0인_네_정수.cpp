#include <bits/stdc++.h>
using namespace std;

long long a[4000], b[4000], c[4000], d[4000];
vector<long long> ab, cd;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n, cnt = 0;
	
	cin >> n;

	for (int i = 0; i < n; i++) 
		cin >> a[i] >> b[i] >> c[i] >> d[i];
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ab.push_back(a[i] + b[j]);
			cd.push_back(c[i] + d[j]);
		}
	}

	sort(cd.begin(), cd.end());

	for (int i = 0; i < ab.size(); i++) {
		int abl = lower_bound(cd.begin(), cd.end(), -ab[i]) - cd.begin();
		int abu = upper_bound(cd.begin(), cd.end(), -ab[i]) - cd.begin();
		cnt += abu - abl;
	}
	cout << cnt;
}