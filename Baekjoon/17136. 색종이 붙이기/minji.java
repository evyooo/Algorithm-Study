/*풀려고 며칠 동안 시도해봤지만 ㅠ_ㅜ 테스트케이스는 통과 되는데 20%에서 계속 오류가 나서 백준 코드를
풀이 설명하려고 합니다. */

//브루트포스 방법으로 풀어져 있습니다.

import java.util.*;
public class Main {
    static int n = 10;
    static int[][] a = new int[n][n]; 
    static int[] avail = {0,5,5,5,5,5};//색종이의 갯수를 5개씩 할당해줍니다.
    /*
    0 1 2 3 4 5 6 7 8 9
    10 11 12 13 14 ...
    ...
    90 91 92 93 ...  99 
    를 칸 이름이라고 생각해줍니다. 얘가 z에 0 부터 대입할 겁니다. 100에 ans
    */
    static int go(int z) {
        if (z == n*n) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j] == 1) return -1;
                }
            }
            return 0;
        }
        int x = z/n; //z를 n으로 나누어 열을 표현해 줍니다.
        int y = z%n; //z를 n으로 나눈 나머지로 행을 표현해 줍니다.
        if (a[x][y] == 0) {
            return go(z+1); //a[x][y]가 0 이면 색종이 안 붙여줘도 되니까  go(z+1)
        }
        int ans = -1;
        
        for (int k=5; k>=1; k--) { //큰 색종이부터 붙여봄
            if (avail[k] > 0) { //색종이 있을 때
                if (x+k-1 < n && y+k-1 < n) {
                    boolean ok = true;
                    for (int i=x; i<x+k; i++) {
                        for (int j=y; j<y+k; j++) {
                            if (a[i][j] == 0) {//종이 붙이는 만큼 다 1인지 확인 0이면 ok=false, break
                                ok = false;
                                break;
                            }
                        }
                        if (ok == false) {
                            break;
                        }
                    }
                    if (ok) {
                        for (int i=x; i<x+k; i++) {
                            for (int j=y; j<y+k; j++) {
                                a[i][j] = 0; //색종이 지나간 자리 0 으로
                            }
                        }
                        avail[k] -= 1; //색종이 썼으니까
                        int temp = go(z+1); //1칸 옆으로 가서 go한거
                        avail[k] += 1; //색종이 다시 복구 (다시 원래놈에서 해야되니까)
                        if (temp != -1) { //temp에서 색종이 썼으면 temp!=-1이겠지
                            if (ans == -1 || ans > temp+1) { //temp +1은 이번 실행 포함이라 ans=-1이면 맨처음..  
                                ans = temp+1;
                            }
                        }
                        for (int i=x; i<x+k; i++) {
                            for (int j=y; j<y+k; j++) {
                                a[i][j] = 1; //색종이 지나간 자리 다시 1으로, 다시 다른 놈 실행해야되니까
                            }
                        }
                    }
                }
            }
        }
        return ans;
        //ans=-1로 해놨는데 ok=false여서 5개 색종이에서 다 break되면 return ans(-1)
        //아닐때 ans는 z=n*n일 때 0에서 하나씩 더함..
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(0)); //브루트포스 함수를 실행합니다.
    }
}
