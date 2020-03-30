import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int max=0;
		List<Integer> answer=new ArrayList<Integer>();
		for(int i=n;i>=n/2;i--) { //100-60이나 100-40이나 같음
			List<Integer> list=new ArrayList<Integer>();
			list.add(n);
			int A=n;
			int B=i;
			while(true) {//list를 모두 구해본다
				if(A<0) 
					break;
				int temp=A;
				if(B>=0)
					list.add(B);
				
				A=B;
				B=temp-A;
			}
			
			if(max<list.size()) {//max 사이즈 업데이트
				max=list.size();
				answer.clear();
				for(int j=0;j<list.size();j++) {
					answer.add(list.get(j));
				}
			}
		}
		System.out.println(answer.size());
		for(int i=0;i<answer.size();i++) {
			System.out.print(answer.get(i)+" ");
		}
	}
}
