#include <iostream>
#include <algorithm>

using namespace std;

int R[1001], G[1001], B[1001];
int d[1001][3];

// 배열이 구분이 가능하면, 최대한 단순해지도록 쪼개자
int main()
{
	int n;

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;

	for (int i = 1; i <= n; i++) 
		cin >> R[i] >> G[i] >> B[i];
	
	d[1][0] = R[1];
	d[1][1] = G[1];
	d[1][2] = B[1];

	for (int i = 2; i <= n; i++) {
		d[i][0] = min(d[i - 1][1], d[i - 1][2]) + R[i];
		d[i][1] = min(d[i - 1][2], d[i - 1][0]) + G[i];
		d[i][2] = min(d[i - 1][0], d[i - 1][1]) + B[i];
	}

	cout << *min_element(d[n], d[n] + 3);
}