class Solution {
    public String solution(String[] participant, String[] completion) {
        Map <String, Integer> hm =new HashMap<>();
        int val=0;
        String answer = "";
        
        //participant 배열
        for (String part: participant) {
        	//해시 맵에 해당 값이 없을 경우 value를 1로
        	if(hm.get(part)==null)
        		hm.put(part,1);
        	//해시 맵에 해당 값이 있으면 value를 +1
        	else {
        		val=hm.get(part)+1;
        		hm.put(part, val);
        	}
        }
        
        //completion 배열
        for (String comp: completion) {
        	//해시 맵의 완주자 값을 확인하여 value -1
        	val=hm.get(comp)-1;
        	hm.put(comp, val);
        }
        
        for(String key: hm.keySet()) {
        	//key의 value값이 1이면 완주 하지 못한 것임
        	if(hm.get(key)==1)
        		answer=key;
        }
        return answer;
    }
}
