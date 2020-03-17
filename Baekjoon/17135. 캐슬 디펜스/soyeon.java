import java.util.*;
public class Main {
	public static int row,col,dis;
	public static int mat[][];
	public static HashSet<HashSet<Integer>> startSet=new HashSet<HashSet<Integer>>();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		row=in.nextInt();
		col=in.nextInt();
		dis=in.nextInt();
		mat=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat[i][j]=in.nextInt();
			}
		}
		int[] start=new int[col];
		int max=0;
		Arrays.fill(start, 0);
		startPoint(start, 0);

		Iterator it=startSet.iterator();
		while(it.hasNext()) {
			HashSet<Integer> s=(HashSet<Integer>) it.next();//궁수 배치

			Iterator init=s.iterator();
			int attack[]=new int[3];
			int index=0;
			while(init.hasNext()) {
				attack[index++]=(int) init.next();
			}

			int enemy=attackALL(attack, mat);
			if(max<enemy)//최대값만 저장
				max=enemy;
		}
		System.out.println(max);
	}
	public static int attackALL(int attack[], int mat[][]) {
		/*각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 
		 * 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 
		 * 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적(c2가 가장 적은 적)을 공격한다.*/
		int time=row;
		int ans=0;
		int mat2[][]=new int[row][col];
		for(int i=0;i<row;i++) {//매트릭스 복사
			for(int j=0;j<col;j++) {
				mat2[i][j]=mat[i][j];
			}
		}

		while(time>0) {
			Queue<Erase> queue=new LinkedList<Erase>();//큐에는 지울 적들만 넣는다
			for(int i=0;i<3;i++) {
				int min=dis+1;
				Erase erase=new Erase(0,0);

				for(int r=0;r<time;r++) {
					for(int c=0;c<col;c++) {
						if(mat2[r][c]==1) {
							int newdis=distance(time, attack[i], r, c);//거리를 구한다
							if(newdis<=dis && min>newdis) {//거리가 d 이하이고 최소 거리일때 업데이트
								min=newdis;
								erase.r=r;
								erase.c=c;
							}
							else if(newdis<=dis && min==newdis && erase.c>c) {//거리가 d 이하이고 거리가 같을 경우 가장 왼쪽 업데이트
								min=newdis;
								erase.r=r;
								erase.c=c;
							}
						}
					}
				}
				
				if(min!=dis+1)//거리가 가까운 적이 있을 경우 큐에 넣는다
					queue.add(erase);
			}

			while(!queue.isEmpty()) {//큐에 있는 적들을 지우고 지운 적들을 더한다
				Erase erase=queue.poll();
				if (mat2[erase.r][erase.c]==1) {
					mat2[erase.r][erase.c]=0;
					ans++;
				}
			}
			time--;
		}
		return ans;
	}
	public static int distance(int r1, int c1, int r2, int c2) {//거리 구하는 함수
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	public static void startPoint(int[] start, int num) {//궁수의 위치 선정
		if(num==3) {
			HashSet<Integer> set=new HashSet<Integer>(); //중복 없애기 위해 set에 넣도록
			for(int i=0;i<col;i++){
				if(start[i]!=0)
					set.add(i);
			}
			startSet.add(set);
			return;
		}

		for(int i=0;i<col;i++) {
			if(start[i]==0) {
				start[i]=1;
				startPoint(start, num+1);
				start[i]=0;
			}
		}
	}
}
class Erase{//지워야할 적들의 위치
	int r, c;
	public Erase(int r,int c) {
		this.r=r;
		this.c=c;
	}
}
