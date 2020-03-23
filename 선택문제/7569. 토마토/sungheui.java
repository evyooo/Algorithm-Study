//제가 bfs구현을 어떻게 접근해할지 몰라서 참조해서 구현했습니다. 


import java.util.*;


public class Main {
	
    static int[] dx = { -1, 0, 1, 0, 0, 0 };  // 익은 토마토 주변으로 6개의 방향(좌,우,위,아래,앞,뒤)을 탐색해야 함.
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
 
    public static void main(String[] args) {
    	
    	
        Scanner input = new Scanner(System.in);
        
        
        int m = input.nextInt();
        int n = input.nextInt();
        int h = input.nextInt();
 
        Queue<Point> q = new LinkedList<Point>();
 
        int[][][] arr = new int[h][n][m]; // 토마토 상태 배열 
        int[][][] dist = new int[h][n][m]; // 날 수 저장 
 
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = input.nextInt();  // 토마토 상태 입력받기. 
                    if (arr[k][i][j] == 1) // 익은 토마토를 기준으로 bfs를 할 것이기에 해당 좌표를 큐에 삽입한다. 
                        q.add(new Point(k, i, j));
                }
            }
        }
 
        while (!q.isEmpty()) {  // 큐가 비어있지 않은 동안 실행한다. 
            Point t = q.remove();  //토마토 상태가=1인 좌표를 큐에서 꺼낸다. 
            int x = t.x;
            int y = t.y;
            int z = t.z;
            for (int i = 0; i < dy.length; i++) {
            	// 이동한 좌표 
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
               // 이동한 좌표가 해당 범위를 만족할시 실행.
                if (0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m) {
                    if (arr[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) 
                    {   arr[nx][ny][nz]=1;
                        q.add(new Point(nx, ny, nz));
                        dist[nx][ny][nz] = dist[x][y][z] + 1; //날 수 세기(인접한 노트 방문) 
                    }
                }
            }
        }
 
        int min = 0;
 
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (min < dist[k][i][j]) 
                        min = dist[k][i][j]; // 최소 날짜를 출력하기 위해 min값을 찾는다.
                }
            }
        }
 
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[k][i][j] == 0) {
                        min = -1; // 만약 아직 상태가0(익지 않음)이 있다면 -1을 출력한다. 
                    }
                }
            }
        }
 
        System.out.println(min);
 
 
    }
}

class Point {
    int x;
    int y;
    int z;
 
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
 
