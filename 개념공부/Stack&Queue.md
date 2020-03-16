![stack_queue](https://user-images.githubusercontent.com/61494135/76713937-87736300-6767-11ea-9a48-1b003a9ad2d7.png)

## 스택(Stack)
- LIFO(Last In First Out) 구조
- 메서드

peek() : Stack에서 객체를 꺼내지는 않지만 top에 저장된 객체를 반환

push(Object item) : Stack에 객체를 저장

pop() : Stack의 top에 저장된 객체를 꺼낸다.

## 큐(Queue)
- FIFO(First In First Out) 구조
- 자바에서 데이터의 추가/삭제가 보다 쉬운 LinkedList로 구현
- 메서드

peek() : Queue에서 객체를 꺼내지는 않지만 front에 저장된 객체를 반환

add(Object o) : Queue에 객체를 저장

offer(Object o) : Queue에 객체를 저장

remove(): Queue의 front에 저장된 객체를 꺼낸다.

poll(): Queue의 front에 저장된 객체를 꺼낸다.
