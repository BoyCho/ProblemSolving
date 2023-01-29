#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// lower_idx�� upper_idx ã�� = ������ ��ġ�� ã�� �����̱⿡ len�� n-1�� �ƴ� n��

vector<int> c;
/*
// ���� �������� ������ �� �ִ� �ε��� ã��
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

// ���� ���������� ������ �� �ִ� �ε��� ã��
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