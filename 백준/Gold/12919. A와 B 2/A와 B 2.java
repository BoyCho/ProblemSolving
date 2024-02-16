import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static StringBuilder target = new StringBuilder();
    static String S, T;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        T = br.readLine();

        DFS(0, true, T);
        System.out.println(ans);
    }

    static void DFS(int n, boolean f, String str) {
        if (ans == 1 || str.length() < S.length()) {
            return;
        }
        if (str.length() == S.length()) {
            int i = 0;
            for (; i < str.length(); i++) {
                if (f) {
                    if (str.charAt(i) != S.charAt(i))
                        break;
                } else {
                    if (str.charAt(i) != S.charAt(S.length() - 1 - i))
                        break;
                }
            }
            if (i == str.length()) {
                ans = 1;
            }
            return;
        }
        if (f) {
            if (str.charAt(str.length() - 1) == 'A')
                DFS(n + 1, f, str.substring(0, str.length() - 1));
            if (str.charAt(0) == 'B')
                DFS(n + 1, !f, str.substring(1));
        } else {
            if (str.charAt(0) == 'A')
                DFS(n + 1, f, str.substring(1));
            if (str.charAt(str.length() - 1) == 'B')
                DFS(n + 1, !f, str.substring(0, str.length() - 1));
        }
    }
}