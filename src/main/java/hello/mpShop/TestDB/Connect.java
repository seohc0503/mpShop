package hello.mpShop.TestDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_mpshop?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    String user = "root";
    String pw = "1234";

    Connection con = null;
    Statement stmt = null;

    public Connect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("MySQL DB 연결 성공");
            System.out.println("con = " + con);
            System.out.println("stmt = " + stmt);
        } catch (Exception e) {
            System.out.println("MySQL DB 연결 실패");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
                if (stmt != null) stmt.close();
                System.out.println("con, stmt 연결 해제 완료");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Connect();
    }
}
