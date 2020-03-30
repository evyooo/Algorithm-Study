import java.util.*;
public class Main {
	public static int dfs[][];
	public static int bfs[][];
	public static int n;
	public static int visited_dfs[];
	public static int visited_bfs[];
	public static Queue<Integer> queue=new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();//정점의 개수
		int m=in.nextInt();//간선의 개수
		int v=in.nextInt();//참색시작 번호
		dfs=new int[n+1][n+1];
		bfs=new int[n+1][n+1];
		visited_dfs=new int[n+1];
		visited_bfs=new int[n+1];
		for(int i=0;i<m;i++){
			int a=in.nextInt();
			int b=in.nextInt();
			dfs[a][b]=1;dfs[b][a]=1;
			bfs[a][b]=1;bfs[b][a]=1;
		}
		
		dfs_search(v);
		System.out.println();
		bfs_search(v);
		
		
	}
	public static void dfs_search(int v){
		if(visited_dfs[v]==1) return;
		
		visited_dfs[v]=1;
		System.out.print(v+" ");
		for(int i=1;i<=n;i++){
			
			if(dfs[v][i]==1||dfs[i][v]==1){
				dfs[v][i]=0;dfs[i][v]=0;
				dfs_search(i);
			}
		
		}
		
	}
	
	public static void bfs_search(int v){
		visited_bfs[v]=1;
		System.out.print(v+" ");
		queue.add(v);
		while(true){
			for(int i=1;i<=n;i++){
				if((bfs[v][i]==1||bfs[i][v]==1)&&visited_bfs[i]==0){
					queue.add(i);
					visited_bfs[i]=1;
					System.out.print(i+" ");
				}
			}
			queue.remove(v);
			if(queue.isEmpty()) break;
			v=queue.poll();
		}
	}
	
}
