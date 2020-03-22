package study_beakjoon;

// 사이트에 있는 예제들에 대해선 정답이 나오는데 제출하니까 틀렸다고 뜨네요 ㅠㅠ 이유를 모르겠습니다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569
// 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

public class _02_7569 {
	
	static int M;
	static int N;
	static int H;
	static int blank;
	static int[][][] arr;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N][H];
		int ripe =0; 
		blank =0; // 사과가 들어있지 않은 칸
		// 주어진 상자 내부 상태 저장
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for(int m=0; m<M; m++) {
					arr[m][n][h] = Integer.parseInt(st.nextToken());
					if(arr[m][n][h]==1) ripe++;
					if(arr[m][n][h]==-1) blank++;
				}
			}
		}
		
		int day =0;
		if(ripe== M*N*H - blank) {    // 비어있는 칸을 제외한 모든 칸에 대해서 이미 다 익었다면
			System.out.println(0);
		}else {
			int ans =dfs(day, 0, ripe);
			System.out.println(ans);
		}
		
	}
	
	// return day
	static int dfs(int day, int changed, int ripe) {
		if(day!=0&&changed== 0) {   // 전날에 비해 익은 사과가 없을 경우 (더 이상 익은 사과 개수에 변화가 없을 경우)
			if(ripe == M*N*H - blank) return day-1; // 비어있는 칸을 제외한 모든 칸에 대해서 다 익었다면
			else return -1;
		}
		changed =0;   // 다시 변화 개수 0으로 초기화
		// 1의 좌우 위아래 앞뒤에서 -1이 있을 경우, 모두 1로 바꿔준다. 
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(arr[m][n][h] == 1) {
						// 좌우
						if(m+1<M && arr[m+1][n][h]==0) {
							arr[m+1][n][h]=1;
							changed++;
							ripe++;
						}
						if(m-1>=0 && arr[m-1][n][h]==0) {
							arr[m-1][n][h]=1;
							changed++;
							ripe++;
						}
						// 앞뒤
						if(n+1<N &&arr[m][n+1][h]==0) {
							arr[m][n+1][h]=1;
							changed++;
							ripe++;
						}
						if(n-1>=0 && arr[m][n-1][h]==0) {
							arr[m][n-1][h]=1;
							changed++;
							ripe++;
						}
						// 위아래
						if(h+1<H && arr[m][n][h+1]==0) {
							arr[m][n][h+1]=1;
							changed++;
							ripe++;
						}
						if(h-1>=0 && arr[m][n][h-1]==0) {
							arr[m][n][h-1]=1;
							changed++;
							ripe++;
						}
					}
					
				}
			}
		}
		
		return dfs(day+1, changed, ripe);
	}
}
