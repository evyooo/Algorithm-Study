//실행이 안 되고
//뭔가 많이 잘못 됐지만..
//심지어 계속 고민하다 다른 코드도 참고해서 짰지만..
//뭔가 잘못 됐지만 올려요...

import java.util.*;

public class a16637 {
	static int max = -240000000;

	static int cal(char c, int num1, int num2) {
		int res=0;
		if(c=='+') {
			res=num1+num2;
		}else if(c=='-') {
			res=num1-num2;
		}else if(c=='*') {
			res=num1*num2;
		}
		return res;
	}

	static void dfs(int idx, int result, int[] a, char[] b, int n, int j, int k) {
		if (idx >= k) {
			if (result > max)
				max = result;
			return;
		}
		int soo = cal(b[idx], result, a[idx + 1]);
		dfs(idx + 1, soo, a, b, n, j, k);

		if (idx + 1 < k) {
			int ret1 = cal(b[idx + 1], a[idx + 1], a[idx + 2]);
			int ret2 = cal(b[idx], result, ret1);
			dfs(idx + 2, ret2, a, b, n, j, k);
		}

	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		kbd.nextLine();
		String s = kbd.nextLine();
		int[] a = new int[10];
		char[] b = new char[10];
		int i, j = 0, k = 0;

		for (i = 0; i < n; i++) {
			if (n % 2 == 0) {
				b[j] = s.charAt(i);
				j++;
			} else {
				a[k] = s.charAt(i) - '0';
				k++;
			}
		}

		int result = a[0];
		if (n == 1) {
			System.out.println(result);
		} else {
			dfs(0, result, a, b, n, j, k);
			System.out.println(max);
		}

	}

}
