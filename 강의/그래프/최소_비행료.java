import java.util.*;
class 최소_비행료 {
    public int solution(int n, int[][] flights, int s, int e, int k){
        List<List<int[]>> graph = new ArrayList<>();
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] f : flights)
            graph.get(f[0]).add(new int[]{f[1], f[2]});

        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{s, 0});
        costs[s] = 0;

        while (!Q.isEmpty() && k-- >= 0) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                int now = cur[0];
                int nowCost = cur[1];

                for (int[] f : graph.get(now)) {
                    int next = f[0];
                    int cost = f[1];
                    if (nowCost + cost < costs[f[0]]) {
                        costs[next] = nowCost + cost;
                        Q.add(new int[]{next, costs[next]});
                    }
                }
            }
        }
        return costs[e] == Integer.MAX_VALUE ? -1 : costs[e];
    }

    public static void main(String[] args){
        최소_비행료 T = new 최소_비행료();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}