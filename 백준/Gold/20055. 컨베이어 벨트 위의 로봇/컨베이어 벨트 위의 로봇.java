import java.io.*;
import java.util.*;

public class Main {

	static int[][] belt;
	static int N, K, cnt, curState;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {
		init();
		while (true) {
			beltRotate();
			if (!robotRotate()) break;
			if (!addRobot()) break;
		}
		System.out.println(curState);
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		belt = new int[2][2 * N];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++)
			belt[0][i] = Integer.parseInt(stk.nextToken());
		cnt = curState = 0;
	}
	
	public static void beltRotate() {
		curState++;
		int tmpA = belt[0][2 * N - 1];
		int tmpR = belt[1][2 * N - 1];
		
		for (int i = 2 * N - 1; i > 0; i--) {
			belt[0][i] = belt[0][i - 1];
			belt[1][i] = belt[1][i - 1];
		}
		belt[0][0] = tmpA;
		belt[1][0] = tmpR;
		
		if (belt[1][N - 1] == 1) belt[1][N - 1] = 0;
	}
	
	public static boolean robotRotate() {
		for (int i = N - 1; i > 0; i--) {
			if (belt[0][i] == 0 || belt[1][i] == 1 || belt[1][i - 1] == 0) continue;
			
			if (--belt[0][i] == 0) {
				if(++cnt == K) return false;
			}
			
			belt[1][i] = 1;
			belt[1][i - 1] = 0;
		}
		if (belt[1][N - 1] == 1) belt[1][N - 1] = 0;
		return true;
	}
	
	public static boolean addRobot() {
		if (belt[0][0] == 0) return true;
		
		if (--belt[0][0] == 0) {
			if(++cnt == K) return false;
		}
		belt[1][0] = 1;
		
		return true;
	}
}
