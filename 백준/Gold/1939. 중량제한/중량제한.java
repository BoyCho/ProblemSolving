import java.util.*;
import java.io.*;

public class Main {

    static class Bridge {
        int a, b, cost;

        Bridge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static Bridge[] bridgeList;
    static int[] parent, rank;
    static int n, m, max;
    static int stFactory, enFactory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        max = 0;

        bridgeList = new Bridge[m];

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bridgeList[i] = new Bridge(a,b,c);
            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine());

        stFactory = Integer.parseInt(st.nextToken());
        enFactory = Integer.parseInt(st.nextToken());

        //binary-search
        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(right);
    }

    static boolean check(int cost) {
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            if (bridgeList[i].cost >= cost)
                union(bridgeList[i].a, bridgeList[i].b);
        }
        return find(stFactory) == find(enFactory);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) return;

        if (rank[x] > rank[y])
            parent[y] = x;
        if (rank[x] < rank[y])
            parent[x] = y;
        if (rank[x] == rank[y]) {
            parent[y] = x;
            rank[x]++;
        }
    }

    static int find(int ch) {
        if (ch == parent[ch])
            return ch;
        return parent[ch] = find(parent[ch]);
    }

}