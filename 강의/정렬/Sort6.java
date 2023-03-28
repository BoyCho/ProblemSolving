import java.util.*;

class Sort6 {
    public int solution(int[] tasks, long k) {
        int[] sT = new int[tasks.length + 1];

        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);

        int rest = tasks.length;
        for (int i = 1; i < sT.length; i++) {
            long time = (long) (sT[i] - sT[i - 1]) * rest;
            if (k < time) {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[j] >= sT[i]) {
                        if (cnt++ == idx) return j + 1;
                    }
                }
            }
            k -= time;
            rest--;
        }
        return -1;
    }

    public static void main(String[] args){
        Sort6 T = new Sort6();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
