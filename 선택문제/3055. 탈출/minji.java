//이 문제의 포인트는 물 먼저 돌아주고 도치 돌아주는거.. ㅎㅎ

import java.util.*;

class Pair { //물에 대한 정보를 넣을 때도 쓰고, BFS때도 쓰고.. 용이함.
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class a3055 {
	static final int[] dx = { 1, -1, 0, 0 }; //이건 정말 그냥 필수 상수..
	static final int[] dy = { 0, 0, 1, -1 };

	static void bfsW(int[][] water, Queue<Pair> q, int n, int m) { //물에 대한 bfs
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (water[nx][ny] == 0) { //물이 0이면 지나가야지 물먼저 bfs
						water[nx][ny] = water[x][y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
	}

	static void bfsD(int[][] water, int[][] dochi, int dI, int dJ, int n, int m) { //물 bfs해주고 도치도 bfs
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(dI, dJ));
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (dochi[nx][ny] == 0) {//도치가 안 지나감
						if ((dochi[x][y] + 1) < water[nx][ny] || water[nx][ny] == 0) {//물이 안 지나갔거나 물보다 작을 때.. 그래서 물 은 n*m+1넣어줌
							dochi[nx][ny] = dochi[x][y] + 1;
							q.add(new Pair(nx, ny));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Queue<Pair> qwater = new LinkedList<Pair>();
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int m = kbd.nextInt();
		kbd.nextLine();
		char[][] c = new char[n][m];
		int[][] water = new int[n][m];
		int[][] dochi = new int[n][m];//받아받아 입력 받아
		int dI = 0, dJ = 0, bI = 0, bJ = 0;//도치 i,j 비버굴 i,j
		int k = 0;
		for (int i = 0; i < n; i++) {
			String s = kbd.nextLine();
			for (int j = 0; j < m; j++) {
				c[i][j] = s.charAt(j);
				if (c[i][j] == 'S') {
					dI = i;
					dJ = j;
					dochi[i][j] = 1;//도치 위치 1
				}
				if (c[i][j] == 'D') {
					bI = i;
					bJ = j;
					water[i][j] = n*m+1; //에서 water는 n*m+1인게 포인트.. n*m이었다가 실수나
				}
				if (c[i][j] == '*') {
					qwater.add(new Pair(i, j)); //물의 쌍을 큐에 넣어줌
					water[i][j] = 1;
				}
				if (c[i][j] == 'X') {
					dochi[i][j] = -1;
					water[i][j] = -1;
				}
			}
		}
	
		bfsW(water, qwater, n, m); //큐워터와 함께 bfs로 슝
		bfsD(water, dochi, dI, dJ, n, m); //도치 bfs
		
		if (dochi[bI][bJ] != 0)
			System.out.println(dochi[bI][bJ] - 1); // 도치 첨에 위치 1 해줬으니까 -1
		else
			System.out.println("KAKTUS"); //캑터스
	}

}
