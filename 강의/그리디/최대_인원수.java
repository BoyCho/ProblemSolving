import java.util.*;

class 최대_인원수 {
    public int solution(int n, int[][] trains, int[][] bookings){
        int answer = 0;
        int[] sum = new int[n + 1];

        for (int[] train: trains) {
            sum[train[0]] += train[2];
            sum[train[1]] -= train[2];
        }

        for (int i = 1; i <= n; i++)
            sum[i] += sum[i-1];

        Arrays.sort(bookings, (o1, o2) -> o1[0] - o2[0]);

        LinkedList<Integer> list = new LinkedList<>();

        for (int station = 1, i = 0; station <= n; station++) {
            while (!list.isEmpty() && list.peek() == station) {
                list.poll();
                answer++;
            }

            while (i < bookings.length && station == bookings[i][0])
                list.add(bookings[i++][1]);

            list.sort((o1, o2) -> o1 - o2);

            while (list.size() > sum[station])
                list.pollLast();
        }
        return answer;
    }

    public static void main(String[] args){
        최대_인원수 T = new 최대_인원수();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}