import java.util.*;

public class a17070 {

	static int go(int[][] a, int x, int y, int d, int n, int ans) {
		if(x==n-1&&y==n-1)
			return 1;
		if(x>n||y>n)
			return 0;
		ans=0;
		//d=0 가로 1 세로 2 대각선
		
		if(d==0) {
			if(y+1<n&&a[x][y+1]==0) {
				ans+=go(a,x,y+1,0,n,ans);
			}
			if(y+1<n&&x+1<n&&a[x][y+1]==0&&a[x+1][y]==0&&a[x+1][y+1]==0) {
				ans+=go(a,x+1,y+1,2,n,ans);
			}
		}else if(d==1) {
			if(x+1<n&&a[x+1][y]==0) {
				ans+=go(a,x+1,y,1,n,ans);
			}
			if(y+1<n&&x+1<n&&a[x][y+1]==0&&a[x+1][y]==0&&a[x+1][y+1]==0) {
				ans+=go(a,x+1,y+1,2,n,ans);
			}
		}else if(d==2) {
			if(y+1<n&&a[x][y+1]==0) {
				ans+=go(a,x,y+1,0,n,ans);
			}
			if(x+1<n&&a[x+1][y]==0) {
				ans+=go(a,x+1,y,1,n,ans);
			}
			if(y+1<n&&x+1<n&&a[x][y+1]==0&&a[x+1][y]==0&&a[x+1][y+1]==0) {
				ans+=go(a,x+1,y+1,2,n,ans);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int[][] a = new int[n][n];
		int ans=0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = kbd.nextInt();
			}
		}

		int d = 0;

		System.out.println(go(a, 0, 1, d, n, ans));
	}

}

//브루투포스 문제로 처음에 시도를 했는데 잘 안 돼서 BFS로 하다가 다시 브루트포스로 함..
//근데 계속 예제가 1~2차이 오류가 나서 백준 소스 참고해서 풀었습니다... ㅠ_ㅠ
//제가 실력이 부족해서.. 그래도 고민하고 문제풀이를 거의 3~4시간 이상 했습니다!
