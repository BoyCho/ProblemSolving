#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// lower_idx와 upper_idx 찾기 = 삽입할 위치를 찾는 관점이기에 len이 n-1이 아닌 n임

vector<int> c;
/*
// 가장 왼쪽으로 삽입할 수 있는 인덱스 찾기
int lower_idx(int target, int len) {
	int st = 0;
	int en = len;
	int mid;

	while (st < en) {
		mid = (st + en) / 2;
		if (c[mid] < target) st = mid + 1;
		else en = mid;
	}
	return st;
}

// 가장 오른쪽으로 삽입할 수 있는 인덱스 찾기
int upper_idx(int target, int len) {
	int st = 0;
	int en = len;
	int mid;

	while (st < en) {
		mid = (st + en) / 2;
		if (c[mid] > target) en = mid;
		else st = mid + 1;
	}
	return st;
}
*/
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