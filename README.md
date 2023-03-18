# SpringInflearn
인프런 스프링 로드맵

### 스프링 생태계

필수 - 스프링 프레임워크, 스프링 부트
선택 - 스프링 데이터, 스프링 세션, 스프링 시큐리티, 스프링 Rest Docs, 스프링 배치, 스프링 클라우드

https://spring.io/
 
### 스프링 프레임워크
핵심기술: DI컨테이너, AOP, 이벤트
웹기술: 스프링MVC, 스프링WebFlux
데이터 접근 기술: 트랜잭션, JDBC, ORM, XML

### 핵심 개념
- 스프링은 자바 언어 기반의 프레임워크
- 자바 언어의 가장 큰 특징: 객체 지향 언어
- 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
- 스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크

### 다형성
- 역할과 구분으로 세상을 구분
- 클라이언트는 내부 구성을 몰라도 대상의 역할만 알고 있으면 됨
- 클라이언트는 내부 구조가 변경되어도 영향을 받지 않음

#### 다형성의 본질
- 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.

### 스프링과 객체 지향
- 다형성이 가장 중요
- 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
- 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.
- 스프링을 사용하면 레고 블럭을 조립하듯이 구현을 편리하게 변경할 수 있다.
