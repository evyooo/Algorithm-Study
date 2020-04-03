class Solution { //뭔가 막 의식의 흐름대로 짜서 코드가 상당히 지저분합니다.. ㅎㅎ ^^;;
    public int[] solution(int[] answers) {
        int len = answers.length; //우선 answers배열의 길이를 받을겁니다.
		int ans1 = 0, ans2 = 0, ans3 = 0;
		int[] a1 = new int[len]; //세가지 배열에 값들을 넣어줄 거에요.
		int[] a2 = new int[len];
		int[] a3 = new int[len];
		int k1 = 1, k2 = 1;
		for (int i = 0; i < len; i++) { //그냥 무대뽀로 다 넣습니다.
			a1[i] = k1;
			k1++;
			if (k1 == 6)
				k1 = 1;
			if (i % 2 == 0)
				a2[i] = 2;
			else {
				a2[i] = k2;
				if(k2==1)
					k2++;
				k2++;
				if(k2==6)
					k2=1;
			}
			if(i%10==0||i%10==1)
				a3[i]=3;
			else if(i%10==2||i%10==3)
				a3[i]=1;
			else if(i%10==4||i%10==5)
				a3[i]=2;
			else if(i%10==6||i%10==7)
				a3[i]=4;
			else if(i%10==8||i%10==9)
				a3[i]=5;
			if(a1[i]==answers[i])// answers배열과 같은 값은 ans에 +1
				ans1+=1;
			if(a2[i]==answers[i])
				ans2+=1;
			if(a3[i]==answers[i])
				ans3+=1;
		}
		
		int max=ans1; 
		if(max<=ans2)
			max=ans2;
		if(max<=ans3)
			max=ans3;
		
		int[] answer0 = new int[3]; //최대들을 구해주는 함수입니다.. 정말 막 짠 것 같지만 용서해주세요 ㅎㅎ..
		if(max==ans1)
			answer0[0]=1;
		if(max==ans2) {
			if(ans2==ans1)
				answer0[1] =2;
			else
				answer0[0]=2;
		}
		if(max==ans3) {
			if(ans3==ans2 && ans3==ans1)
				answer0[2] =3;
			else if(ans3==ans2)
				answer0[1]=3;
			else if(ans3==ans1)
				answer0[1]=3;
			else
				answer0[0]=3;
		}
		int k=0;
		for(int i=0;i<3;i++) {
			if(answer0[i]!=0)
				k++;
		}
		int answer[] = new int[k];
		for(int i=0;i<k;i++)
			answer[i]=answer0[i]; //answer0에 답들을 받고 0 빼고 출력합니다 ㅎㅎ.. 

		return answer;
    }
}
