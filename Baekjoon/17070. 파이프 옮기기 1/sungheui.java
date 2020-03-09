import java.util.Scanner;

public class Main {
	
	static int [][] arr;
	static int n;
	static int count=0;
	
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		Scanner input= new Scanner(System.in);
		
	    n=input.nextInt();
		
		arr= new int[n][n];  
		
		for(int i=0;i<n;i++)
		{
			 for(int j=0;j<n;j++)
				 arr[i][j]=input.nextInt();  // 입력 
			  
		}

		
		cal(0,1,1);

		 System.out.println(count);
		
		 
	}
	 public static void cal(int i, int j,int dir) {
		 //현 상태: 가로=1, 대각선=2, 세로=3
	
		if(i==n-1 && j==n-1)  // (N,N)에 도착하면 카운트
		{
			 count++;
			
			 return;
			 
			 
		}
		
		// n+1단계에서 왼쪽이 비어야 할 경우 --> n단계에서 가로 또는 대각 
		if ((dir ==1 || dir==2) && check(i, j + 1) && arr[i][j + 1] == 0) {
			cal(i, j + 1, 1);
		}
		// n+1단계에서 아래이 비어야 할 경우 --> n단계에서 세로 또는 대각선  
		if ((dir ==2 || dir==3) && check(i + 1, j) && arr[i + 1][j] == 0) {
			cal(i + 1, j, 3);
		}
		// n+1단계에서 세 방향이 비어야 하는 경우 --> n단계에서 가로, 세로, 대각선 
		if (check(i + 1, j + 1) && arr[i + 1][j] == 0 && arr[i + 1][j + 1] == 0 && arr[i][j + 1] == 0) {
			cal(i + 1, j + 1, 2);
		}


				 
	}
	
	 public static boolean check(int i, int j){ // n+1단계를 실행했을 때 범위를 초과하는지 여부 
		
		if(i>n-1 || j>n-1 )
		   return  false;
		else
			return true;
		
		
	
	}

}
