# Getting Started

## Gradle
* ./gradlew -wrapper --gradle-version {version}
* ./gradlew clean bootRun --args='--spring.profiles.active=h2'

## Code
### 1. com.starlord.demo.jpa.inheritance
#### 1-1. com.starlord.demo.jpa.inheritance.case1
* 가장 기본적인 상속설정을 테스트 하였다. @Inheritance(strategy = InheritanceType.JOINED)
* 상위클래스와 같은 속성명을 사용하면, (h2사용시)하위속성으로 생성되지 않고 값도 입력할 경우 상위속성으로 입력된다.
* 상위테이블에서 공통의 MappedSuperclass 를 사용했을 경우, 일반 속성을 사용 시와 같이 하위속성으로 생성되지 않고 값도 입력할 경우 상위속성으로 입력된다.
* 하위테이블의 키는 상위테이블의 키가 된다.
 
#### 1-2. com.starlord.demo.jpa.inheritance.case2
* 영속성전이문제
  * FK의 연관관계를 가진 Case2SubItem1 테이블에서 CascadeType.PERSIST를 설정하여 다음의 에러를 방지하였다.
    * object references an unsaved transient instance - save the transient instance before flushing

## JPA 정리
### 상속관계 매핑
#### 조인전략
* @Inheritance(strategy = InheritanceType.JOINED)
  * 장점
    * 테이블이 정규화된다.
    * 외래 키 참조 무결성 제약조건을 활용할 수 있다.
    * 저장공간을 효율적으로 사용한다.
  * 단점
    * 조회할 때 조인이 많이 사용되므로 성능이 저하될 수 있다.
    * 조회 쿼리가 복잡하다.
    * 데이터를 등록할 INSERT SQL을 두 번 실행한다.
* @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
  * 장점
    * 조인이 플요없으므로 일반적으로 조회 성능이 빠르다.
    * 조회 쿼리가 단순하다.
  * 단점
    * 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야 한다.
    * 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있다. 그러므로 상황에 따라서는 조회 성능이 오히려 느려질 수 있다.
* @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
  * 장점
    * 서브타입을 구분해서 처리할 때 효과적이다.
    * not null 제약조건을 사용할 수 있다.
  * 단점
    * 여러 자식 테이블을 함께 조회할 때 성능이 느리다.(SQL에 UNION을 사용해야 한다).
    * 자식 테이블을 통합해서 쿼리하기 어렵다.
  * 특징
    * 구분칼럼(@DiscriminatorColumn)을 사용하지 않는다. 

#### MappedSuperclass
* 실제 테이블과는 매핑없이 공통속성을 상속받아서 사용할 수 있도록 지원한다. 직접 생성해서 사용할 일이 없으므로 추상클래스로 만드는 것을 권장한다.
* MappedSuperclass가 선언된 Entity를 상속받은 클래스의 하위 클래스에는 관련 속성들이 상속되지 않는다.
* 하위 클래스에 동일한 속성을 선언하여도 에러는 안 나지만 생성되지는 않는다.

#### 식별관계매핑
* 식별관계(Identifying RelationShip)
  * 부모테이블의 키를 자식테이블의 '기본키+외래키' 로서 사용
* 비식별관계(Non-Identifying RelationShip)
  * 부모테이블의 키를 자식테이블의 외래키로만 사용
  * 필수적 비식별 관계(Mandatory)
    * 외래키에 NULL을 허용하지 않는다. 연관관계를 필수적으로 맺어야 한다.
  * 선택적 비식별 관계(Optional)
    * 외래키에 NULL을 허용한다. 연관관계를 맺을지 말지 선택할 수 있다.
* 식별/비식별 매핑 적용 방법
  * @IdClass
  * @EmbeddedId
  * @MapsId
  * @JoinColumn / @JoinTable
  

#### 엔터티 하나에 여러 테이블 매핑
* @SecondarayTable(name = "", pkJoinColumns = @PrimaryKeyJoinColmn(name = ""))
* 사용을 권장하지는 않는다.

#### 상속관계에서 하위클래스의 속성 정의

### 영속성 전이 (CASCADE)
* 영속성전이는 단지 엔터티를 영속화할 때 연관된 엔터티도 같이 영속화하는 편리함을 제공한다.