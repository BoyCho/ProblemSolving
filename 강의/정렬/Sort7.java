import java.util.*;

class Sort7 {
    public int solution(int[][] meetings){
        int answer = 0;
        List<int[]> list = new ArrayList<>();

        for (int[] meeting: meetings) {
            list.add(new int[]{meeting[0], 1});
            list.add(new int[]{meeting[1], 2});
        }

        list.sort((int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int cnt = 0;
        for (int[] check : list) {
            if (check[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Sort7 T = new Sort7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}