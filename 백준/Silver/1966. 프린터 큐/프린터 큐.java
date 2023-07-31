import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(stk.nextToken());
		while (T-- > 0) {
			stk = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			
			Queue<Integer> Q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			
			int target = 0;
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(stk.nextToken());
				pq.offer(n);
				
				if (i == M) {
					target = n + 10;
					Q.offer(target);
					continue;
				}
				Q.offer(n);
			}
			
			int cnt = 0;
			while (!Q.isEmpty()) {
				if (Q.peek() == target && Q.peek() % 10 == pq.peek()) break;
				
				if (pq.peek() == Q.peek() % 10) {
					pq.poll();
					Q.poll();
					cnt++;
					continue;
				}
				Q.offer(Q.poll());
			}
			
			sb.append(cnt + 1).append("\n");
		}
		System.out.println(sb);
	}
}