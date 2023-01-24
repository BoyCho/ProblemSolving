#include <algorithm>
#include <iostream>
using namespace std;

int lcs(string a, string b) {
	int as = a.size(), bs = b.size();
	if (!as || !bs) return 0;

	if (a.back() == b.back()) return lcs({ a.begin(), a.end() - 1 }, { b.begin(), b.end() - 1 }) + 1;
	return max(lcs(a, { b.begin(), b.end() - 1 }), lcs({ a.begin(), a.end() - 1 }, b));
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string a, b;
	cin >> a >> b;
	cout << lcs(a, b);
}