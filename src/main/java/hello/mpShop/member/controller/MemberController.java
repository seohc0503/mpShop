package hello.mpShop.member.controller;

import hello.mpShop.member.member.MemberDTO;
import hello.mpShop.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public int save(@RequestBody MemberDTO memberDTO) {
        int savedMemberId = memberService.save(memberDTO);

        log.info("id = {}", memberDTO.getId());
        log.info("name = {}", memberDTO.getName());
        log.info("login_id = {}", memberDTO.getLoginId());
        log.info("password = {}", memberDTO.getPw());
        log.info("phone_number = {}", memberDTO.getPn());
        log.info("gender = {}", memberDTO.getGender());
        log.info("birth = {}", memberDTO.getBirth());

        return savedMemberId;
    }

    @GetMapping("/{loginId}")
    public MemberDTO findById(@PathVariable(value = "loginId") String loginId) {

        MemberDTO memberDTO = memberService.findById(loginId);

        log.info("id = {}", memberDTO.getId());
        log.info("name = {}", memberDTO.getName());
        log.info("login_id = {}", memberDTO.getLoginId());
        log.info("password = {}", memberDTO.getPw());
        log.info("phone_number = {}", memberDTO.getPn());
        log.info("gender = {}", memberDTO.getGender());
        log.info("birth = {}", memberDTO.getBirth());

        return memberDTO;
    }
}
