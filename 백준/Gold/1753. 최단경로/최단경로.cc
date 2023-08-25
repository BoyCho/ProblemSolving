#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define X first
#define Y second

vector<pair<int, int>> adj[20001];
//		   <비용, 정점>
const int INF = 1e9 + 10;
int d[20001];
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	int v, e, st;

	cin >> v >> e >> st;

	fill(d, d + v + 1, INF);

	while (e--) {
		int u, v, w;
		cin >> u >> v >> w;
		adj[u].push_back({ w,v });
	}

	d[st] = 0;
	pq.push({ d[st],st });

	while (!pq.empty()) {
		pair<int,int> cur = pq.top(); pq.pop();
		if (cur.X != d[cur.Y]) continue;

		for (pair<int,int> nxt : adj[cur.Y]) {
			if (d[nxt.Y] <= nxt.X + d[cur.Y]) continue;
			d[nxt.Y] = nxt.X + d[cur.Y];
			pq.push({ d[nxt.Y], nxt.Y });
		}
	}

	for (int i = 1; i <= v; i++) {
		if (d[i] == INF) cout << "INF" << "\n";
		else cout << d[i] << "\n";
	}
}