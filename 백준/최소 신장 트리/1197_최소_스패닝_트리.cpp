#include <iostream>
#include <tuple>
#include <queue>
using namespace std;

int parent[10001];

int Find(int x) {
	if (x == parent[x]) return x;
	return parent[x] = Find(parent[x]);
}
bool Union(int a, int b) {
	int pa = Find(a);
	int pb = Find(b);
	if (pa == pb) return 1;
	parent[pa] = pb; return 0;
}
int main()
{
	priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<tuple<int, int, int>>> pq;
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	int v, e, ans = 0;

	cin >> v >> e;
	while (v--) parent[v] = v;
	while (e--) {
		int a, b, c;
		cin >> a >> b >> c;
		pq.push({ c,a,b });
	}
	while (!pq.empty()) {
		auto cur = pq.top(); pq.pop();
		if (Union(get<1>(cur), get<2>(cur))) continue;
		ans += get<0>(cur);
	}
	cout << ans;
}