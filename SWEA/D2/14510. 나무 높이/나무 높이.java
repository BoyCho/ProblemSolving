import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;

	static int N, max;
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(sb);
	}

	public static void init() throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			stk = new StringTokenizer(br.readLine());
			
			trees = new int[N];
			max = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(stk.nextToken());
				max = Math.max(max, trees[i]);
			}
			print(tc, countDays());
		}
	}
	
	public static int countDays() {
		int sum = 0;
		int odd = 0, even = 0;
		
		for (int tree : trees) {
			if (max == tree) continue;
			sum += max - tree;
			
			even += (max - tree) / 2;
			if ((max - tree) % 2 == 1) odd++;
		}
		
		if (odd == even) 
			return sum / 3 * 2;
		
		int days = 0;
		if (odd > even) {
			days = even * 2;
			return days + (odd - even) * 2 - 1;
		}
		
		days = sum / 3 * 2;
		if (sum % 3 == 0) return days;
		return sum % 3 == 1 ? days + 1 : days + 2;
	}

	public static void print(int tc, int ans) {
		sb.append("#").append(tc).append(" ").append(ans).append("\n");
	}
}