import java.util.*;
class Solution {
    public int[] solution(int[] heights) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<heights.length;i++) {
        	list.add(find(heights, i));
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    public static int find(int[] heights, int index) {
    	int ans=0;
    	for(int i=index-1;i>=0;i--) {
    		if(heights[i]>heights[index])
    			return i+1;
    	}
    	return ans=0;
    }
}
