package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17136
// https://lshdv.tistory.com/81      <- 해설 1 (완전탐색)
// https://sophia2730.tistory.com/entry/Algorithm-%EB%B0%B1%EC%A4%8017136-%EC%83%89%EC%A2%85%EC%9D%B4-%EB%B6%99%EC%9D%B4%EA%B8%B0
// <- 해설2 (백트래킹)
// 완탐을 하려면 1x1의 색종이를 붙이고 모든 경우를 다 해 본후, 다시 돌아와서 2x2의 색종이를 붙이는 방식으로 붙여야 했기 때문에, dfs를 통해 풀었다.
public class _04_17136 {
	public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] paper = {0, 5, 5, 5, 5, 5};
    public static int[][] map = new int[10][10];
    public static int ans = Integer.MAX_VALUE, one_cnt = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                one_cnt += map[i][j];       //1의 개수 세기
            }
        }
        
      //r = 현재 row, cnt = 사용한 색종이수, total = 제거한 1의 개수 (덮은 1의 개수)
        Backtracking(0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	
	public static void Backtracking(int r, int cnt, int total) {
        if (ans <= cnt) return;      // 현재 값보다 색종이를 많이쓰면 가지치기 (경우의 수 제거)
        if (total == one_cnt) {      // 1을 다 덮은 경우 (제거한 경우)
            ans = Math.min(ans, cnt);
            return;
        }
        
        for (int i = r; i < 10; i++) {     // r(현재 행) 부터 시작
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    boolean flag = false;  //큰 색종이로 덮을 수 있으면 이후 색종이는 확인해 보지 않아도 된다
                    for (int k = 5; k >= 1; k--) {	// 5*5 종이부터 1*1 종이까지 검사 
                        if ((i + k) <= 10 && (j + k) <= 10 && paper[k] > 0) {
                            if (!flag) {		// flag == false
                                flag = check(i, j, k); //k*k 색종이를 덮을 수 있으면 check = true
                            }
                            if (flag) {			// flag == true
                                setVisited(i, j, k);
                                paper[k]--;
                                Backtracking(i, cnt + 1, total + k * k);
                                paper[k]++;
                                setVisited(i, j, k);
                            }
                        }
                    }
                    if (!flag) return;          //색종이를 못덮는 경우
                }
                if (map[i][j] == 1) return;     //덮고나서도 해당좌표를 못지우는경우
            }
        }
    }
 
    //size만큼의 색종이를 사용할 수 있는지 확인
    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
 
    //방문한 점을 XOR 연산 (같으면 0 다르면 1)
    public static void setVisited(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = map[i][j] ^ 1;
            }
        }
    }
//    public static void fill(int r, int c, int size, int state) {
//        for(int i=0; i<size; i++) {
//            for(int j=0; j<size; j++) {
//                a[r+i][c+j] = state;
//            }
//        }
//    }
}
