import java.util.*;

class Sort5 {
    public int solution(int[][] board){
        List<Integer> x = new LinkedList<>();
        List<Integer> y = new LinkedList<>();
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(y);

        int xm = x.get(x.size() / 2);
        int ym = y.get(y.size() / 2);
        int answer = 0;

        for (int i : x) answer += Math.abs(xm - i);
        for (int i : y) answer += Math.abs(ym - i);

        return answer;
    }

    public static void main(String[] args){
        Sort5 T = new Sort5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}