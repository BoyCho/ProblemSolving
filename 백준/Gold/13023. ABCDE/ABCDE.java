import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans = 0;
    static boolean[] vis;
    static List<Integer>[] friends;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        friends = new ArrayList[N];
        for (int i = 0; i < N; i++)
            friends[i] = new ArrayList<>();

        vis = new boolean[N];
        int a, b;

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (ans == 1) break;

            vis[i] = true;
            dfs(0, i);
            vis[i] = false;
        }

        System.out.println(ans);
    }

    static void dfs(int L, int t) {
        if (ans == 1) return;

        if (L == 4) {
            ans = 1;
            return;
        }

        for (int friend : friends[t]) {
            if (vis[friend]) continue;

            vis[friend] = true;
            dfs(L + 1, friend);
            vis[friend] = false;
        }
    }
}