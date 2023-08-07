import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] L;
	static int N, M, max = 0;
	static int[] ans, vis;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		L = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			L[i] = new ArrayList<>();
			
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			L[b].add(a);
		}
		
		ans = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			BFS(i);
		
		for (int i = 1; i <= N; i++) {
			if (ans[i] == max)
				sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void BFS(int start) {
		
		Queue<Integer> Q = new ArrayDeque<>();
		vis = new int[N + 1];
		
		Q.add(start);
		vis[start] = 1;
		int cnt = 1;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			
			for (int next : L[cur]) {
				if (vis[next] != 0) continue;
				
				Q.offer(next);
				vis[next] = 1;
				cnt++;
			}
		}
		max = Math.max(max, cnt);
		ans[start] = cnt;
	}
}
