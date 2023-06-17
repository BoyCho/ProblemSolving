#include <iostream>

using namespace std;

int main() {
	int n, cnt = 0, res = 5000;
	cin >> n;

	for (int i = n / 5; i >= 0; i--) {
		if (!((n - i * 5) % 3)) {
			cnt = i + (n - i * 5) / 3;
			if (cnt < res)
				res = cnt;
		}
	}
	if (res == 5000) cout << "-1";
	else cout << res;
}