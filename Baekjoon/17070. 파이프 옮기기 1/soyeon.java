import java.util.*;
public class Main {
	public static int n;
	public static int mat[][];
	public static int ans=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		mat=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				mat[i][j]=in.nextInt();
			}
		}
		
		pipe(1,1,1,2);
		System.out.println(ans);
	}
	public static void pipe(int r1, int c1, int r2, int c2) {
		if(r2==n && c2==n) {
			ans++;
			return;
		}
		
		if(r1==r2) {//가로
			if(isBoundary(r2,c2+1)&&mat[r2][c2+1]==0)
				pipe(r2, c2, r2, c2+1);
			if(isBoundary(r2+1,c2+1)&&mat[r2+1][c2+1]==0&&mat[r2+1][c2]==0&&mat[r2][c2+1]==0)
				pipe(r2, c2, r2+1, c2+1);
		}
		else if(c1==c2) {//세로
			if(isBoundary(r2+1,c2)&&mat[r2+1][c2]==0)
				pipe(r2, c2, r2+1, c2);
			if(isBoundary(r2+1,c2+1)&&mat[r2+1][c2+1]==0&&mat[r2+1][c2]==0&&mat[r2][c2+1]==0)
				pipe(r2, c2, r2+1, c2+1);
		}
		else {//대각선
			if(isBoundary(r2,c2+1)&&mat[r2][c2+1]==0)
				pipe(r2, c2, r2, c2+1);
			if(isBoundary(r2+1,c2)&&mat[r2+1][c2]==0)
				pipe(r2, c2, r2+1, c2);
			if(isBoundary(r2+1,c2+1)&&mat[r2+1][c2+1]==0&&mat[r2+1][c2]==0&&mat[r2][c2+1]==0)
				pipe(r2, c2, r2+1, c2+1);
		}
	}
	public static boolean isBoundary(int r,int c) {
		if(r>n)
			return false;
		if(c>n)
			return false;
		if(r==0)
			return false;
		if(c==0)
			return false;
		return true;
	}
}
