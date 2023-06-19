#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// lower_idx와 upper_idx 찾기 = 삽입할 위치를 찾는 것이기에, en이 len - 1이 아닌 len이다.

vector<int> c;

int main()
{
	int n, m, tmp;

	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> n;

	for (int i = 0; i < n; i++) { cin >> tmp; c.push_back(tmp); }
	sort(c.begin(), c.end());

	cin >> m;
	while (m--) {
		cin >> tmp;
		cout << upper_bound(c.begin(), c.end(), tmp) - lower_bound(c.begin(), c.end(), tmp) << " ";
	}
}