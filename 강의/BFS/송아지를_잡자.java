import java.util.*;

class 송아지를_잡자 {
    public int solution (int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        int[][] vis = new int[200001][2];

        vis[s][0] = 1;
        q.add(s);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            L++;

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for (int nCur : new int[]{cur * 2, cur + 1, cur - 1}) {
                    if (nCur < 0 || nCur > 200000 || vis[nCur][L % 2] == 1) continue;
                    vis[nCur][L % 2] = 1;
                    q.offer(nCur);
                }
            }
            e += L;
            if (e > 200000) return -1;
            if (vis[e][L % 2] == 1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        송아지를_잡자 T = new 송아지를_잡자();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}