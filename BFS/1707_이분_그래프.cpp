#include <bits/stdc++.h>
using namespace std;

vector<int> node[20001];
map<int, bool> uni;
bool vis[20001];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	while (n--) {
		bool flag = false;
		int v, e, a, b;
		cin >> v >> e;

		while (e--) {
			cin >> a >> b;
			node[a].push_back(b);
			node[b].push_back(a);
		}

		for (int i = 1; i <= v; i++) {
			if (node[i].empty() || vis[i]) continue;

			queue<int> q;
			q.push(i);
			vis[i] = uni[i] = true;

			while (!q.empty()) {
				int cur = q.front(); q.pop();

				for (int i = 0; i < node[cur].size(); i++) {
					int cur2 = node[cur][i];

					if (vis[cur2]) {
						if (uni[cur2] == uni[cur]) {
							flag = true; break;
						}
						continue;
					}
					q.push(cur2);
					vis[cur2] = true;
					uni[cur2] = !uni[cur];
				}
				if (flag) break;
			}
			if (flag) break;
		}
		if (flag) cout << "NO\n";
		else cout << "YES\n";

		flag = false;
		for (int i = 1; i <= v; i++) {
			node[i].clear();
			uni[i] = vis[i] = false;
		}
	}
}