#include <algorithm>
#include <iostream>
#include <tuple>
using namespace std;

tuple<int, int, int> lines[100001];
int p[1001];

int Find(int x) {
	if (p[x] == -1) return x;
	return p[x] = Find(p[x]);
}
bool Union(int a, int b) {
	a = Find(a); b = Find(b);
	if (a == b) return true;
	p[b] = a; return false;
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, m, ans = 0;
	cin >> n >> m;
	fill(p, p + n, -1);
	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		lines[i] = { c,a,b };
	}
	sort(lines, lines + m);
	for (int i = 0; i < m; i++) {
		int a, b, c;
		tie(c, a, b) = lines[i];
		if (Union(a, b)) continue;
		ans += c;
	}
	cout << ans;
}