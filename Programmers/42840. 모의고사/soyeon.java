class Solution {
    public int[] solution(int[] answers) {
        int student1[]= {1, 2, 3, 4, 5};
        int student2[]= {2, 1, 2, 3, 2, 4, 2, 5};
        int student3[]= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int ans1=0, ans2=0, ans3=0;
        for(int i=0;i<answers.length;i++) {
        	if(student1[i%5]==answers[i]) ans1++;
        	if(student2[i%8]==answers[i]) ans2++;
        	if(student3[i%10]==answers[i]) ans3++;
        }
        if(ans1==ans2 && ans2==ans3) {
        	int[] answer={1, 2, 3};
        	return answer;
        }
        else if(ans1==ans2) {
        	if(ans1>ans3) {
        		int[] answer={1, 2};
            	return answer;
        	}
        	else {
        		int[] answer={3};
            	return answer;
        	}
        }
        else if(ans2==ans3) {
        	if(ans1>ans3){
        		int[] answer={1};
            	return answer;
        	}
        	else {
        		int[] answer={2, 3};
            	return answer;
        	}
        }
        else if(ans3==ans1) {
        	if(ans1>ans2) {
        		int[] answer={1, 3};
            	return answer;
        	}
        	else {
        		int[] answer={2};
            	return answer;
        	}
        }
        else {
        	if(ans1>ans2 && ans1>ans3) {
        		int[] answer={1};
            	return answer;
        	}
        	if(ans2>ans1 && ans2>ans3) {
        		int[] answer={2};
            	return answer;
        	}
        	if(ans3>ans1 && ans3>ans1) {
        		int[] answer={3};
            	return answer;
        	}
        }
        int[] answer={};
        return answer;
    }
}
