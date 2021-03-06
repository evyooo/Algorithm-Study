import java.util.*;

public class Main {
	static ArrayList<Integer> a[];
	static boolean c[];

	public static void dfs(int x) { //dfs구현
		if (c[x])
			return;
		c[x] = true;
		System.out.print(x+" ");
		for (int y : a[x]) { 
			if (c[y] == false)
				dfs(y);
		}
	}

	public static void bfs(int start) { //bfs구현
		Queue<Integer> q = new LinkedList();
		q.add(start);
		c[start]=true;
		while (!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x+" ");
			for (int y : a[x]) {
				if(c[y]==false) {
					q.add(y);
					c[y]=true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int m = kbd.nextInt();
		int start = kbd.nextInt();

		a = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			a[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) { //pair로 양방향 간선 u,v를 서로 이어준다.
			int u = kbd.nextInt();
			int v = kbd.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		
		for(int i=1;i<=n;i++)
			Collections.sort(a[i]); //정렬해준다.

		c = new boolean[n + 1];
		dfs(start);
		System.out.println();
		c = new boolean[n + 1];
		bfs(start);

	}

}
