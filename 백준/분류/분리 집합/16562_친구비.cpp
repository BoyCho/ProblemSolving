#include <algorithm>
#include <iostream>
#include <map>

using namespace std;

map<int, int> parent;
int f[10005];
long long ans = 0;

int Find(int x) {
	if (x == parent[x]) return x;
	return parent[x] = Find(parent[x]);
}
void Union(int v, int w) {
	int pv = Find(v);
	int pw = Find(w);
	if (pv == pw) return;
	f[pv] < f[pw] ? parent[pw] = pv : parent[pv] = pw;
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, m, k;
	
	cin >> n >> m >> k;
	for (int i = 1; i <= n; i++) {
		cin >> f[i]; parent[i] = i;
	}

	while (m--) {
		int v, w;
		cin >> v >> w;
		Union(v, w);
	}
	for (int i = 1; i <= n; i++) {
		if (i == parent[i]) ans += f[i];
	}
	if (ans > k) cout << "Oh no";
	else cout << ans;
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