#include <algorithm>
#include <iostream>
#include <deque>

using namespace std;

#define HP first
#define R second

int n, k, cnt = 0, zeros = 0;
deque<pair<int,bool>> c;

void step1() {
	int tmp = c.back().HP; c.pop_back();
	c.push_front({ tmp, false });
	c[n - 1].R = false;
}

int step2() {
	int zeros = 0;
	for (int i = n - 1; i > 0; i--) {
		if (c[i - 1].R && !c[i].R && c[i].HP > 0) {
			c[i].HP--;
			c[i - 1].R = false; c[i].R = true;
			if (!c[i].HP) zeros++;
		}
	}
	c[n - 1].R = false;
	return zeros;
}

int step3() {
	if (!c.front().HP) return 0;
	c.front().R = true;
	c.front().HP--;
	return !c.front().HP ? 1 : 0;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n >> k;

	for (int i = 0; i < 2 * n; i++) {
		int tmp; cin >> tmp; c.push_back({ tmp, false });
	}

	while (k > zeros) {
		cnt++;
		step1();
		zeros += step2();
		zeros += step3();
	}
	cout << cnt;
}