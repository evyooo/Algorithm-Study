import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len=participant.length;
        for(int i=0;i<len;i++){
            if(map.containsKey(participant[i])){
                int result = map.get(participant[i]);
                map.put(participant[i],result+1);
            }else{
                map.put(participant[i],1);
            }
        }
        
        for(int i=0;i<len-1;i++){
            int result = map.get(completion[i]);
            map.put(completion[i],result-1);
        }
        
        for(int i=0;i<len;i++){
            if(map.get(participant[i])!=0)
                answer=participant[i];
        }
           
        return answer;
    }
}

//해시에 대한 개념을 잘 몰라서 ㅠ_ㅠ 이것도 두세시간 가량 풀다가 다른 분의 코드를 참조했습니다.
// https://hanswsw.tistory.com/11
// arrays.sort로 푸는 거 신박한 것 같아요!
