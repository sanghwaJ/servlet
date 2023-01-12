package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    // GET 요청으로만 호출 가능하도록 제약 설정
    // @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("new-form")
    public String newForm() {
        // 애노테이션 사용으로 modelAndView가 아닌 String을 반환해도 됨
        return "new-form";
    }

    // POST 요청으로만 호출 가능하도록 제약 설정
    // @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        // ModelAndView mv = new ModelAndView("save-result");
        // mv.addObject("member", member);
        // 위의 코드 대체
        model.addAttribute("member", member);

        return "save-result";
    }

    // GET 요청으로만 호출 가능하도록 제약 설정
    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        // ModelAndView mv = new ModelAndView("members");
        // mv.addObject("members", members);
        // 위의 코드 대체
        model.addAttribute("members", members);

        return "members";
    }
}
