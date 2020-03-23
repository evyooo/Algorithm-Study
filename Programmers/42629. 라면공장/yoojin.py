import heapq

def solution(stock, dates, supplies, k):
    answer = 0
    index = 0
    h = []
    
    # 하루에 1톤씩 사용하니까 stock이 k를 넘기기 전까지 계속
    while(stock < k):
        for i in range(index, len(dates)):
            if dates[i] <= stock:
                # maxheap으로 사용하기위해 -를 달아줌
                heapq.heappush(h, -supplies[i])
                idx = i + 1
            else:
                break
        
        stock -= heapq.heappop(h)
        answer += 1
    
    return answer
