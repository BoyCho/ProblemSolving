import java.util.*;

class 가장_많이_사용된_회의실 {
    public int solution(int n, int[][] meetings){
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);

        TreeSet<Integer> rooms = new TreeSet<>();    // 남은 방, 삽입/제거 시 정렬용, O(logN) - HashSet 보다 느리지만 정렬 가능
        for (int i = 0; i < n; i++) rooms.add(i);

        PriorityQueue<int[]> used = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        // < 방 넘버, 끝나는 시간 >
        int[] cnt = new int[n];

        for (int[] m : meetings) {
            while (!used.isEmpty() && used.peek()[1] <= m[0]) rooms.add(used.poll()[0]);

            if (rooms.isEmpty()) {
                int[] usedState = used.poll();
                cnt[usedState[0]]++;
                used.add(new int[]{usedState[0], usedState[1] + (m[1] - m[0])});
                continue;
            }
            int room = rooms.pollFirst();
            cnt[room]++;
            used.add(new int[]{room, m[1]});
        }

        int answer = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        가장_많이_사용된_회의실 T = new 가장_많이_사용된_회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}