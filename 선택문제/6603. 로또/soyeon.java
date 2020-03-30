import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		while(true){
			if(n==0) break;
			
			int arr[]=new int[n];
			for(int i=0;i<n;i++) arr[i]=in.nextInt();
			int sum=(int)Math.pow(2, n)-1;
			while(sum>0){
				lotto(arr,sum,n);
				sum--;
			}
			System.out.println();
			n=in.nextInt();
		}
	}
	public static void lotto(int arr[],int sum,int n){
		String s=Integer.toBinaryString(sum);
		//System.out.println(s);
		LinkedList<String> list=new LinkedList<String>();
		StringTokenizer st=new StringTokenizer(s,"01",true);
		
		while(st.hasMoreTokens()){
			list.add(st.nextToken());
		}
		
		while(n!=list.size()){
			list.addFirst("0");
		}
		
		int cnt=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals("1")) cnt++;
		}
		
		if(cnt==6){
			for(int i=0;i<list.size();i++){
				if(list.get(i).equals("1"))
					System.out.print(Integer.parseInt(list.get(i))*arr[i]+" ");
			}
			System.out.println();
		}
		
	}
}

