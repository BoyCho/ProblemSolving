import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                minQueue.add(input);
            } else {
                if (!minQueue.isEmpty()) {
                    sb.append(minQueue.poll()).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}