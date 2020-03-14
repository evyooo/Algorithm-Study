def solution(bridge_length, weight, truck_weights):

    # count : 소요 시간 
    # arr : 다리의 길이만큼 배열 생성
    # current : 현재 다리 위의 무게의 합
    
    count = 0 
    arr = bridge_length * [0]
    current = 0 

    while True:
        #  맨 뒤 트럭 나가기
        current -= arr.pop() 
        
        if (truck_weights[0] + current) <= weight:
        #  맨 앞에 새 트럭 추가
            arr.insert(0, truck_weights.pop(0)) 
            current += arr[0]
        else:
            arr.insert(0, 0)
            
        count += 1
        
        #  대기 트럭이 더이상 없으면 break
        if len(truck_weights) == 0:
            break

	#  지금까지 소요시간 + 마지막 트럭이 다리를 끝까지 건너는데 걸리는 시간 리턴
    return count + bridge_length 