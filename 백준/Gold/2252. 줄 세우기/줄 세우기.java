import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static List<Integer>[] list;
	static int[] inDegree;
	static int N, M;
	
	static Queue<Integer> Q;
	
	public static void main(String[] args) throws IOException {
		init();
		topologySort();
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		list = new ArrayList[N + 1];
		inDegree = new int[N + 1];
		
		for (int i = 1; i <= N; i++) 
			list[i] = new ArrayList<>();
		
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			list[a].add(b);
			inDegree[b]++;
		}
	}
	
	public static void topologySort() {
		Q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				sb.append(i).append(" ");
				Q.offer(i);
			}
		}
		
		while (!Q.isEmpty()) {
			int cur = Q.poll();
			
			for (int next : list[cur]) {
				if (--inDegree[next] == 0) {
					sb.append(next).append(" ");
					Q.offer(next);
				}
			}
		}
	}
}