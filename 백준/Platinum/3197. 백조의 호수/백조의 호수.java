import java.io.*;
import java.util.*;

// BFS 이용!
public class Main {
	static int R, C;					// 행 열
	static int DAY = 0;					// 출력 결과(두 백조가 만나는 최소 날)
	static char[][] lake;				// 호수
	static Queue<Point> waterQueue = new LinkedList<>();	// 물의 위치가 담긴 큐
	static Queue<Point> moveQueue = new LinkedList<>();;	// 첫 번째 백조가 이동할 수 있는 위치가 담긴 큐
	
	// 이동	// i가 0, 1, 2, 3 일 때 각각 위, 오른쪽, 아래, 왼쪽으로 이동
	// ex1) moveY[0], moveX[0] = y로 -1만틈, x로 0만큼 이동 = 위로 이동
	// ex2) moveY[1], moveX[1] = y로 0만큼, x로 1만큼 이동 = 오른쪽으로 이동
	static int[] moveY = {-1, 0, 1, 0};
	static int[] moveX = {0, 1, 0, -1};
	
	static Point[] swan = new Point[2];	// 백조 위치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// R, C 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());	// 행
		C = Integer.parseInt(st.nextToken());	// 열
		
		lake = new char[R][C];	// 호수 배열 생성
		
		// 호수 입력
		int index = 0;	// 0 = 첫 번째 백조, 1 = 두 번째 백조
		for (int r = 0; r < R; r++) {
			String temp = br.readLine();
			for (int c = 0; c < C; c++) {
				lake[r][c] = temp.charAt(c);	// 호수 입력
				
				// 백조인 경우
				if (lake[r][c] == 'L') {
					swan[index++] = new Point(r, c);	// 백조의 위치를 저장하고
					lake[r][c] = '.';					// 백조가 있던 위치를 물로 바꾸기 (백조는 원래 물 위에 있음)
				}
				
				// 물인 경우
				if (lake[r][c] == '.') {
					// 물 위치 큐에 담기
					waterQueue.offer(new Point(r, c));
				}
			}
		}
		
		solve();	// 문제 풀이  시작
		
		// 출력하기
		System.out.print(DAY);
	}
	
	// 문제 풀이 시작
	static void solve() {
		moveQueue.add(swan[0]); 	// 이동 목록을 담은 큐에 첫 번째 백조의 위치 담기(첫 번째 백조 위치부터 이동 시작)
		
		// 두 백조가 만날 때까지 반복
		while (true) {
			// 두 백조가 만날 수 있는지 탐색
			// 두 백조가 만났으면 문제 해결
			if (meetSwanBFS()) break;
			// 두 백조가 만나지 못했으면 하루 지나게
			else DAY++;
			
			// 하루 지나면 얼음이 녹음!
			// 얼음 녹이기
			meltBFS();
		}
	}	// end of solve()
	
	// 두 백조가 만나는지 확인
	static boolean meetSwanBFS() {
		// 다음에 탐색해볼 위치들을 담은 큐 생성
		Queue<Point> nextMoveQueue = new LinkedList<>();
		
		// 현재 더이상 이동할 곳이 없을 때까지 반복
		while (!moveQueue.isEmpty()) {
			// 제일 먼저 탐색할 장소 하나 꺼내기 = 현재 백조의 위치
			Point currentSwanPoint = moveQueue.poll();
			
			boolean flag = false;	// 이동 했는지 여부, false : 이동 안 함, true : 이동 함 
			// 현재 위치에서 위, 오른쪽, 아래, 왼쪽으로 이동
			// i가 0, 1, 2, 3 일 때 각각 위, 오른쪽, 아래, 왼쪽으로 이동
			for (int i = 0; i < moveX.length; i++) {
				int nextY = currentSwanPoint.y + moveY[i];
				int nextX = currentSwanPoint.x + moveX[i];
				
				// 호수 밖으로 벗어나는지 체크(인덱스 아웃 에러)
				if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
				// 이미 지나와본 곳이라면 그냥 지나치기
				if (lake[nextY][nextX] == 'O') continue;
				// 두 번째 백조와 만났으면 true 반환!!
				if (nextX == swan[1].x && nextY == swan[1].y) return true;
				
				// 이동한 곳이 얼음이라면
				if (lake[nextY][nextX] == 'X') {
					// 백조가 아직 이동 안 했으면
					if (!flag) {
						// 다음에 올 땐 얼음이 녹아있을 테니까 다음에 다시 와보기 위해 현재 위치 저장
						nextMoveQueue.add(currentSwanPoint);
						flag = true;	// 이동 더이상 못하게
					}
					continue;
				} // end of if
				
				lake[nextY][nextX] = 'O'; // 탐색해봤다는 표시 남기기
				moveQueue.add(new Point(nextY, nextX));	// 이동한 곳에서 다시 위, 오른쪽, 아래, 왼쪽으로 이동하며 탐색
			}	// end of for
			
		}	// end of while
		
		// 현재 이동할만한 곳의 탐색은 다 끝냈으니 다음에 탐색해볼 곳으로 바꾸기
		moveQueue = nextMoveQueue;
		return false;	// 두 백조가 만나지 못했음
	} // end of meetSwanBFS()
	
	// 물 주변의 얼음을 녹이는 함수
	static void meltBFS() {
		int size = waterQueue.size();	// 현재 물이 있는 위치의 갯수
		// 현재 시점에서 물인 곳만 탐색하고, 물이 된 곳은 다시 waterQueue에 넣을 것이기 때문에 현재 물이 있는 위치의 갯수만큼만 반복
		
		while (size-- > 0) {
			// 현재 물인 곳의 위치 하나 꺼내기
			Point currentWaterPoint = waterQueue.poll();
			
			// 현재 위치에서 위, 오른쪽, 아래, 왼쪽으로 이동하며 얼음인 곳을 물로 바꾸기
			// i가 0, 1, 2, 3 일 때 각각 위, 오른쪽, 아래, 왼쪽으로 이동
			for (int i = 0; i < moveX.length; i++) {
				int nextY = currentWaterPoint.y + moveY[i];
				int nextX = currentWaterPoint.x + moveX[i];
				
				// 호수 밖으로 벗어나는지 체크(인덱스 아웃 에러)
				if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
				// 얼음이면
				if(lake[nextY][nextX] == 'X') {
					lake[nextY][nextX] = '.';	// 물로 녹여주고
					waterQueue.add(new Point(nextY, nextX));	// 물이 된 곳의 위치를 새로 큐에 널어주기
				}
			}	// end of for
		}	// end of while
	}	// end of meltBFS()
}

// 위치
class Point {
	int y, x;
	
	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}