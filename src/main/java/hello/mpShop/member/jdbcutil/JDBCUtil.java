package hello.mpShop.member.jdbcutil;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class JDBCUtil {


    public static Connection getConnection() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_mpshop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
        String user = "root";
        String pw = "1234";

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
