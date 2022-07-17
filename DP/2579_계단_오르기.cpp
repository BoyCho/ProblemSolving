#include <iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int d[301][2] = { 0 };
	int S[301];
	int n;

	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> S[i];

	d[1][1] = S[1];
	d[2][1] = S[2];
	d[2][2] = d[1][1] + S[2];

	for (int i = 3; i <= n; i++) {
		d[i][1] = max(d[i - 2][1], d[i - 2][2]) + S[i];
		d[i][2] = d[i - 1][1] + S[i];
	}

	cout << max(d[n][1], d[n][2]);
}