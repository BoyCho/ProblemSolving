#include <iostream>
#include <string>

using namespace std;

int main() {
	string s;
	int sum = 0;
	bool t = true;

	cin >> s;

	for (int i = 1, j = 0; i <= s.size(); i++) {
		if (s[i] == '+' || s[i] == '-' || i == s.size()) {
			if (t) {
				sum += stoi(s.substr(j, i));
				if (s[i] == '-') t = false;
			}
			else sum -= stoi(s.substr(j, i));
			j = i + 1;
		}
	}
	cout << sum;
}