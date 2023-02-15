package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//      return new MemoryMemberRepository();
//      return new JdbcMemberRepository(dataSource); //스프링의 다형성 //다른 코드를 바꾸지 않고 수정할 수 있음
//      return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}