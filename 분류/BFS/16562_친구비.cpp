#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> flist[10002];
bool isf[10002];
int f[10002];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	queue<int> q;
	int n, m, k, ans = 0;
	
	cin >> n >> m >> k;
	for (int i = 1; i <= n; i++) cin >> f[i];

	while (m--) {
		int v, w;
		cin >> v >> w;
		flist[v].push_back(w);
		flist[w].push_back(v);
	}
	
	for (int i = 1; i <= n; i++) {
		if (isf[i]) continue;
		int minmoney = 10001;

		minmoney = min(f[i], minmoney);
		isf[i] = true;
		q.push(i);

		while (!q.empty()) {
			int cur = q.front(); q.pop();
			minmoney = min(f[cur], minmoney);

			for (int j = 0; j < flist[cur].size(); j++) {
				int frnd = flist[cur][j];
				if (isf[frnd]) continue;
				isf[frnd] = true;
				q.push(frnd);
			}
		}
		ans += minmoney;
	}
	if (ans <= k) cout << ans;
	else cout << "Oh no";
}
/*h
3 2 100
10 5 7
1 3
2 3

3 3 100
1 2 3
1 2
2 1
1 2

3 3 100
1 2 3
1 2
2 3
1 2

3 3 100
1 2 3
1 1
2 2
3 3

3 3 100
1 2 3
1 1
1 1
1 2

2 0 10000000
10000000 1

2 0 10000000
9999999 1
*/