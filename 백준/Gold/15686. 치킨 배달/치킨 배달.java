import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static List<int[]> H, C;
	static int[] pick;
	static int N, M, minD;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
	    N = Integer.parseInt(stk.nextToken());
	    M = Integer.parseInt(stk.nextToken());
	    
	    H = new ArrayList<>();
	    C = new ArrayList<>();
	    
	    for (int i = 0; i < N; i++ ) {
		    stk = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		    	int cur = Integer.parseInt(stk.nextToken());
		    	
		    	if (cur == 1) H.add(new int[] {i, j});
		    	if (cur == 2) C.add(new int[] {i, j});
		    }
	    }
	    
	    minD = Integer.MAX_VALUE;
	    pick = new int[M];
	    
	    comb(0, 0);
	    
	    System.out.println(minD);
	}
	
	public static void comb(int L, int st) {
		if (L == M) {
			int totalD = 0;
			for (int[] h : H) {
				int min = Integer.MAX_VALUE;
				for (int c : pick) 
					min = Math.min(min, getDistance(h[0], h[1], C.get(c)[0], C.get(c)[1]));
				totalD += min;
			}
			minD = Math.min(totalD, minD);
			return;
		}
		
		for (int i = st; i < C.size(); i++) {
			pick[L] = i;
			comb(L + 1, i + 1);
		}
	}
	
	public static int getDistance(int x, int y, int nx, int ny) {
		return Math.abs(nx - x) + Math.abs(ny - y);
	}
}