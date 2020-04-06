import itertools

def prime_list(n):
    sieve = [True] * n
    m = int(n ** 0.5)
    for i in range(2, m+1):
        if sieve[i] == True:
            for j in range(i+i, n, i):
                sieve[j] = False

    return [i for i in range(2,n) if sieve[i] == True]

def solution(numbers):
    arr = []
    com = []
    for i in numbers:
        if i != '"':
            arr.append(i)

    for j in range(1,len(arr)+1):
        com += list(map("".join, itertools.permutations(arr, j)))

    com = list(set(com))
    for l in com:
        
    prime = prime_list(int(com[-1])+1)

    answer = 0

    for k in com:
        if int(k) in prime:
            answer += 1

    return answer
