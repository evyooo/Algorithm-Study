import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int i, j, i1, i2;
		Scanner kbd = new Scanner(System.in);

		while (true) {

			int n = kbd.nextInt();
			if(n==0)
				break;
			int a[] = new int[n];
			int b[] = new int[n];
			int c[] = new int[n];

			for (i = 0; i < n; i++)
				c[i] = kbd.nextInt(); //수를 입력받는다.

			for (i = 0; i < n; i++) {
				if (i < 6)
					a[i] = 1;
				else
					a[i] = 0;
				b[i] = a[i]; // 앞의 수 6개를 1, 나머지를 0 a[i]와 b[i]에 대입
			}
			
			for (i = 0; i < n; i++) {
				if (a[i] == 1) //a[i]가 1 이면 출력
					System.out.print(c[i] + " ");
			}
			System.out.println("");

			while (true) {
				i1 = n; 
				i2 = n;

				for (i = n - 1; i > 0; i--) { //n=7일 때를 예시로
					if (a[i] < a[i - 1]) { //a[i]가 a[i-1]보다 작을 때 즉 1111110 이면 6번째 1 과 7번째 0 i=6일 때
						i1 = i - 1; //i1=5 (마지막 1의 위치)
						break;
					}
				}

				if (i1 != n) { //i1이 n 이 아닐 때, 즉 0111111 이런식으로 0이 맨앞에 다 있지 않을 때
					for (i = n - 1; i > i1; i--) {//6이하 5초과 (위의 예시)
						if (a[i] < a[i1]) { 
							i2 = i; // i2=6
							break;
						}
					}

					int temp = a[i1]; //a[5]랑 a[6]바꿈
					a[i1] = a[i2];
					a[i2] = temp;

					j = 0;
					for (i = i1 + 1; i < n; i++) { // i1=5, i2=6   i=6일때
						b[n - 1 - j] = a[i];  // b[6]=a[6]=1
						j++;
					}

					for (i = i1 + 1; i < n; i++) { //i1+1부분에 a[i]=b[i]
						a[i] = b[i];
					}
				}

				if (i1 == n && i2 == n) {//위 식들 다 pass 즉 0111111 앞놈 다 0
					break;
				} else {
					for (i = 0; i < n; i++) {
						if (a[i] == 1)
							System.out.print(c[i] + " ");
					}
					System.out.println("");
				}
			}
			System.out.println("");
		}
	}

}
