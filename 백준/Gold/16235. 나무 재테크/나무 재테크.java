
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<int[]> trees = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		int[][] A = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int[] tree = new int[3];
			for (int j = 0; j < 3; j++) {
				tree[j] = Integer.parseInt(stk.nextToken());
			}
			trees.offer(tree);
		}
		
		int[][][] land = new int[N + 1][N + 1][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				land[i][j][0] = 5;
			}
		}
		
		int[] dx = {-1,0,1,1,1,0,-1,-1};
		int[] dy = {1,1,1,0,-1,-1,-1,0};
		
		while (K-- > 0) {
			// 봄
			PriorityQueue<int[]> tmp = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
			int len = trees.size();
			
			while(len-- > 0) {
				int[] cur = trees.poll();
				if (land[cur[0]][cur[1]][0] < cur[2]) {
					land[cur[0]][cur[1]][1] += cur[2] / 2;
					continue;
				}
				land[cur[0]][cur[1]][0] -= cur[2];
				tmp.offer(new int[] {cur[0], cur[1], cur[2] + 1});
			}
			
			// 여름
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					land[i][j][0] += land[i][j][1];
					land[i][j][1] = 0;
				}
			}
			
			// 가을
			while (!tmp.isEmpty()) {
				int[] cur = tmp.poll();
				trees.offer(cur);
				
				if (cur[2] == 0 || cur[2] % 5 != 0) continue;
				
				for (int dir = 0; dir < 8; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
					trees.offer(new int[] {nx, ny, 1});
				}
			}
			
			// 겨울
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					land[i][j][0] += A[i][j];
				}
			}
		}
		System.out.println(trees.size());
	}
}
