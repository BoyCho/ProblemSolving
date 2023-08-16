import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        init();
        divide(0, 0, N);
        print();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    public static void divide(int x, int y, int size) {
        if (size == 1) {
            sb.append(map[x][y]);
            return;
        }

        boolean onlyZero = true;
        boolean onlyOne = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] == 1) onlyZero = false;
                if (map[i][j] == 0) onlyOne = false;
            }
        }

        if (onlyZero) {
            sb.append(0);
            return;
        }

        if (onlyOne) {
            sb.append(1);
            return;
        }

        sb.append("(");
        divide(x, y, size / 2);
        divide(x, y + size / 2, size / 2);
        divide(x + size / 2, y, size / 2);
        divide(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    public static void print() {
        System.out.println(sb);
    }
}
