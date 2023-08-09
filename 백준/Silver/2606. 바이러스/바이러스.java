import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] coms;
	static boolean[] vis;
	static int N, M;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		coms = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			coms[i] = new ArrayList<>();
		
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			coms[a].add(b);
			coms[b].add(a);
		}
		
		vis = new boolean[N + 1];
		vis[1] = true;
		
		System.out.println(DFS(1));
	}
	
	public static int DFS(int com) {
		
		int sum = 0;
		for (int nextCom : coms[com]) {
			if (vis[nextCom]) continue;
			
			vis[nextCom] = true;
			sum += DFS(nextCom) + 1;
		}
		
		return sum;
	}

}