class Solution {

    boolean[][] relation;
    boolean[] isUsed;
    int[] arr;
    int answer;

    public int solution(int[][] fight){
        relation = new boolean[8][8];
        isUsed = new boolean[8];
        arr = new int[9];   // zero padding
        answer = 0;

        for (int[] list : fight) {
            int a = list[0], b = list[1];
            relation[a][b] = relation[b][a] = true;
        }
        dfs(1);
        return answer;
    }

    void dfs(int n) {
        if (n == 8) {
            answer++;
            return;
        }
        for (int i = 1; i <= 7; i++) {
            if (isUsed[i] || relation[arr[n - 1]][i]) continue;

            arr[n] = i;
            isUsed[i] = true;
            dfs(n + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
