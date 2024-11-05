package hello.mpShop.member.memberdao;
import hello.mpShop.member.jdbcutil.JDBCUtil;
import hello.mpShop.member.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final JDBCUtil jdbcUtil;

    public int insertMember(Member member, Connection con) {

        PreparedStatement pstmt = null;
        int result = 0;

        try {
            con = jdbcUtil.getConnection();
            String sql = "INSERT INTO member VALUES (0,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getLoginId());
            pstmt.setString(3, member.getPw());
            pstmt.setString(4, member.getPn());
            pstmt.setString(5, member.getGender());
            pstmt.setDate(6, member.getBirth());

            result = pstmt.executeUpdate();

            if (result > 0) con.commit();
            else con.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(pstmt);
            jdbcUtil.close(con);
        }
        return result;
    }
}
