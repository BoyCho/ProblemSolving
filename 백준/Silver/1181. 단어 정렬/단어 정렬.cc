#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool cmp(string a, string b) {
	return a.length() == b.length() ? a < b : (a.length() > b.length() ? 0 : 1);
}

int main() {
	vector<string> arr;
	string tmp;
	int n;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> tmp;
		arr.push_back(tmp);
	}
	
	sort(arr.begin(), arr.end(), cmp);

	for (int i = 0; i < arr.size(); i++) {
		if (i != 0 && arr[i] == arr[i - 1]) continue; 
		cout << arr[i] << endl;
	}
}