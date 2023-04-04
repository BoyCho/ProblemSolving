import java.util.*;
class 바둑대회 {
    int[][] cans;
    int[] isUsed;
    int n, answer;

    public int solution(int[][] cans_){
        cans = cans_; n = cans.length;
        isUsed = new int[n];
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        return answer;
    }

    void dfs (int d, int s) {
        if (d == n / 2) {
            List<Integer> white = new ArrayList<>();
            List<Integer> black = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (isUsed[i] == 1) white.add(i);
                else black.add(i);
            }

            int wh = 0, bl = 0;
            for (int i = 0; i < d; i++) {
                wh += cans[white.get(i)][0];
                bl += cans[black.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(wh - bl));
            return;
        }

        for (int i = s; i < n; i++) {
            isUsed[i] = 1;
            dfs(d + 1, i + 1);
            isUsed[i] = 0;
        }
    }

    public static void main(String[] args){
        바둑대회 T = new 바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
