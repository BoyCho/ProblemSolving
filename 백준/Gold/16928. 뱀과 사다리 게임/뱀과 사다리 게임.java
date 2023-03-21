import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> teleport = new HashMap<>();

        int[] dist = new int[101];

        int ladderSize = Integer.parseInt(st.nextToken());
        int snakeSize = Integer.parseInt(st.nextToken());
        int t = ladderSize + snakeSize;

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            teleport.put(a, b);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while(dist[100] == 0) {
            int cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int nCur = cur + i;
                if (nCur > 100) break;
                if (dist[nCur] != 0) continue;

                dist[nCur] = dist[cur] + 1;

                if (teleport.get(nCur) != null) {
                    int telCur = teleport.get(nCur);
                    if (dist[telCur] != 0) continue;
                    queue.add(telCur);
                    dist[telCur] = dist[cur] + 1;
                    continue;
                }
                queue.add(nCur);
            }
        }
        System.out.println(dist[100]);
    }
}
