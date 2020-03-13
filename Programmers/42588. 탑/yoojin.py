def solution(heights):
    answer = []
    for i in range(len(heights)):
        j = i - 1
        flag = 0
        while j >= 0:
            if heights[i] < heights[j]:  # 크기 비교
                answer.append(j+1)
                flag = 1
                break
            j -= 1
        if flag == 0:  # if none is appended
            answer.append(0)

    return answer
