import java.math.*;
import java.util.*;

public class Main{
	public static int arr[][];
	public static int x,y;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int testcase=in.nextInt();
		
		for(int i=0;i<testcase;i++){
			x=in.nextInt();
			y=in.nextInt();
			int k=in.nextInt();
			arr=new int[y][x];
			for(int j=0;j<k;j++){
				int xx=in.nextInt();
				int yy=in.nextInt();
				arr[yy][xx]=1;
			}
			
			int ans=0;
			for(int a=0;a<x;a++){
				for(int b=0;b<y;b++){
					if(arr[b][a]==1){
						dfs(a,b);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static void dfs(int xx,int yy){
		if(xx-1>=0 && yy>=0 && xx-1<x && yy<y && arr[yy][xx-1]==1){
			arr[yy][xx-1]=0;
			dfs(xx-1,yy);
		}
		if(xx+1>=0 && yy>=0 && xx+1<x && yy<y && arr[yy][xx+1]==1){
			arr[yy][xx+1]=0;
			dfs(xx+1,yy);
		}
		if(xx>=0 && yy-1>=0 && xx<x && yy-1<y && arr[yy-1][xx]==1){
			arr[yy-1][xx]=0;
			dfs(xx,yy-1);
		}
		if(xx>=0 && yy+1>=0 && xx<x && yy+1<y && arr[yy+1][xx]==1){
			arr[yy+1][xx]=0;
			dfs(xx,yy+1);
		}
	}
}
