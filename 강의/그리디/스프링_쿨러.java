import java.util.*;

class 스프링_쿨러 {
    public int solution(int n, int[] nums){
        int[][] line = new int[n + 1][2];
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            line[i][0] = Math.max(0, i - nums[i]);
            line[i][1] = Math.min(n, i + nums[i]);
        }

        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        int st = 0, en = 0, i = 0;
        while (i <= n) {
            while (i <= n && line[i][0] <= st) {
                if (en < line[i][1]) en = line[i][1];
                i++;
            }
            answer++;
            if (en == n) return answer;
            if (st == en) return -1;
            st = en;
        }
        return answer;
    }

    public static void main(String[] args){
        스프링_쿨러 T = new 스프링_쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}