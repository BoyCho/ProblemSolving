#include<iostream>

using namespace std;

int d[1000001];
int main()
{
	int N;
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;

	d[1] = 0;
	for (int i = 2; i <= N; i++) {
		d[i] = d[i - 1] + 1;
		if (!(i % 3)) d[i] = min(d[i], d[i / 3] + 1);
		if (!(i % 2)) d[i] = min(d[i], d[i / 2] + 1);
	}
	cout << d[N];
}