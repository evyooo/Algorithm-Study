def solution(li):
    # 학생1, 2, 3의 점수
    score = [0, 0, 0] 

    # 최소공배수인 40에 맞춰서 규칙 길이 늘이기
    st1 = [1, 2, 3, 4, 5] * 8
    st2 = [2, 1, 2, 3, 2, 4, 2, 5] * 5 
    st3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 4


    # brute force 40개씩 끊어서
    for i in range(len(li)):
        rem = i % 40
        if (st1[rem] == li[i]):
            score[0] += 1  
        if (st2[rem] == li[i]):
            score[1] += 1
        if (st3[rem] == li[i]):
            score[2] += 1
         

    answer = []
    maxnum = max(score)

    for i in range(3):
        if score[i] == maxnum:
            if i == 0:
                answer.append(1)
            elif i == 1:
                answer.append(2)
            else:
                answer.append(3)

    return answer