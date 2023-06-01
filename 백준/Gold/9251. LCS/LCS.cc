#include <algorithm>
#include <iostream>
using namespace std;

int d[1001][1001];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string a, b;
	cin >> a >> b;
	
	int as, bs;

	a = ' ' + a; as = a.size();
	b = ' ' + b; bs = b.size();

	for (int i = 1; i < as; i++) {
		for (int j = 1; j < bs; j++) {
			if (a[i] == b[j]) d[i][j] = d[i - 1][j - 1] + 1;
			else d[i][j] = max(d[i][j - 1], d[i - 1][j]);
		}
	}
	cout << d[as - 1][bs - 1];
}