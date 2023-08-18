import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int N, M, V;
	
	static Queue<Integer> Q;
	static boolean[] vis;
	
	static List<Integer>[] list;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		V = Integer.parseInt(stk.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(list[i]);
		
		vis = new boolean[N + 1];
		
		sb.append(V).append(" ");
		vis[V] = true;
		DFS(0, V);
		sb.append("\n");
		
		BFS();
		
		System.out.println(sb);
	}

	public static void BFS() {
		Q = new ArrayDeque<>();
		vis = new boolean[N + 1];
		
		Q.offer(V);
		vis[V] = true;
		sb.append(V).append(" ");
		
		while (!Q.isEmpty()) {
			int cur = Q.poll();
			
			for (int next : list[cur]) {
				if (vis[next]) continue;
				
				Q.offer(next);
				vis[next] = true;
				sb.append(next).append(" ");
			}
		}
		sb.append("\n");
	}
	
	public static void DFS(int L, int st) {
		if (L == N) return;
		
		for (int next : list[st]) {
			if (vis[next]) continue;
			
			sb.append(next).append(" ");
			
			vis[next] = true;
			DFS(L + 1, next);
		}
	}
}
