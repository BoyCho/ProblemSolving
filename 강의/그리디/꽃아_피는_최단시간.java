import java.util.*;

class 꽃아_피는_최단시간 {
    public int solution(int[] plantTime, int[] growTime){
        int n = plantTime.length;
        int[][] pg = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pg[i][0] = plantTime[i];
            pg[i][1] = growTime[i];
        }

        Arrays.sort(pg, (a, b) -> b[1] - a[1]);

        int plantPt = 0;
        for (int i = 0; i < n; i++) {
            plantPt += pg[i][0];
            answer = Math.max(answer, plantPt + pg[i][1]);
        }

        return answer;
    }

    public static void main(String[] args){
        꽃아_피는_최단시간 T = new 꽃아_피는_최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}