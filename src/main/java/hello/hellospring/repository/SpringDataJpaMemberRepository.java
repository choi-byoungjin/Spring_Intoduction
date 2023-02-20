package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //스프링빈을 자동으로 등록해주고 가져다 쓰기만 하면 됨

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // 위의 쿼리문과 같은 역할을 한다.
}
