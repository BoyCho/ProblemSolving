#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main() {
	int cnt[10001] = {0};
	int n, tmp;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &tmp);
		++cnt[tmp];
	}
	for (int i = 1; i < 10001; i++) {
		while (cnt[i] > 0) {
			printf("%d\n", i);
			--cnt[i];
		}
	}
}