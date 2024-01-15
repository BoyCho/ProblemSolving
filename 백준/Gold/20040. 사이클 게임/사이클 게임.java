import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N, M;
    static int[] P;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        P = new int[N];

        for (int i = 0; i < N; i++)
            P[i] = i;

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (Find(a) == Find(b)) {
                System.out.println(i + 1);
                return;
            }
            Union(a, b);
        }
        System.out.println("0");
    }

    static int Find(int a) {
        if (P[a] == a) return a;
        return P[a] = Find(P[a]);
    }

    static void Union(int a, int b) {
        int pa = Find(a);
        int pb = Find(b);

        if (pa == pb) return;
        P[pa] = pb;
    }
}