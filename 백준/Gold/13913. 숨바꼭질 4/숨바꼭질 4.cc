#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int T[100002];
int pre[100002];

int main()
{
	queue<int> Q;
	int n, k;

	fill(pre, pre + 100001, -1);

	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> n >> k;

	if (n >= k) {
		cout << n - k << endl;
		while (n >= k) cout << n-- << " ";
		return 0;
	}

	Q.push(n);

	while (!T[k]) {
		int x = Q.front(); Q.pop();

		for (int nxt : {x - 1, x + 1, x * 2}) {

			if (nxt < 0 || nxt > 100000) continue;
			if (T[nxt] > 0) continue;

			T[nxt] = T[x] + 1;
			pre[nxt] = x;

			Q.push(nxt);
		}
	}

	cout << T[k] << endl;

	stack<int> s;
	s.push(k);

	while (k != n) {
		s.push(pre[k]);
		k = pre[k];
	}

	while (!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}
}