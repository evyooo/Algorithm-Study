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
				c[i] = kbd.nextInt();

			for (i = 0; i < n; i++) {
				if (i < 6)
					a[i] = 1;
				else
					a[i] = 0;
				b[i] = a[i];
			}
			
			for (i = 0; i < n; i++) {
				if (a[i] == 1)
					System.out.print(c[i] + " ");
			}
			System.out.println("");

			while (true) {
				i1 = n;
				i2 = n;

				for (i = n - 1; i > 0; i--) {
					if (a[i] < a[i - 1]) {
						i1 = i - 1;
						break;
					}
				}

				if (i1 != n) {
					for (i = n - 1; i > i1; i--) {
						if (a[i] < a[i1]) {
							i2 = i;
							break;
						}
					}

					int temp = a[i1];
					a[i1] = a[i2];
					a[i2] = temp;

					j = 0;
					for (i = i1 + 1; i < n; i++) {
						b[n - 1 - j] = a[i];
						j++;
					}

					for (i = i1 + 1; i < n; i++) {
						a[i] = b[i];
					}
				}

				if (i1 == n && i2 == n) {
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
