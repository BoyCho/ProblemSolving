#include <iostream>

using namespace std;

int main()
{
	int T,N;

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> T;
	while (T) {
		int d[11] = { 0 };
		cin >> N;

		d[1] = 1;
		d[2] = 2;
		d[3] = 4;

		for (int i = 4; i <= N; i++) {
			d[i] += d[i - 1];
			d[i] += d[i - 2];
			d[i] += d[i - 3];
		}
		cout << d[N] << endl;
		T--;
	}
}