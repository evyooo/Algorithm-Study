import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int arr[][]=new int[k+1][n+1];
        arr[0][0]=1;// arr[k][n]: k개를 가지고 n을 만듦
        
        for(int i=1;i<=k;i++){
        	for(int j=0;j<=n;j++){
        		for(int l=0;l<=j;l++){
        			arr[i][j]+=arr[i-1][j-l];
        			arr[i][j]%=1000000000;
        		}
        	}
        }
        System.out.println(arr[k][n]);
    }
}
