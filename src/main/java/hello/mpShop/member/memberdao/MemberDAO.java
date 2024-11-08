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

    public int insertMember(Member member, Connection con, PreparedStatement pstmt, ResultSet rs) {

        int id = 0;
        try {
            con = jdbcUtil.getConnection();
            String sql = "INSERT INTO member" +
                    "(name, login_id, password, phone_number, gender, birth) VALUES (?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getLoginId());
            pstmt.setString(3, member.getPw());
            pstmt.setString(4, member.getPn());
            pstmt.setString(5, member.getGender());
            pstmt.setDate(6, member.getBirth());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                member.setId(rs.getInt(1));
                id = member.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(pstmt);
            jdbcUtil.close(con);
            jdbcUtil.close(rs);
        }
        return id;
    }
}
