# 해시 (Hash)
해시란 데이터를 다루는 기법 중에 하나로 검색과 저장이 아주 빠르게 진행된다.
아주 빠르게 진행될 수 있는 이유는 데이터를 검색할 때 사용할 key와 실제 데이터의 값이 (value가)  한 쌍으로 존재하고, 
key값이 배열의 인덱스로 변환되기 때문에 검색과 저장의 평균적인 시간 복잡도가 O(1)에 수렴하게 된다.

남궁 성 Java의 정석 / 도인실 교수님 pdf 참고
###	해싱과 해시함수
해싱이란 해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다. 
해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
해싱을 구현한 컬렉션 클래스로는 HashSet,HashMap,HashTable 등이 있다. 

* * *
###	HashSet
Set 인터페이스의 특징대로 중복된 요소를 저장하지 않는다.
데이터 간에 순서가 없다.
저장한 순서를 유지하고자 한다면 LinkedHashSet 사용
 add(Object O) / isEmpty() / remove(Object o) /size() 와 같은 함수가 쓰인다.
 
 [JAVA] <br>
순서가 보장되지 않는 자료구조이다. <br>
중복된 값을 허용하지 않는다. <br>
null 값을 저장할 수 있다. <br>
내부적으로 HashMap을 사용하여 데이터를 저장한다. <br>
만약 저장 순서를 유지해야 한다면 JDK 1.4부터 제공하는 LinkedHashSet 클래스를 사용<br>

###	HashMap

Map의 특징, 키(key)와 값(value)을 하나로 묶어서 하나의 데이터(entry)로 저장한다.
키와 값을 각각 Object 형태로 저장한다.
키는 컬렉션 내에서 유일해야 한다(중복이 허용되지 않음). 값은 중복 허용
put(Object key, Object value) / get(Object key) / isEmpty() / remove(Object key) 와 같은 함수가 쓰인다.

[JAVA] <br>
순서가 보장되지 않는 자료구조이다. <br>
Key와 value를 묶어 하나의 entry로 저장한다는 특징을 갖는다. <br>
그리고 hashing을 사용하기 때문에 많은양의 데이터를 검색하는데 뛰어난 성능을 보인다.<br>
Map 인터페이스의 한 종류로 ("Key", value) 로 이뤄져 있다.<br>
key 값을 중복이 불가능 하고 value는 중복이 가능. <br>
key와 value 값에 null값도 사용 가능하다.<br>
**멀티쓰레드에서 동시에 HashMap을 건드려 Key - value값을 사용하면 문제가 될 수 있다.** <br>
**멀티쓰레드에서는 HashTable을 쓴다** <br>
