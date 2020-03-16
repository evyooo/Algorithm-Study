import java.util.Stack;
class Solution {
    public int[] solution(int[] heights) {
        Stack<Integer>stk=new Stack<>();
        int[] answer = new int[heights.length];
        for(int i=0;i<heights.length;i++) {
        	stk.push(heights[i]);
        	
        }
        while(!stk.isEmpty()) {
        	int tmp=stk.pop();
        	//System.out.println(stk.size());
        	
        	for(int i=stk.size();i>=0;i--) {
        		if(tmp<heights[i]) {
        			answer[stk.size()]=i+1;
        			break;
        		}
        	}
        	
        	
        }
        
		
		
		
        
        return answer;
    
    }
    }
