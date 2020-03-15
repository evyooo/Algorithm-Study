//후.. 풀어서 맞아서 뿌듯하긴 한데 코드가 좀 기네요..
//실행 시간은 332ms 나왔습니다. 
//아무래도 N,M 범위가 작아서 브루트포스 / BFS 로 하면 풀리는 것 같아요!
//저번 문제보다는 좀 더 쉬웠던 것 같아요.. 아마?

import java.util.*;

class Pair { //BFS에 (x,y)쌍으로 넣어줄 것입니다. class Pair 만들어줌
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class a17135_1 {
	static int n; //계속 쓰일 변수 n,m,d를 스태틱 변수로 선언해줬어요.
	static int m;
	static int d;
	static final int[] dx = { 0, -1, 0 }; // 왼쪽, 가운데 위, 오른쪽 순으로 (왼쪽이 제일 먼저 실행 돼야하니까) 
	static final int[] dy = { -1, 0, 1 };// final 변수를 선언해줬어요.

	static void bfs(int[][] a, int height, int oh0, int[][] dist) {
		Queue<Pair> q = new LinkedList<Pair>(); //Pair 객체를 넣을 수 있는 큐를 만들어줍니다.
		boolean[][] c = new boolean[n][m]; //매번 지나간지 안 지나간지 체크해주는 boolean 변수를 선언해줍니다.
		int[][] position = new int[n][m]; //몇번실행한지 기록해주는 position 변수도 만들어줄거에요. 이게 d가되면 실행이 안 되도록 하려구요!
		q.add(new Pair(height, oh0));
		position[height][oh0] = 1; //인자로 받은 height와 oh0는 지나가니까 1을 대입해줍니다.
		int x, y;
		while (!q.isEmpty()) {
			Pair p = q.remove();//넣었다 빼요!!
			x = p.x;
			y = p.y;

			if (a[x][y] == 1 && dist[x][y] == 0) {//지나가면 dist를 1로해주고 return해줍니다.
				dist[x][y] = 1;
				return;
			}
			c[x][y] = true; //지나갔으니까 트루

			for (int k = 0; k < 3; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && position[x][y] < d) { //범위 확인/ position이 d-1일때까지만 nx, ny로 받아줄거에요!
					if (a[nx][ny] == 1 && dist[x][y] == 0 && c[x][y] == false) { //Hoxy nx,ny중에 되면 dist를 1로해주고 return
						dist[nx][ny] = 1;
						return;
					} else if (c[nx][ny] == false) {
						q.add(new Pair(nx, ny)); //nx,ny 페어쌍을 큐에 넣어줍니다.
						position[nx][ny] = position[x][y] + 1; //지나갈거니까 position+1~
					}
				}
			}
		}
	}

	static int go(int[][] a, int[] oh) { //go함수는 bfs를 높이(1~n-1에 따라 실행해주려고 만들었어요.
		int[][] dist1 = new int[n][m];//각각의 oh에 대한 죽인 적을 나타내주는 변수들이에요.
		int[][] dist2 = new int[n][m];//동시에 같은 적을 쏠수도 있으니가 각각 해줬어요.
		int[][] dist3 = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			bfs(a, i, oh[0], dist1);
			bfs(a, i, oh[1], dist2);
			bfs(a, i, oh[2], dist3);
			for (int ii = 0; ii < n; ii++) {
				for (int j = 0; j < m; j++) { // 한턴동안은 같은 적을 쏠 수 있지만 다음 차례에서는 죽인 적은 공격 못하니까
					if (dist1[ii][j] == 1 || dist2[ii][j] == 1 || dist3[ii][j] == 1) {
						dist1[ii][j] = 1; //겹치는 죽인 적을 다 1로 체크해줬어요.
						dist2[ii][j] = 1;
						dist3[ii][j] = 1;
					}
				}
			}

		}

		int nn = 0; //얘에다가 죽인 적을 기록할겁니다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist1[i][j] == 1 || dist2[i][j] == 1 || dist3[i][j] == 1)
					nn += 1;
			}
		}

		return nn; //nn을 리턴!
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		n = kbd.nextInt();
		m = kbd.nextInt();
		d = kbd.nextInt();
		int[] oh = new int[3];

		int[] num = new int[500];// mC3가지 다 해보기 m최대 15C3=455가지 
		int[][] a = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = kbd.nextInt(); 
			}
		}

		int rs = 0;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					oh[0] = i;
					oh[1] = j;
					oh[2] = k;
					num[rs] = go(a, oh); //각각의 oh에 따른 nn들을 num배열에 넣어줬어요. //브루투포스
					rs++;
				}
			}
		}

		for (int i = 0; i < rs - 1; i++) {//num중에 최대값을 num배열 rs-1번째에 넣어줄거에요.
			if (num[i] > num[i + 1])
				num[i + 1] = num[i];
		}
		int max = num[rs - 1]; //얘가 바로 최대값!
		System.out.println(max);

	}

}

// h,s0 (1) d=1
// h,s0-1~s0+1 h-1,s0 (1+3) d=2
// h,s0-2~s0+2 h-1,s0-1~s0+1 h-2,s0 (1+3+5) d=3
// h,s0-3~s0+3 h-1,s0-2~s0+2 h-2,s0-1~s0+1 h-3,s0 (1+3+5+7) d=4
// h,s0-4~s0+4 h-1,s0-3~s0+3 h-2,s0-2~s0+2 h-3,s0-1~s0+1 h-4,s0 (1+3+5+7+9) d=5
