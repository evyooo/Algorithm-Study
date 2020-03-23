import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    private static int M, N, H;
    private static int[][][] box;
    private static int[] dirX = {0, 1, 0, -1, 0, 0}; // X 좌표
    private static int[] dirY = {1, 0, -1, 0, 0, 0}; // Y 좌표
    private static int[] dirZ = {0, 0, 0, 0, 1, -1}; // Z 좌표
 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        box = new int[H][N][M];
        // buffer read 로 3차원 배열의 좌표 받아오기.
 
        //3차원 배열 채우기
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for(int k=0 ; k<M ; k++) {
                    box[i][j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }
        }
        
        
        //큐를 사용하여 익은 토마토를 순서대로 큐에 넣기
        Queue<Tomato> queue = new LinkedList<>();
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++) {
                for(int k=0 ; k<M ; k++){
                    if (box[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
 
        //큐 bfs 탐색
        bfs(queue);
 
 
        //box에 0이 존재하면 오류 만들기
        int count = 0;
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0 ; k<M ; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    //토마토가 최고로 익은 횟수가 count 값이 됨
                    if (count < box[i][j][k]) {
                        count = box[i][j][k];
                    }
                }
            }
        }
        //답
        System.out.println(count-1);
    }
 
    private static void bfs(Queue<Tomato> queue){
        while(!queue.isEmpty()){
            Tomato front = queue.peek();
            queue.poll();
 
            for(int i=0 ; i<6 ; i++){ // 익은 토마토 주변 6방향
                int newH = front.getH() + dirZ[i];
                int newN = front.getN() + dirY[i];
                int newM = front.getM() + dirX[i];
 
                if((0 <= newH && newH < H) && (0 <= newN && newN < N) && (0 <= newM && newM < M)){
                    if(box[newH][newN][newM] == 0){b
                        box[newH][newN][newM] += box[front.getH()][front.getN()][front.getM()] + 1;
                        queue.offer(new Tomato(newH, newN, newM));
                    }
                }
            }
        }
    }
 
    public static class Tomato{
        int h, n, m;
 
        Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
 
        int getH(){return h;}
 
        int getN(){return n;}
 
        int getM(){return m;}
    }
}
