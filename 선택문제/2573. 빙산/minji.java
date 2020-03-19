import java.util.*;

class Pair { //BFS에서 큐에 넣어줄 Pair class를 만들어줍니다.
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class a2573 {
	static final int[] dx = { 0, 0, 1, -1 }; //아래위 좌우를 확인해줄 static final 변수 dx, dy 선언해줍니다.
	static final int[] dy = { 1, -1, 0, 0 };

	static void go(int[][] a, int n, int m) {// 빙산 녹는다
		int[][] b = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				b[i][j]=a[i][j];
				int water = 0; //인접한 물을 계산해줍니다.
				if (a[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
							if (a[nx][ny] == 0)
								water += 1;
						}
					}
					if (water != 0) { //물이 0이 아닐 때를 구분해 줄 필요가 없긴 한데.. 오류들 고치다 이렇게 했음
						if (a[i][j] >= water)
							b[i][j] -= water;
						else
							b[i][j] = 0;
					}
				}
			}
		}
		for(int i=0;i<n;i++) { //b를 따로 해줘야 겹쳐서 연결된 빙산이 다 녹는 사태를 막아줄 수 있음
			for(int j=0;j<m;j++)
				a[i][j]=b[i][j];
		}
	}

	static void bfs(int[][] a, boolean[][] c, int i, int j, int n, int m) {// 빙산의 개수세기
		Queue<Pair> q = new LinkedList<Pair>();// 연결되어있는 빙산들을 체크해주는 bfs코드
		q.add(new Pair(i, j));
		c[i][j] = true;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (a[nx][ny] != 0 && c[nx][ny] == false) {
						q.add(new Pair(nx, ny));
						c[nx][ny] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int m = kbd.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				a[i][j] = kbd.nextInt();
		}
		int num = 0;

		while (true) {
			
			boolean[][] c = new boolean[n][m]; //빙산 체크용 체크 불리언
			boolean ok = true;//빙산이 다 녹으면 나가주려고 ok 변수 만들어줌

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (a[i][j] == 0)
						c[i][j] = true;
					else
						ok = false;
				}
			}

			if (ok) { // 다 녹았을 때도 돌고 있으면 num=0이고 while문 빠져나감
				num = 0;
				break;
			}

			int soo = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (c[i][j] == false) {
						bfs(a, c, i, j, n, m);
						soo += 1; // 연결된 빙산 하나당 수 하나 추가
					}
				}
			}

			if (soo > 1) // 빙산 나눠진 수가 1보다 크면 while문 나갑니다.
				break;

			
			
			go(a, n, m); //빙산이 녹아요
			num += 1; //녹은 횟수 추가

		}

		System.out.println(num);

	}

}
