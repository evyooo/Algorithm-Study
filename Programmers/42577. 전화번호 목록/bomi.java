class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map <String,Integer> hm= new HashMap<>();
        
        //phone_book 배열 전체 탐색
        for (int i=0; i<phone_book.length;i++) {
        	//phone_book 배열 내에서 각 String 탐색
        	for (int j=1;j<phone_book[i].length();j++) {
        		//phone_book의 모든 substring hashmap에 저장.
        		hm.put(phone_book[i].substring(0, j),1);
        	}
        }
        //phone_book 배열 전체 다시 탐색
        for( int i=0; i<phone_book.length;i++) {
        	//hashmap내에 phone_book의 원소와 같은 값이 있으면 false. break
        	if(hm.containsKey(phone_book[i])) {
        		answer=false;
        		break;
        	}
        	else
        		hm.put(phone_book[i],1);
        }
        
        return answer;
        
    }
}
