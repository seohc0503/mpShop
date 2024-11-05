package hello.mpShop.member.controller;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


// 요약
// Response
// id 관리
@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public Boolean save(@RequestBody Member member) {
        return memberService.save(member);
    }
}
