# Getting Started

## Gradle
* ./gradlew -wrapper --gradle-version {version}
* ./gradlew clean bootRun --args='--spring.profiles.active=h2'

## JPA 간략 정리
### 상속관계 매핑

#### 상속관계에서 하위클래스의 속성 정의

#### MappedSuperclass
* MappedSuperclass가 선언된 Entity를 상속받은 클래스의 하위 클래스에는 관련 속성들이 상속되지 않는다.
* 다행이도 하위 클래스에 동일한 속성을 선언하여도 에러는 안 나지만 생기지는 않는다.
