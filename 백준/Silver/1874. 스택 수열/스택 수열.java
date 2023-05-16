import java.util.*;
import java.io.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        int cur = 1;

        while (N-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if ( cur > target && !st.empty() && target < st.peek()) {
                System.out.println("NO\n");
                return;
            }
            while (st.empty() || st.peek() < target) {
                st.push(cur++);
                sb.append("+").append("\n");
            }
            if (!st.empty() && st.peek() == target) {
                st.pop();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}

