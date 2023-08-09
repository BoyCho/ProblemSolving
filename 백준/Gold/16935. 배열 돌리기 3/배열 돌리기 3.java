import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static StringBuilder[] sbArr;
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		sbArr = new StringBuilder[N];
		
		for (int i = 0; i < N; i++) {
			sbArr[i] = new StringBuilder();
			sbArr[i].append(br.readLine());
		}
		
		stk = new StringTokenizer(br.readLine());
		while (stk.hasMoreElements()) {
			int order = Integer.parseInt(stk.nextToken());
			
			switch (order) {
			case 1:
				module1();
				break;
			case 2:
				module2();
				break;
			case 3:
				module3();
				break;
			case 4:
				module4();
				break;
			case 5:
				module5();
				break;
			case 6:
				module6();
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sbArr.length; i++) {
			sb.append(sbArr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static StringBuilder[] init(int size) {
		StringBuilder[] tmp = new StringBuilder[size];
		
		for (int i = 0; i < size; i++)
			tmp[i] = new StringBuilder();
		
		return tmp;
	}
	
	public static void module1() {
		for (int i = 0; i < N / 2; i++) {
			StringBuilder tmp;
			
			tmp = sbArr[i];
			sbArr[i] = sbArr[N - i - 1];
			sbArr[N - i - 1] = tmp;
		}
	}
	
	public static void module2() {
		StringBuilder[] tmp = init(N);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk2 = new StringTokenizer(sbArr[i].toString());
			
			while (stk2.hasMoreTokens())
				tmp[i].insert(0, stk2.nextToken() + " ");
		}
		sbArr = tmp;
	}
	
	public static void module3() {
		StringBuilder[] tmp = init(M);
		
		for (int i = N - 1; i >= 0; i--) {
			StringTokenizer stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M; j++) {
				tmp[j].append(stk2.nextToken()).append(" ");
			}
		}
		
		int tmpN = N;
		N = M;
		M = tmpN;
		
		sbArr = tmp;
	}
	
	public static void module4() {
		StringBuilder[] tmp = init(M);
		
		module2();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M; j++) {
				tmp[j].append(stk2.nextToken()).append(" ");
			}
		}
		
		int tmpN = N;
		N = M;
		M = tmpN;
		
		sbArr = tmp;
	}
	
	public static void module5() {
		StringBuilder[] tmp = init(N);
		StringTokenizer stk2;
		
		for (int i = N / 2; i < N; i++) {
			stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M / 2; j++)
				tmp[i - N / 2].append(stk2.nextToken()).append(" ");
			
			for (int j = M / 2; j < M; j++)
				tmp[i].append(stk2.nextToken()).append(" ");
		}
		
		for (int i = 0; i < N / 2; i++) {
			stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M / 2; j++)
				tmp[i].append(stk2.nextToken()).append(" ");
			
			for (int j = M / 2; j < M; j++)
				tmp[i + N / 2].append(stk2.nextToken()).append(" ");
		}
		
		sbArr = tmp;
	}
	
	public static void module6() {
		StringBuilder[] tmp = init(N);
		StringTokenizer stk2;
		
		for (int i = 0; i < N / 2; i++) {
			stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M / 2; j++)
				tmp[i + N / 2].append(stk2.nextToken()).append(" ");
			
			for (int j = 0; j < M / 2; j++)
				tmp[i].append(stk2.nextToken()).append(" ");
		}
		
		for (int i = N / 2; i < N; i++) {
			stk2 = new StringTokenizer(sbArr[i].toString());
			
			for (int j = 0; j < M / 2; j++)
				tmp[i].append(stk2.nextToken()).append(" ");
			
			for (int j = 0; j < M / 2; j++)
				tmp[i - N / 2].append(stk2.nextToken()).append(" ");
		}
		
		sbArr = tmp;
	}
}