def solution(phone_book):
    phone_book.sort(key=len)

    for i in range(len(phone_book) - 1):
        index = i + 1
        while index < len(phone_book):
            if hash(phone_book[i]) == hash(phone_book[index][:len(phone_book[i])]):
                return False
            index += 1

    return True