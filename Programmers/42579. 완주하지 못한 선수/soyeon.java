class Solution {
    public String solution(String[] participant, String[] completion) {
        //동명이인이 있을 수 있으므로 set은 사용 불가 
    	String answer = "";
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        for(int i=0;i<participant.length;i++) {
        	if(map.containsKey(participant[i])) {
        		map.put(participant[i], map.get(participant[i])+1);
        	}
        	else {
        		map.put(participant[i], 1);
        	}
        }
        
        for(int i=0;i<completion.length;i++) {
        	if(map.get(completion[i])==1) {
        		map.remove(completion[i]);
        	}
        	else {
        		map.put(completion[i], map.get(completion[i])-1);
        	}
        }
        Set<String> set= map.keySet();
        Iterator it=set.iterator();
        return it.next().toString();
    }
}
