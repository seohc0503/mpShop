package hello.mpShop.member.service;

import hello.mpShop.member.member.Member;
import hello.mpShop.member.memberdao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public Boolean save(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int result = memberDAO.insertMember(member, con, pstmt, rs);
        if (result > 0) return true;
        else return false;
    }

}
