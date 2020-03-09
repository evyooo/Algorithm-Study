package study_samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16637
/* 
 * 길이가 N인 수식이 있다. 수식은 0보다 크거나 같고, 9보다 작거나 같은 정수와 연산자(+, -, ×)로 이루어져 있다. 
 * 연산자 우선순위는 모두 동일하기 때문에, 수식을 계산할 때는 왼쪽에서부터 순서대로 계산해야 한다. 예를 들어, 3+8×7-9×2의 결과는 136이다.
	수식에 괄호를 추가하면, 괄호 안에 들어있는 식은 먼저 계산해야 한다.
	
	단, "괄호 안에는 연산자가 하나만" 들어 있어야 한다. 예를 들어, 3+8×7-9×2에 괄호를 3+(8×7)-(9×2)와 같이 추가했으면, 식의 결과는 41이 된다. 
	하지만, 중첩된 괄호는 사용할 수 없다. 즉, 3+((8×7)-9)×2, 3+((8×7)-(9×2))은 모두 괄호 안에 괄호가 있기 때문에, 올바른 식이 아니다.
	
	수식이 주어졌을 때, 괄호를 적절히 추가해 만들 수 있는 식의 결과의 '최댓값'을 구하는 프로그램을 작성하시오. 
	추가하는 괄호 개수의 제한은 없으며, 추가하지 않아도 된다.
	
	입력 : 첫째 줄에 수식의 길이 N(1 ≤ N ≤ 19)가 주어진다. 둘째 줄에는 수식이 주어진다.수식에 포함된 정수는 모두 0보다 크거나 같고, 9보다 작거나 같다
	출력 : 첫째 줄에 괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력한다.
	
 * */
/*풀이 전략?
 * 모든 가능성 다해보고 최댓값 구하는 문제 --> 다이나믹 프로그래밍 (x)
 * dfs(재귀함수)로 푸는 문제이다.
 * 
 * 3+8*7-9*2
 * 가능한 괄호 조합 : (3+8), (8*7), (7-9), (9*2)
 * 위 조합 중에서 하나도 선택 안할 수 있음
 * 단 숫자가 겹쳐서는 안됨. 즉 (3+8) 선택했으면 (8*7) 선택 불가 
 * 즉, 
 * */
public class _01_16637 {
	static int N;
	static char[] input;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		
		dfs(1,input[0]-'0',0, false);
		System.out.println(max);
		
	}
	
	static void dfs(int op_indx, int val, int pre_val, boolean wasBrace) {
		if(op_indx >= N) {
			if(max < val) {
				max = val;
			}
			return;
		}
		
		// 이 연산자에 대해서는 괄호를 치지 않을 경우
		dfs(op_indx+2, cal(val, input[op_indx], input[op_indx+1]-'0'), val, false);
		
		// 현재 괄호를 칠수 있는지 검사 -> 괄호 치는 경우
		if(op_indx >1 && !wasBrace) {
			dfs(op_indx+2, cal(pre_val, input[op_indx-2], cal(input[op_indx-1]-'0',
					input[op_indx], input[op_indx+1]-'0')), 0, true);
			
		}
	}
	
	static int cal(int a, char op, int b) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
    }
}
