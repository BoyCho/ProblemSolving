import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		List<Integer> L = new LinkedList<>();
		
		for (int i = 1; i <= N; i++)
			L.add(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int cur = K - 1;
		while(true) {
			sb.append(L.remove(cur)).append(", ");
			
			if (L.isEmpty()) break;
			
			cur = (cur + K - 1) % L.size();
		}
		
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}
