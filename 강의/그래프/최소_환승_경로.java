import java.util.*;
class 최소_환승_경로 {
    public int solution(int[][] routes, int s, int e){
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int route : routes[i]) {
                map.putIfAbsent(route, new HashSet<>());
                map.get(route).add(i);
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        int[] vis = new int[routes.length];

        Q.add(s);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int cur = Q.poll();

                for (int line : map.get(cur)) {
                    if (vis[line] == 1) continue;
                    vis[line] = 1;

                    for (int route : routes[line]) {
                        if (route == e) return L;
                        Q.offer(route);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        최소_환승_경로 T = new 최소_환승_경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}