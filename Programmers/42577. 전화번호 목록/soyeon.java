import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
    	Arrays.parallelSort(phone_book);
    	String start=phone_book[0];
        for(int i=1;i<phone_book.length;i++) {
        	if(phone_book[i].startsWith(start)) {
        		return false;
        	}
        	else {
        		start=phone_book[i];
        	}
        }
        return true;
    }
}
