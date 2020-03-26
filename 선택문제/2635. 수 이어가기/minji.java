import java.util.*;
public class a2635 {
	static int go(int n1, int n2) { //두번째 수에 따른 최대 개수를 출력해주는 함수 go
		int num=2; //기본 두 개니까
		while(true) {
			int n3 = n1 - n2; // 다음 수를 n3
			if(n3<0) //n3<0일 때 break
				break;
			num++;
			n1=n2;
			n2=n3;
		}
		return num;
	}
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int max = go(n, n-1); //처음 max에 얘른 넣어줌
		int soo = n-1;        //두 번째 수 = n-1부터 넣었었는데 n부터 넣으면 되는듯..
		for(int i=n;i>0;i--) { //1일 때 n일 때임.
			int temp = go(n,i);
			if(temp>max) {
				max=temp;
				soo=i;
			}
		}
		System.out.println(max); //max 출력
		int num=2;
		System.out.print(n+" "+soo+" "); // 이 때의 수들 출력
		while(true) {
			int n3 = n - soo;
			if(n3<0)
				break;
			System.out.print(n3+" ");
			n=soo;
			soo=n3;
		}
		System.out.println();
		
	}

}
