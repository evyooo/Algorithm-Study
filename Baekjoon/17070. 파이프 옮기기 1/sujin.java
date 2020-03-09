package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17070
// 그래프에서 파이프를 이동시키는 방법의 수 구하는 문제 
/*마찬가지로, dfs(재귀) 이용해서 푸는 문제임*/
public class _02_17070 {
	static int cnt, N;
	static int[][] arr;
	static boolean [][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2][N+2];
		
		// 그래프를 배열에 담아두는 작업 : 빈칸: 2, 벽: 1, 파이프: 5, 테두리: 0
		for(int x=1; x<N+1; x++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int y=1; y<N+1; y++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==0) {
					arr[x][y]=2;
				}
				else {
					arr[x][y] =c;
				}
			}
		}
		arr[1][1]=5; arr[1][2]=5; // 처음 파이프 상태
		cnt=0;
		int x=1; int y=2;  // 파이프의 오른쪽 끝 위치 (초기)
		dfs(x,y);
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		// 도착!
		if(x==N && y==N) {
			cnt++;
			return;
		}
		else {
			if(arr[x][y-1]==5) { // 가로일때 -> 2가지 방법 유
				if(arr[x][y+1]==2) { // 가로로 이동할 수 있는지 확인
					arr[x][y-1]=2;	// 여긴 다시 빈칸이 됨
					arr[x][y+1]=5;	// 이동 한곳은 5로 변함
					dfs(x,y+1);
					arr[x][y-1]=5; arr[x][y+1]=2;	// 되돌려놓기(다음 경우를 위해)
	
				}
				if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) {	// 대각선 확인
					arr[x][y-1]=2;
					arr[x+1][y+1]=5;
					dfs(x+1,y+1);
					arr[x][y-1]=5; arr[x+1][y+1]=2;
				}
			}
			else if(arr[x-1][y]==5) {	//세로일때 -> 가능한 방법 2가지
				if(arr[x+1][y]==2) {	// 세로 이동가능 여부 확인
					 arr[x-1][y]=2; arr[x+1][y]=5;
                     dfs(x+1,y);
                     arr[x-1][y]=5; arr[x+1][y]=2;
				}
				if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) { // 대각선 확인
                    arr[x-1][y]=2; arr[x+1][y+1]=5;
                    dfs(x+1,y+1);
                    arr[x-1][y]=5; arr[x+1][y+1]=2;
                }
			}
			else if(arr[x-1][y-1]==5) {
                if(arr[x][y+1]==2) { // 가로확인
                    arr[x-1][y-1]=2; arr[x][y+1]=5;
                    dfs(x,y+1);
                    arr[x-1][y-1]=5; arr[x][y+1]=2;
                }
                if(arr[x+1][y]==2) { // 세로확인
                    arr[x-1][y-1]=2; arr[x+1][y]=5;
                    dfs(x+1,y);
                    arr[x-1][y-1]=5; arr[x+1][y]=2;
                }
                if(arr[x+1][y+1]==2 && arr[x][y+1]!=1 && arr[x+1][y]!=1) { // 대각선 확인
                    arr[x-1][y-1]=2; arr[x+1][y+1]=5;
                    dfs(x+1,y+1);
                    arr[x-1][y-1]=5; arr[x+1][y+1]=2;
                }
            }
		}
	}
}
