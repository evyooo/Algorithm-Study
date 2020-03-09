/*괄호치기*/
구현하진 못했지만ㅜㅜ 제가 생각한 방식은요...!.!
가능한 괄호 수를 1,2 개 늘려가면서 brute force하게 확인하는 겁니다.
저는 수식(연산자, 피연산자) 모두 한 배열로 생성하고 짝수인덱스에 피연산자, 홀수번 연산자가 있다는 점을 활용해서 재귀 사용하고... 구해보려고 했습니다

package samsung;


import java.util.Scanner;
import java.util.StringTokenizer;


public class Main3 {
	
	
	static int n;
	static char[] arr;
	static String get;
	
	
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	  Scanner input= new Scanner(System.in);
	  
	
	  n=input.nextInt();
	  get= input.next();
	  
	  arr= new char[n];
	  
	  
	  //int num=n/2+1 ;
	  //int op=num-1;
	  
	  for(int i=0;i<arr.length;i++) // 배열에 수식 넣기 
	  {
		 
			  arr[i]=get.charAt(i);
		  
	  }
		  
   cal(arr);
   
	
	
	}
	static void cal(char[] arr) {
		
		char a, b;
		char op;
		int temp;
		int j=1;

		
		 while(j< (n/2+1)/2)//가능한 괄호 개수 
		 {
				for(int i=0;i<arr.length;i++)
				{
					if(i%2==0) //숫자 
					{
						a=arr[i];
						
						if(i+2<arr.length)
						{
							b=arr[i+2];
							
							System.out.println(a+" "+b);
						}
						
						
					}
					else // 연산자 
					{ 
						if(i+1 <arr.length)
					    {
						 op=arr[i+1];
							System.out.println(op);
							
					    }
						
					}
					
					
					
				}
				
				
				j++;
				
		 }
		
	
		
		
		
		
		
	}
	static int solve(int a, int b, char op)
	{
		int re=0;
		
		switch(op) {
		
		case '+':
			re= a+b;
			break;
		case '-':
			re= a-b;
			break;
		case '*':
			re= a*b;
			break;
		case '/':
			re= a/b;
			break;
			
		}
		
		return re;
		
		
		
		
	}
	  
	
	 


	}


