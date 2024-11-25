package hello.mpShop.member.service;

import hello.mpShop.member.member.MemberDTO;
import hello.mpShop.member.memberdao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public int save(MemberDTO memberDTO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int id = memberDAO.insertMember(memberDTO, con, pstmt, rs);
        if (id > 0) return id;
        else return -1;
    }

    public MemberDTO findById(String loginId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        return memberDAO.findById(loginId, con, pstmt, rs);
    }
}
