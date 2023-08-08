import java.io.*;
import java.util.*;

public class Solution {

	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[] leapBound;
	
	public static void main(String[] args) throws IOException {
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int isValid = 1;
			
			leapBound = getLeapBound(N);
			
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int cur = Integer.parseInt(stk.nextToken());
				String type = stk.nextToken();
				
				isValid = isValid(cur, type) & isValid;
			}
			sb.append("#").append(tc).append(" ").append(isValid).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int[] getLeapBound(int N) {
		return new int[] {N / 2 + 1,N};
	}
	
	public static int isValid(int cur, String type) {
		if (leapBound[0] <= cur && cur <= leapBound[1]) {
			/* 해당 노드가 leap 범위 라면*/
			for (int i = 0; i < type.length(); i++) {
				if (!Character.isDigit(type.charAt(i)))
					return 0;
			}
			return 1;
		}
		
		for (int i = 0; i < type.length(); i++) {
			if (Character.isDigit(type.charAt(i)))
				return 0;
		}
		return 1;
	}
}