package hello.mpShop.member.controller;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public Boolean save(@RequestBody Member member) {
        Boolean savedMember = memberService.save(member);
        log.info("id = {}", member.getId());
        log.info("name = {}", member.getName());
        log.info("login_id = {}", member.getLoginId());
        log.info("password = {}", member.getPw());
        log.info("phone_number = {}", member.getPn());
        log.info("gender = {}", member.getGender());
        log.info("birth = {}", member.getBirth());
        return savedMember;
    }
}
