import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        Map<String, Integer> h = new HashMap<>(); //참가자이름, 동명이인수
        
        // 참가자들 해쉬맵에 추가
        for(String part : participant){    // 동명이인 없을 경우
            if(!h.containsKey(part)){
                h.put(part,1);
            }else{      // 동명이인 있을 경우
                int same =h.get(part)+1;
                h.put(part,same);
            }
        }
        
        // 완주한 사람들 해쉬맵에서 빼기
        for(String comp:completion){
            if(h.containsKey(comp)){
                h.put(comp, h.get(comp)-1);
            }
        }
        
        for(String key: h.keySet()){
            if(h.get(key)>0){
                answer =key;
            }
        }
        
        return answer;
    }
}
