package hello.mpShop.member.controller;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final Member member;

    @PostMapping("/save")
    public String save(@RequestBody Member member) {
        String result = String.valueOf(memberService.save(member));
        log.info("memberId = {} ",member.getId());
        log.info("memberName = {} ",member.getName());
        log.info("memberLoginId = {} ",member.getLoginId());
        log.info("memberPassword = {} ",member.getPw());
        log.info("memberPhoneNumber = {} ",member.getPn());
        log.info("memberGender = {} ",member.getGender());
        log.info("memberBirth = {} ",member.getBirth());

        return result;
    }
}
