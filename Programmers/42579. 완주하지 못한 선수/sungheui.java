import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
   	String answer="";
	
		
		HashMap <String, Integer> map = new HashMap <String, Integer>();
		
        //해시맵 생성
		for(String p: participant)
		{
			if(map.containsKey(p)) //동명이인 있을 경우
				map.put(p, map.get(p)+1);  
			else
				map.put(p, 1); 
		}
        //완주한 사람 해시맵에서 제거
		for(String c: completion)
		{
			if(map.containsKey(c))
				map.put(c,map.get(c)-1 );
			
		}
        //제거 후 남아있는 사람 출력
		for(String key: map.keySet())
		{
			Integer value=map.get(key);
			if(value!=0)
				answer=key;
		}
		
		
		
		return answer;
		
    }
}
