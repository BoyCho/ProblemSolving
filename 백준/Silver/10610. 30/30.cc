#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool cmp(char a, char b) {
	return a > b;
}
int main() {
	int sum = 0;
	string s;
	cin >> s;

	sort(s.begin(), s.end(), cmp);

	if (*(s.end() - 1) != '0') {
		cout << "-1";
		return 0;
	}

	for (int i = 0; i < s.size(); i++)
		sum += s[i] - '0';

	if (!(sum % 3))
		for (char itr : s) cout << itr;
	else 
		cout << "-1";
}