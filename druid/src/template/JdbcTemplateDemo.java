package template;

import druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hh
 * @create 2019-07-31 15:48
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update users set balance = ? where id = ?";
        template.update(sql,5000,2);
    }
}
