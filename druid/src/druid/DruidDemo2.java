package druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hh
 * @create 2019-07-31 15:20
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into users values(null,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"zhangsan");
            pstmt.setString(2,"123456");
            pstmt.setInt(3,2000);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }


    }
}
