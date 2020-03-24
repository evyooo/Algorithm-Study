//ㅇ_ㅇ.. 뭔가 희안하게 푼거같아요.. 이상.
import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		String answer = "";
		int n = numbers.length;
		int[] b = new int[n];
		String[] num = new String[100000];
		for(int i=0;i<100000;i++)
			num[i]=""; //num String을 다 ""로 초기화해줬어요

		for (int i = 0; i < n; i++) {
			int na = numbers[i];
			if (na < 10) {
				b[i] = na * 1000 + na * 100 + na * 10 + na;// 5555 큰 자리 수 부터 같은 수를 뒤에 붙여줘서 네 자리수로 만들어주면
				num[b[i]] += String.valueOf(na);           // 값을 비교해볼 수 있어요.
			} else if (na < 100) {
				b[i] = na * 100 + na; // 9898
				num[b[i]] += String.valueOf(na); //num[b[i]] 에 String으로 na를 넣어줘요
			} else if (na < 1000) { // 3453
				b[i] = na * 10 + (na / 100); //다들 네자리수로 만들어줬어요.
				num[b[i]] += String.valueOf(na);
			} else if (na == 1000) { // 1000
				b[i] = na;
				num[b[i]] += String.valueOf(na);
			}
		}
		Arrays.sort(b);
		boolean[] check = new boolean[100000];

		for (int i = n - 1; i >= 0; i--) { // 처음에 중첩 for문으로 했더니 한 테스트케이스에서 시간초과가 나서
			if (check[b[i]] == false) {  //중첩 for문을 안 해도 되도록 코드를 바꿨어요. 지나간건 안 지나가게 check~
				answer += num[b[i]];
				check[b[i]] = true;
			}
		}

		boolean ok = true; // 테스트 11에서 0000이 0으로 출력되도록해주려고요
		for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) != '0')
				ok = false;
		}
		if (ok)
			return "0"; //0이면 0나와요~
		else
			return answer; 
	}

}

//처음에 중첩 for문으로 했을 때 시간이 엄청 오래걸렸는데 (1000~5000ms도 나왔는데)
//이렇게 짜니까 100ms 안팎으로 나오네요 햄복. 근데 코드가 길긴 좀 기네요 ㅠ_ㅜ 아쉽
