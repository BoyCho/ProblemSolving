import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int[] Parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        Parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            Parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (type == 0) {
                Union(a, b);
            } else {
                if (Find(a) == Find(b))
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void Union(int a, int b) {
        int pa = Find(a);
        int pb = Find(b);

        if (pa != pb)
            Parent[pa] = pb;
    }

    static int Find(int a) {
        if (a == Parent[a]) return a;
        return Parent[a] = Find(Parent[a]);
    }
}