package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //@Controller 애노테이션이 있으면 스프링이 뜰때 스프링 컨테이너가 MemberController 객체를 생성해서 스프링에 넣어두고 스프링에서 관리한다.
//@Component가 @Controller 안에 있음
public class MemberController {

    private final MemberService memberService;
    //스프링 컨테이너에 등록하고 사용하면 한번 등록하면 사용가능

    @Autowired //MemberController 생성되면서 생성자를 호출함, 생성되면서 스프링빈에 등록되어있는 MemberService 객체를 가져다가 넣어줌 (DI - 의존관계 주입)
    //@Autowired가 있으면 스프링이 스프링컨테이너에 있는 memberService를 가져와서 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){ //list로 모든 회원을 담아둠
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}