package template;

import druid.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author hh
 * @create 2019-07-31 16:24
 */
public class TemDemo2 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void Test1() {//修改
        String sql = "update users set balance = ? where id = ?";
        template.update(sql, 5000, 2);
    }

    @Test
    public void Test2() {//增加
        String sql = "insert into users(username,password) values(?,?)";
        template.update(sql, "zahngsan", "123456");
    }

    @Test
    public void Test3() {//删除
        String sql = "delete from users where id = ?";
        template.update(sql, 18);
    }

    @Test
    public void Test4() {//查询
        String sql = "select * from users where id = ?";
        //将查询的结果封装到map集合，但只能储存一条记录
        Map<String, Object> map = template.queryForMap(sql, 2);
        System.out.println(map);
    }

    @Test
    public void Test5() {
        String sql = "select * from users";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    @Test
    public void Test6() {
        String sql = "select * from users";
        List<Users> list = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
        for (Users users : list) {
            System.out.println(users);
        }
    }

    @Test
    public void Test7() {
        String sql = "select count(id) from users";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);

    }

    @Test
    public void Test9() {//查询只有一个对象时

        String sql = "select * from users where username = ? and password = ?";
        Users user = template.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class), "aaaa", "123");
        System.out.println(user);
    }

    @Test
    public void Test() {//模糊查询
        String sql = "select * from users where username like ?";
        List<Users> query = template.query(sql, new BeanPropertyRowMapper<>(Users.class), "%a%");
        System.out.println(query);
    }

    @Test
    public void Test8() {
        Connection con = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);//开启事务

            String sql = "update users set balance = balance - ? where id = ?";
            pstmt1 = con.prepareStatement(sql);
            pstmt1.setInt(1, 5000);
            pstmt1.setInt(2, 2);
            int result = pstmt1.executeUpdate();
            System.out.println(result);

//            int i = 1 / 0;


            String sql2 = "update users set balance = balance + ? where id = ?";
            pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, 5000);
            pstmt2.setInt(2, 3);
            int result2 = pstmt2.executeUpdate();
            System.out.println(result2);

            con.commit();//提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, con);
            JDBCUtils.close(pstmt2, con);
        }


    }

}
