package com.icbc.sd.first;

import com.icbc.sd.first.bean.User;
import com.icbc.sd.first.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class BeanTest {
    private static final Logger logger = LoggerFactory.getLogger(BeanTest.class);

    @Test
    void testUser() {
        logger.info("testUser()...");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        User user1 = ctx.getBean("user", User.class);
        logger.info("user1.name: {}", user1.getName());
        User user2 = ctx.getBean("user2", User.class);
        System.out.println(user1);
        System.out.println(user2);
//        System.out.println(user1 == user2);
        logger.info("user1 == user2: {}", user1 == user2);
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }

    @Test
    void testDs() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
            DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("select * from city where id > ?;");
            preparedStatement.setObject(1, 495);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                logger.info("id: {}, name: {}", resultSet.getInt("id"), resultSet.getString("name"));
            }
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("connection.close() failed", e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("preparedStatement.close() failed", e);
                }
            }
        }
    }

    
}
