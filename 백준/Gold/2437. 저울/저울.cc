#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, target = 1;
	int a[1001];

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];

	sort(a, a + n);

	for (int i = 0; i < n; i++) {
		if (target < a[i]) break;
		target += a[i];
	}
	cout << target;
}