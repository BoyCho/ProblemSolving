#include <algorithm>
#include <iostream>
using namespace std;

long long s, sum;
int n, mn = 100001;
int arr[100000];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n >> s;
	for (int i = 0; i < n; i++) cin >> arr[i];

	int st = 0, en = 0;
	for (sum = arr[st]; st < n; st++) {
		while (en < n && sum < s) {
			en++;
			if (en != n) sum += arr[en];
		}
		if (en == n) break;
		mn = min(mn, en - st + 1);
		sum -= arr[st];
	}
	if (mn == 100001) {
		cout << 0; return 0;
	}
	cout << mn; return 0;
}