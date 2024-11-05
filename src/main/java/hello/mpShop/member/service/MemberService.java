package hello.mpShop.member.service;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.memberdao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public Boolean save(Member member) {
        Connection con = null;

        int result = memberDAO.insertMember(member, con);
        if (result > 0) return true;
        else return false;
    }

}
