import java.util.*;
public class Main {
	public static int mat[][][];
	public static int row, col, height, ans;
	public static int[] dr= {0,0,0,0,1,-1};
	public static int[] dc= {0,0,1,-1,0,0};
	public static int[] dh= {1,-1,0,0,0,0};
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		col=in.nextInt();
		row=in.nextInt();
		height=in.nextInt();
		mat=new int[height][row][col];
		Queue<Position> queue=new LinkedList<Position>();
		for(int h=0;h<height;h++) {
			for(int r=0;r<row;r++) {
				for(int c=0;c<col;c++) {
					mat[h][r][c]=in.nextInt();
					if(mat[h][r][c]==1)//익은 토마토의 위치 저장
						queue.add(new Position(r,c,h));
				}
			}
		}
		ans=0;
		Tomato(queue);
		
		if(!isFinish())//아직 다 안익었으면
			System.out.println("-1");
		else//다 익었으면 날짜 계산
			System.out.println(ans-1);
	}
	public static void Tomato(Queue<Position> que) {
		if(que.isEmpty())//익을 수 있는 토마토의 위치가 없으면
			return;
		
		ans++;
		Queue<Position> newqueue=new LinkedList<Position>();//새롭게 익을 토마토의 위치
		while(!que.isEmpty()) {
			Position p=que.poll();
			for(int i=0;i<6;i++) {
				int newr=p.r+dr[i];
				int newc=p.c+dc[i];
				int newh=p.h+dh[i];
				
				if(isBoundary(newr, newc, newh) && mat[newh][newr][newc]==0) {//만약 범위 내의 토마토가 안익었으면
					newqueue.add(new Position(newr, newc, newh));
					mat[newh][newr][newc]=1;
				}
			}
		}
		Tomato(newqueue);
	}
	public static boolean isBoundary(int r, int c, int h) {//위치가 matrix 범위 안인지 확인
		if(r<0||r>=row) return false;
		if(c<0||c>=col) return false;
		if(h<0||h>=height) return false;
		return true;
	}
	public static boolean isFinish() {//하나라도 0이면 false
		for(int h=0;h<height;h++) {
			for(int r=0;r<row;r++) {
				for(int c=0;c<col;c++) {
					if(mat[h][r][c]==0)
						return false;
				}
			}
		}
		return true;
	}
}
class Position{//위치 저장
	int r,c,h;
	public Position(int r, int c, int h) {
		this.r=r;
		this.c=c;
		this.h=h;
	}
}
