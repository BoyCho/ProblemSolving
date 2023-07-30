import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		Queue<Integer> Q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++)
			Q.offer(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(!Q.isEmpty()) {
			int cnt = K - 1;
			while(cnt-- > 0) {
				Q.offer(Q.poll());
			}
			sb.append(Q.poll()).append(", ");
		}
		
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}