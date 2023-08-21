import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		System.out.println(BFS(N, K));
	}
	
	public static int BFS(int N, int K) {
		
		if (N == K) return 0;
		
		Queue<Integer> Q = new ArrayDeque<>();
		boolean[] vis = new boolean[100001];
		
		vis[N] = true;
		Q.offer(N);
		
		int T = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			while (len-- > 0) {
				int cur = Q.poll();
				
				for (int next : new int[] {cur - 1, cur + 1, 2 * cur}) {
					if (next < 0 || next > 100000 || vis[next]) continue;
					
					vis[next] = true;
					Q.offer(next);
					
					if (vis[K]) return T + 1;
				}
			}
			T++;
		}
		return -1;
	}
}
