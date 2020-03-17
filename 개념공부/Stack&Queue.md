![stack_queue](https://user-images.githubusercontent.com/61494135/76713937-87736300-6767-11ea-9a48-1b003a9ad2d7.png)

## 스택(Stack)
- LIFO(Last In First Out) 구조
- 메서드

peek() : Stack에서 객체를 꺼내지는 않지만 top에 저장된 객체를 반환

push(Object item) : Stack에 객체를 저장

pop() : Stack의 top에 저장된 객체를 꺼낸다.

* 직접 구현할 때 <br>
배열 구현의 장단점:
배열의 장점은 우선 구현이 쉽고 데이터의 접근 속도 즉 조회가 빠르다는 점입니다. 하지만 단점은 항상 최대 개수를 정해놔야지 사용이 가능하다는 점입니다.
즉 구현과 접근은 좋지만 다른 프로젝트에서 활용할 때는 여러모로 불편합니다.<br>
링크드 리스트 구현의 장단점:
반대로 연결리스트로 구현했을 때의 장점은 데이터의 최대 개수가 한정되어 있지 않고 삽입 삭제가 용이 하다는 것입니다. 하지만 반대로 배열과 달리 데이터의 조회가 힘든다는 점입니다. 배열과 달리 노드를 따라따라 가서 조회를 해야지 데이터를 찾을 수 있기 때문입니다.

## 큐(Queue)
- FIFO(First In First Out) 구조
- 자바에서 데이터의 추가/삭제가 보다 쉬운 LinkedList로 구현
- 메서드

peek() : Queue에서 객체를 꺼내지는 않지만 front에 저장된 객체를 반환

add(Object o) : Queue에 객체를 저장

offer(Object o) : Queue에 객체를 저장

remove(): Queue의 front에 저장된 객체를 꺼낸다.

poll(): Queue의 front에 저장된 객체를 꺼낸다.

## c.f. PriorityQueue: 우선순위가 높은것부터 꺼낸다 
