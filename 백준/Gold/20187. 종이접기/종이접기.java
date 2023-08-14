import java.io.*;
import java.util.*;

public class Main{
	// 입력용 BufferedReader 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 출력용 StringBuilder 
	static StringBuilder sb = new StringBuilder();
	// 입력 파싱용 StringTokenizer
	static StringTokenizer stk;
	
	static int[][] page = new int[2][2];
	public static void main(String[] args) throws IOException {
		// 테스트 케이스 횟수 T 입력
		int K = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(br.readLine());
		char cur1 = 'D', cur2 = 'R';
		
		if (h == 0) {
			page[0][0] = 3;
			page[0][1] = 2;
			page[1][0] = 1;
			page[1][1] = 0;
		}
		if (h == 1) {
			page[0][0] = 2;
			page[0][1] = 3;
			page[1][0] = 0;
			page[1][1] = 1;
		}
		if (h == 2) {
			page[0][0] = 1;
			page[0][1] = 0;
			page[1][0] = 3;
			page[1][1] = 2;
		}
		
		if (h == 3) {
			page[0][0] = 0;
			page[0][1] = 1;
			page[1][0] = 2;
			page[1][1] = 3;
		}
		
		for (int i = 1; i <= 2 * K; i++) {
			char type = stk.nextToken().charAt(0);
			
			switch (type) {
			case 'U':
				if (cur1 == 'U') break;
				
				cur1 = 'U';
				swapUD();
				break;

			case 'D':
				if (cur1 == 'D') break;
				
				cur1 = 'D';
				swapUD();
				break;
				
			case 'R':
				if (cur2 == 'R') break;
				
				cur2 = 'R';
				swapRL();
				break;
				
			case 'L':
				if (cur2 == 'L') break;
				
				cur2 = 'L';
				swapRL();
				break;
			default:
				break;
			}
		}
		
		for (int i = 1; i <= Math.pow(2, K); i++) {
			for (int j = 1; j <= Math.pow(2, K); j++) {
				if (i % 2 == 1) {
					if (j % 2 == 1) sb.append(page[0][0]).append(" ");
					else sb.append(page[0][1]).append(" ");
				}
				else {
					if (j % 2 == 1) sb.append(page[1][0]).append(" ");
					else sb.append(page[1][1]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void swapUD() {
		int tmp = page[0][0];
		page[0][0] = page[1][0];
		page[1][0] = tmp;
		
		tmp = page[1][1];
		page[1][1] = page[0][1];
		page[0][1] = tmp;
	}
	
	public static void swapRL() {
		int tmp = page[0][0];
		page[0][0] = page[0][1];
		page[0][1] = tmp;
		
		tmp = page[1][1];
		page[1][1] = page[1][0];
		page[1][0] = tmp;
	}
	
}