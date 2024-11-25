package hello.mpShop.member.memberdao;
import hello.mpShop.member.jdbcutil.JDBCUtil;
import hello.mpShop.member.member.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final JDBCUtil jdbcUtil;

    public int insertMember(MemberDTO memberDTO, Connection con, PreparedStatement pstmt, ResultSet rs) {

        int id = 0;
        try {
            con = jdbcUtil.getConnection();
            String sql = "INSERT INTO member" +
                    "(name, login_id, password, phone_number, gender, birth) VALUES (?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getLoginId());
            pstmt.setString(3, memberDTO.getPw());
            pstmt.setString(4, memberDTO.getPn());
            pstmt.setString(5, memberDTO.getGender());
            pstmt.setDate(6, memberDTO.getBirth());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                memberDTO.setId(rs.getInt(1));
                id = memberDTO.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs);
            jdbcUtil.close(pstmt);
            jdbcUtil.close(con);
        }
        return id;
    }

    public MemberDTO findById(String loginId, Connection con, PreparedStatement pstmt, ResultSet rs) {

        MemberDTO memberDTO = new MemberDTO();

        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM member WHERE login_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, loginId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                memberDTO.setId(rs.getInt("id"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setLoginId(rs.getString("login_id"));
                memberDTO.setPw(rs.getString("password"));
                memberDTO.setPn(rs.getString("phone_number"));
                memberDTO.setGender(rs.getString("gender"));
                memberDTO.setBirth(rs.getDate("birth"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs);
            jdbcUtil.close(pstmt);
            jdbcUtil.close(con);
        }
        return memberDTO;
    }
}
