class 잃어버린_강아지 {
    public int solution(int[][] board){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int t = 0, dh = 0, dg = 0;

        int[] human = null, dog = null;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) human = new int[]{i, j};
                if (board[i][j] == 3) dog = new int[]{i, j};
                if (human != null && dog != null) break;
            }
        }

        while (t++ < 10000) {
            int[] nh = new int[]{human[0] + dx[dh], human[1] + dy[dh]};
            int[] nd = new int[]{dog[0] + dx[dg], dog[1] + dy[dg]};
            boolean fh = true, fd = true;

            if (nh[0] < 0 || nh[1] < 0 || nh[0] >= 10 || nh[1] >= 10 || board[nh[0]][nh[1]] == 1) {
                dh = (dh + 1) % 4;
                fh = false;
            }
            if (nd[0] < 0 || nd[1] < 0 || nd[0] >= 10 || nd[1] >= 10 || board[nd[0]][nd[1]] == 1) {
                dg = (dg + 1) % 4;
                fd = false;
            }
            if (fh) human = nh;
            if (fd) dog = nd;

            if (human[0] == dog[0] && human[1] == dog[1]) return t;
        }
        return 0;
    }

    public static void main(String[] args){
        잃어버린_강아지 T = new 잃어버린_강아지();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}