/*다른건 괜찮은데 테이스케이스 5랑 8에 시간 초과 뜨네요 ㅠㅠ*/

import java.util.*;

class Solution {
    static String[] number;
	static boolean[] check;
	static StringBuilder sb;
	static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<String> select = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        number = numbers.split("");
		check = new boolean[number.length];
        for(int i=0; i<check.length; i++) {
			check[i] = false;
		}
        
        // 모든 조합구하기
		makecomb(0,0,0);
        for(int i=0; i< select.size(); i++) {
			String[] selected = select.get(i).split("");
			perm(selected,0);
		}
        answer = arr.size();
        return answer;
    }
    
    static void makecomb(int k, int dept, int checkcount) {
		if(dept==number.length) {
			sb = new StringBuilder();
			
			// check된 숫자 -> select 배열에 담는다.  
			for(int i=0; i<number.length; i++) {
				if(check[i]==true) {
					sb.append(number[i]);
				}
			}
			if(!select.contains(sb.toString()) && !sb.toString().equals("")) {
				select.add(sb.toString());
			}
			
			return;
		}
		
		// k를 선택함
		check[k] = true;
		makecomb(k+1, dept+1, checkcount+1);
		
		// k를 선택 안함 
		check[k] = false;
		makecomb(k+1, dept+1, checkcount);
		
		
	}
	
	// 순열 : k-1 번째까지 순서 정해진 상황
	static void perm(String[] select, int k) {
		
		if(k==select.length-1) {
			sb = new StringBuilder();
			for(String s : select) {
				sb.append(s);
			}
			
			int makeNum = Integer.parseInt(sb.toString());
//			System.out.println(sb.toString());
			if(isPrime(makeNum) && !arr.contains(makeNum) && makeNum!=0 && makeNum!=1) {
//				System.out.println(makeNum);
				arr.add(makeNum);
			}
			
			return;
		}
		
		for(int i=k; i<select.length; i++) {
			swap(select,k, i);
			perm(select, k+1);
			swap(select,k, i);
		}
		
		
	}
	
	// prime인지 확인하는 함수 
	static boolean isPrime(int num) {
		int primeCount=0;
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				primeCount++;
			}
		}
		
		if(primeCount==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	static void swap(String[] select,int a, int b) {
		String temp = select[a];
		select[a] = select[b];
		select[b] = temp;
	}
}
