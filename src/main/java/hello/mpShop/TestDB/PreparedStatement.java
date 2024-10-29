package hello.mpShop.TestDB;

import java.sql.*;

public class PreparedStatement {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_mpshop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    String user = "root";
    String pw = "1234";

    Connection con = null;
    java.sql.PreparedStatement pstmt = null;
    ResultSet rs = null;

    public PreparedStatement() {
        try {
            // JDBC Driver 로딩
            Class.forName(driver);

            // MySQL DB 연결
            con = DriverManager.getConnection(url, user, pw);

            // SQL 문 작성
            String sql = "SELECT id, name, login_id, gender FROM member WHERE gender = ? OR gender IS NULL";

            // SQL 문 실행 & 결과값 받기
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"여성");
            rs = pstmt.executeQuery();

            // 결과값 출력 (포인터 사용)
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String loginId = rs.getString("login_id");
                String gender = rs.getString("gender");

                System.out.println(id +"\t"+ name +"\t"+ loginId + "\t" + gender);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new PreparedStatement();
    }
}
