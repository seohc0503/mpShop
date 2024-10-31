package hello.mpShop.member.memberdao;
import hello.mpShop.member.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

//    private final Member member;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_mpshop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    String user = "root";
    String pw = "1234";

    Connection con = null;
    PreparedStatement pstmt = null;
    int resultRow = 0;

    public int insertMember(Member member) {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pw);
            String sql = "INSERT INTO member VALUES (0,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getLoginId());
            pstmt.setString(3, member.getPw());
            pstmt.setString(4, member.getPn());
            pstmt.setString(5, member.getGender());
            pstmt.setDate(6, member.getBirth());

            resultRow = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultRow;
    }
}
