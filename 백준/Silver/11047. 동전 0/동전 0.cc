#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n, k, tmp, result = 0;
	vector<int> coin;
	scanf("%d %d", &n, &k);

	for (int i = 0; i < n; i++) {
		scanf("%d", &tmp);
		coin.push_back(tmp);
	}

	for (int i = coin.size() - 1; i >= 0; i--) {
		result += k / coin[i];
		k %= coin[i];
	}

	printf("%d\n", result);
}