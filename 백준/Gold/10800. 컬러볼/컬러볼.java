import java.io.*;
import java.util.*;

public class Main {
    public static class Ball {
        int idx, color, size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Ball[] balls = new Ball[n];
        for(int i = 0; i < n; i++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, c, s);
        }
        Arrays.sort(balls, (o1, o2) -> o1.size - o2.size);

        int[] result = new int[n];
        int[] colors = new int[n + 1];
        int ball_idx = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            Ball current = balls[i];
            while(balls[ball_idx].size < current.size) {
                sum += balls[ball_idx].size;
                colors[balls[ball_idx].color] += balls[ball_idx].size;
                ball_idx++;
            }
            result[current.idx] = sum - colors[current.color];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}