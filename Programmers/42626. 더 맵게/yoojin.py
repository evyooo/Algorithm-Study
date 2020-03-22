import heapq

def solution(scoville, K):
    
    #  scoville을 minheap 구조로 바꿈
    heapq.heapify(scoville)
    count = 0

    while len(scoville) > 1:
        count += 1

        #  앞에서 부터 작은거 두개 뺌
        f = heapq.heappop(scoville)
        s = heapq.heappop(scoville)

        heapq.heappush(scoville, f+s*2)
        
        #  만약 scoville의 가장 작은 값이 K보다 크거나 같을 경우, 더 할 필요 없음
        if scoville[0] >= K:
            return count

    return -1