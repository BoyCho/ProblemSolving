#include <algorithm>
#include <iostream>
#include <vector>


using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	vector<int> two;
	int x[1005] = { 0 };
	int n;

	cin >> n;
	for (int i = 0; i < n; i++) cin >> x[i];

	sort(x, x + n);
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++)
			two.push_back(x[i] + x[j]);
	}

	sort(two.begin(), two.end());
	for (int i = n - 1; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (binary_search(two.begin(), two.end(), x[i] - x[j])) {
				cout << x[i];
				return 0;
			}
		}
	}
}