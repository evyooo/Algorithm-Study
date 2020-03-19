import java.util.*;

class Pair { //bfs로 받아줄 pair클래스를 선언해줍니다.
	int x, y, z;

	Pair(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class a7569 {
	static final int[] dx = { 1, -1, 0, 0, 0, 0 }; //이동할 수 있는 칸 6개를 static final변수로 선언
	static final int[] dy = { 0, 0, 1, -1, 0, 0 };
	static final int[] dz = { 0, 0, 0, 0, 1, -1 };

	static void bfs(int[][][] a, int[][][] d, int h, int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (a[i][j][k] == 1) {
						q.add(new Pair(i, j, k));
						d[i][j][k] = 1; //지나간 자리를 1로 해줄거에요
					}
				}
			}
		}

		while (!q.isEmpty()) { //bfs
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			for (int k = 0; k < 6; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				int nz = z + dz[k];
				if (nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m) {
					if(a[nx][ny][nz]==0&&d[nx][ny][nz]==0) {
						d[nx][ny][nz]=d[x][y][z]+1; //지나간 자리 +1
						q.add(new Pair(nx,ny,nz));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int m = kbd.nextInt();
		int n = kbd.nextInt();
		int h = kbd.nextInt();
		int[][][] a = new int[h][n][m];
		int[][][] d = new int[h][n][m];
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					a[i][j][k]=kbd.nextInt();
					if(a[i][j][k]==-1)
						d[i][j][k]=-1; //대입해주면서 -1인 부분의 d값도 -1
				}
			}
		}
		
		int num = 0;
		bfs(a, d, h, n, m);

		boolean ok = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (d[i][j][k] == 0)
						ok = false;//0이 있으면 -1 호출해줄 거라
					if (d[i][j][k] > num) //d[i][j][k]중 제일 큰 수 = 걸리는 시간+1
						num = d[i][j][k];
				}
			}
		}

		if (ok)
			System.out.println(num-1); //안움직였을때부터 1로 해줬으니까 1을 빼준
		else
			System.out.println(-1);

	}

}
