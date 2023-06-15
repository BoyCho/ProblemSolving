#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	vector<vector<int>> arr;
	int n, m, result = 0, tmp[2], min = 100001;
	cin >> n;

	while (n) {
		cin >> m;
		for (int i = 0; i < m; i++) {
			cin >> tmp[0] >> tmp[1];
			arr.push_back({ tmp[0], tmp[1] });
		}
		sort(arr.begin(), arr.end());
		for (int i = 0; i < arr.size(); i++)
			if (min > arr[i][1]) {
				min = arr[i][1];
				result++;
			}
		printf("%d\n", result);
		arr.clear();
		result = 0;
		min = 100001;
		n--;
	}
}