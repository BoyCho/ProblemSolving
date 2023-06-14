#include <iostream>
#include <vector>

using namespace std;

int main() {
	vector<int> arr, res;
	int n, tmp;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		arr.push_back(tmp);
	}

	for (int i = arr.size() - 1; i >= 0; i--) {
		int j = 0;
		while(true){
			if (!arr[i]) {
				res.insert(res.begin() + j, i + 1);
				break;
			}
			if (i + 1 < res[j]) arr[i]--;
			j++;
		}
	}
	for (int itr : res) cout << itr << " ";
}