package hello.mpShop.TestDB;

import java.sql.*;

public class Statement {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_mpshop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    String user = "root";
    String pw = "1234";

    Connection con = null;
    java.sql.Statement stmt = null;
    ResultSet rs = null;

    public Statement() {
        try {
            // JDBC Driver 로딩
            Class.forName(driver);
            System.out.println("JDBC Driver 로딩 성공");

            // MySQL DB 연결
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("MySQL DB 연결 성공");

            // SQL 문 작성
            String sql = "SELECT * FROM member";

            // SQL 문 실행 & 결과값 받기
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            // 결과값 출력 (포인터 사용)
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String loginId = rs.getString("login_id");
                String pw = rs.getString("password");
                String pn = rs.getString("phone_number");
                String gender = rs.getString("gender");
                String birth = rs.getString("birth");

                System.out.println(id +"\t"+ name +"\t"+ loginId +"\t"
                        + pw +"\t" + pn +"\t"+ gender +"\t"+ birth);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Statement();
    }
}
