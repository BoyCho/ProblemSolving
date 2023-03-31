//CPU 스케쥴링
import java.util.*;
class CPU_스케쥴링 {

    public int[] solution(int[][] tasks){
        // tasks -> [작업번호][호출시간,실행시간]
        // 초 마다 대기 상태에서 선별이 필요함 -> 우선순위큐
        int n = tasks.length;
        int[] answer = new int[n];

        LinkedList<int[]> taskL = new LinkedList<>();
        for (int i = 0; i < n; i++)
            taskL.add(new int[] {tasks[i][0], tasks[i][1], i});

        taskL.sort((t1, t2) -> t1[0] - t2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> t1[1] == t2[1] ? t1[0] - t2[0] : t1[1] - t2[1]);
        // idx = 0: 작업번호, 1: 실행시간

        int t = 0, i = 0;
        while (!taskL.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()) t = Math.max(taskL.peekFirst()[0], t);

            while (!taskL.isEmpty() && taskL.peekFirst()[0] <= t) {
                pq.add(new int[]{taskL.peekFirst()[2], taskL.peekFirst()[1]});
                taskL.pollFirst();
            }

            if (!pq.isEmpty()) {
                int[] process = pq.poll();
                answer[i++] = process[0];
                t += process[1];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        CPU_스케쥴링 T = new CPU_스케쥴링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}