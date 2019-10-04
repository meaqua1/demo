package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hh
 * @create 2019-07-31 14:49
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
