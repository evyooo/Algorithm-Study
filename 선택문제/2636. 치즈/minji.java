import java.util.*;
class Pair0{ //bfs를 돌려줄 Pair 클래스를 선언해줍니다.
	int x,y;
	Pair0(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class a2636 {
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };
	static int[][] bfs(int i, int j, int[][] cheese,int[][] d, int n, int m) { // BFS ^-^ 테두리 에서 한번 돌려줍니다.
		Queue<Pair0> q = new LinkedList<Pair0>();
		q.add(new Pair0(i,j));
		d[i][j]=1;
		
		while(!q.isEmpty()) {
			Pair0 p =q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (cheese[nx][ny] == 0 && d[nx][ny]==0) {
						q.add(new Pair0(nx,ny));
						d[nx][ny]=1;
					}
					
				}
			}
		}
		return d; //void로 해도 되겠지만 하다보니 리턴을 얘로 해버렸,,,,
		
	}
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int m = kbd.nextInt();
		int[][] cheese = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cheese[i][j] = kbd.nextInt();
			}
		}
		int lastCheese; //라스트 치즈.. 치즈 먹고 싶네요.
		int num = 0;

		while (true) {
			lastCheese = 0; //라스트 치즈는 처음에 한번 쑥 훑어서 정해줍니다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (cheese[i][j] == 1) {
						lastCheese += 1;
					}
				}
			}
			int[][] d = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(cheese[i][j]==1)
						d[i][j]=1; //공기가 아니라 치즈도 d가 1
				}
			}
			d=bfs(0,0,cheese,d,n,m); //테두리공기 쏵돌아줘요
			
			int[][] cheese2 = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (cheese[i][j] == 1) {
						cheese2[i][j] = 1;
						boolean air = true;
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
								if (cheese[nx][ny] == 0 && d[nx][ny]==1) //d가 1 일때만 false되는게 포인트
									air = false;
							}
						}
						if (!air)
							cheese2[i][j] = 0; // 녹는치즈는 air가 false airfalse 에어포스??
					}
				}
			}
			
			
			num += 1;
			
			boolean ok = true; // 다녹으면 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					cheese[i][j]=cheese2[i][j];
					if (cheese[i][j] == 1) {
						ok=false;
					}
				}
			}
			if (ok)
				break;

		}

		System.out.println(num);
		System.out.println(lastCheese);

	}

}
