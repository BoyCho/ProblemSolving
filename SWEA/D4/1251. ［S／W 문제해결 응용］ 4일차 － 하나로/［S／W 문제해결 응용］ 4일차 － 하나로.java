import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int N;
	static double E;
	static int[][] islands;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			init();
			sb.append(PrimAlgorithm()).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		islands = new int[N][2];
		
		for (int i = 0; i < 2; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				islands[j][i] = Integer.parseInt(stk.nextToken());
		}
		
		E = Double.parseDouble(br.readLine());
	}
	
	public static long PrimAlgorithm() {
		PriorityQueue<double[]> PQ = new PriorityQueue<>(
			(o1, o2) -> Double.compare(o1[1], o2[1])
		);
		
		double[][] costs = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				costs[i][j] = costs[j][i] = getCost(islands[i][0], islands[j][0], islands[i][1], islands[j][1]);
			}
		}
		
		boolean[] vis = new boolean[N];
		PQ.offer(new double[] {0, 0});
		
		double sum = 0.0;
		
		while (!PQ.isEmpty()) {
			int now = (int)PQ.peek()[0];
			double nowCost = PQ.peek()[1];
			PQ.poll();
			
			if (vis[now]) continue;
			vis[now] = true;
			
			sum += nowCost;
			
			for (int next = 0; next < N; next++) {
				if (vis[next]) continue;
				PQ.offer(new double[] {next, costs[now][next]});
			}
		}
		
		return Math.round(sum);
	}
	
	public static double getCost(int x1, int x2, int y1, int y2) {
		return E * (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}
}