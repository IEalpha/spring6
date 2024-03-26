import com.icbc.sd.spring_jdbc.bean.Demo01;
import com.icbc.sd.spring_jdbc.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {

    @Test
    void testInsert() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "insert into demo01(name, age, career) values(?, ?, ?)";
        int update = jdbcTemplate.update(sql, "张雨凝", 24, "没蛋的人");
        System.out.println(update);
    }

    @Test
    void testQueryOne() {
        String sql = "select id, name, age, career from demo01 where id = ?";
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        Demo01 demo01 = template.queryForObject(sql, new BeanPropertyRowMapper<>(Demo01.class), 11);
        System.out.println(demo01);
    }

    @Test
    void testQueryAll() {
        String sql = "select id, name, age, career from demo01 where name = ?";
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        List<Demo01> demo01 = template.query(sql, new BeanPropertyRowMapper<>(Demo01.class), "张雨凝");
        System.out.println(demo01);
    }

    @Test
    void testQueryForList() {
        String sql = "select id, name, age, career from demo01";
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        List<Map<String, Object>> maps = template.queryForList(sql);
        System.out.println(maps);
    }
}
