import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if (n > 2) n = (n-3) % 4 + 3;
        
        if (n % 2 == 0) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < c; i++)
                s.append("O");
            for (int i = 0; i < r; i++)
                sb.append(s).append("\n");
            System.out.println(sb);
            return ;
        }

        int[][] count = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == 'O')
                    count[i][j] = 3;
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int sec = 1;

        while(sec <= n) {
            /** sec 동안 **/
            // 폭탄 세팅, 초 count
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (sec % 2 == 0 && count[i][j] == 0)
                        count[i][j] = 3;
                    else if (count[i][j] > 0) {
                        count[i][j]--;
                        // 폭발 대상 체크
                        if (count[i][j] == 0) {
                            x.add(i);
                            y.add(j);
                        }
                    }
                }
            }

            /** sec 후 **/
            // 폭발
            for (int i = 0; i < x.size(); i++) {
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x.get(i) + dx[dir];
                    int ny = y.get(i) + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                    count[nx][ny] = 0;
                }
            }
            sec++;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (count[i][j] > 0)
                    sb.append("O");
                else
                    sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
