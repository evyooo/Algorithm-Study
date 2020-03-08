class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    answer=false;
                    return answer;
                }else if(phone_book[i].startsWith(phone_book[j])){
                    answer=false;
                    return answer;
                }
            
            }         
        }

        return answer;
    }
}
//해시로 어떻게 푸나용.. ㅇ_ㅇ..
//사실 해시 부분 넘 잘 모르겠어요.. 공부를 열심히..
