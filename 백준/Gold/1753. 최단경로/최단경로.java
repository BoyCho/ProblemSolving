import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int V, E, K;
	static int[] vis;
	static List<int[]>[] adj;
	
	public static void main(String[] args) throws IOException {
		init();
		Dijkstra();
		print();
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			adj[i] = new ArrayList<>();
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			adj[a].add(new int[] {b, w});
		}
		
	}
	
	public static void Dijkstra() {
		PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		vis = new int[V + 1];
		
		for (int i = 1; i <= V; i++)
			vis[i] = Integer.MAX_VALUE;
		
		PQ.offer(new int[] {K, 0});
		vis[K] = 0;
		
		while (!PQ.isEmpty()) {
			int now = PQ.peek()[0];
			int nowWeight = PQ.peek()[1];
			PQ.poll();
			
			if (vis[now] != nowWeight) continue;
			
			for (int[] next : adj[now]) {
				if (vis[next[0]] <= nowWeight + next[1]) continue;
				
				vis[next[0]] = nowWeight + next[1];
				PQ.offer(new int[] {next[0], nowWeight + next[1]});
			}
		}
	}
	
	public static void print() {
		for (int i = 1; i <= V; i++) {
			if (vis[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(vis[i]).append("\n");
		}
		System.out.println(sb);
	}
}
