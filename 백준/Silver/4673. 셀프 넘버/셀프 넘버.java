import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        int[] d = new int[10001];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 10000; i++) {
            if (d[i] != 0) continue;
            
            queue.add(i);
            
            while (!queue.isEmpty()) {
                int c = creater(queue.poll());

                if (c > 10000 || d[c] != 0) continue;

                d[c] = 1;
                queue.add(c);
            }
        }
        for (int i = 1; i <= 10000; i++) 
            if (d[i] == 0) sb.append(i + "\n");

        System.out.println(sb);
    }

    public static int creater(int n) {
        int n_ = n;
        while (n != 0) {
            n_ += n % 10;
            n /= 10;
        }
        return n_;
    }
}
