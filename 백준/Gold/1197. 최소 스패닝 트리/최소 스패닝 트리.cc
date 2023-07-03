#include <algorithm>
#include <iostream>
#include <tuple>

using namespace std;

tuple<int, int, int> edge[100001];
int p[10001];

int Find(int x) {
	if (x == p[x]) return x;
	return p[x] = Find(p[x]);
}
bool Union(int a, int b) {
	int pa = Find(a);
	int pb = Find(b);
	if (pa == pb) return 1;
	p[pa] = pb; return 0;
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	int v, e, ans = 0;

	cin >> v >> e;
	while (v--) p[v] = v;
	for (int i = 0; i < e; i++) {
		int a, b, c;
		cin >> a >> b >> c; edge[i] = { c,a,b };
	}
	sort(edge, edge + e);
	for (int i = 0; i < e; i++) {
		int a, b, c;
		tie(c, a, b) = edge[i];
		if (Union(a, b)) continue;
		ans += c;
	}
	cout << ans;
	return 0;
}