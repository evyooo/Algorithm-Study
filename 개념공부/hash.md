남궁 성 Java의 정석 / 도인실 교수님 pdf 참고


###	해싱과 해시함수

해싱이란 해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다. 
해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
해싱을 구현한 컬렉션 클래스로는 HashSet,HashMap,HashTable 등이 있다. 

###	HashSet

Set 인터페이스의 특징대로 중복된 요소를 저장하지 않는다.
데이터 간에 순서가 없다.
저장한 순서를 유지하고자 한다면 LinkedHashSet 사용
 add(Object O) / isEmpty() / remove(Object o) /size() 와 같은 함수가 쓰인다.

###	HashMap

Map의 특징, 키(key)와 값(value)을 하나로 묶어서 하나의 데이터(entry)로 저장한다.
키와 값을 각각 Object 형태로 저장한다.
키는 컬렉션 내에서 유일해야 한다(중복이 허용되지 않음). 값은 중복 허용
put(Object key, Object value) / get(Object key) / isEmpty() / remove(Object key) 와 같은 함수가 쓰인다.
