import java.util.*;

class 비밀번호 {
    public int solution(int[] keypad, String password){
        int answer = 0;

        int[][] dist = new int[10][10];
        int[][] pad = new int[3][3];

        for (int[] d : dist) Arrays.fill(d, 2);
        for (int i = 0; i < 10; i++) dist[i][i] = 0;

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                pad[i][j] = keypad[k++];
        }

        int[] dx = {0,1,0,-1,-1,1,1,-1};
        int[] dy = {1,0,-1,0,1,1,-1,-1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int dir = 0; dir < 8; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                    int to = pad[nx][ny];
                    dist[from][to] = 1;
                }
            }
        }

        for (int i = 1; i < password.length(); i++)
            answer += dist[password.charAt(i-1) - '0'][password.charAt(i) - '0'];

        return answer;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}