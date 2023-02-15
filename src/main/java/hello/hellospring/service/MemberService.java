package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
//@Component가 @Service 안에 있음
//순수 자바코드여서 스프링에서 서비스라고 판단할 수 없으므로 @Service 애노테이션 필요하다.
@Transactional  // jpa를 사용할 때 트랜잭션이 필요하다.
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired //스프링 뜰 때 서비스인것을 확인하고 스프링 컨테이너에 있는 MemberRepository를 넣어줌 (DI)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //테스트코드와 같은 Repository 인스턴스 사용하게 한다.

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //Optional로 member를 감쌌다 (null 예외 처리를 위해) //result가 반환이 됐기때문에 바로 Optional 쓰지않고 .ifPresent가 가능하다.
                .ifPresent(m -> { //m(member)에 값이 있다면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
