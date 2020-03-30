import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<commands.length;i++) {
        	int index_start=commands[i][0];
        	int index_end=commands[i][1];
        	int k=commands[i][2];
        	//자른 후 배열 만들기
        	int newarray[]=new int[index_end-index_start+1];
        	for(int j=index_start-1;j<=index_end-1;j++) {
        		newarray[j-(index_start-1)]=array[j];
        	}
        	Arrays.parallelSort(newarray);//정렬
        	list.add(newarray[k-1]);
        }
        
        //List를 array로 만들어 리턴
    	return list.stream().mapToInt(i->i).toArray();
    }
}
