package hello.mpShop.member.service;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.memberdao.MemberDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;
   // private final Member member;

    public Boolean save(Member member) {
        int resultRow = memberDAO.insertMember(member);
        if (resultRow > 0) return true;
        else return false;
    }

}
