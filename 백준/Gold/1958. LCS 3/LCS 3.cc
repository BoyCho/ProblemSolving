#include <bits/stdc++.h>

using namespace std;

int LCS[101][101][101];
string s[3];

int main()
{
	for (int i = 0; i < 3; i++) {
		cin >> s[i];
		s[i] = ' ' + s[i];
	}

	for (int i = 1; i < s[0].length(); i++) {
		for (int j = 1; j < s[1].length(); j++) {
			for (int k = 1; k < s[2].length(); k++) {
				if (s[0][i] == s[1][j] && s[1][j] == s[2][k])
					LCS[i][j][k] = LCS[i - 1][j - 1][k - 1] + 1;
				else
					LCS[i][j][k] = max(max(LCS[i][j][k - 1], LCS[i][j - 1][k]), LCS[i - 1][j][k]);
				
			}
		}
	}
	cout << LCS[s[0].length() - 1][s[1].length() - 1][s[2].length() - 1];
}