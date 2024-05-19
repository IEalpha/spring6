package com.icbc.sd.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.icbc.sd.mybatis")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class JavaConfig {

//    @Value("${jdbc.url}")
    private final static String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

//    @Value("${jdbc.driverClassName}")
    private final static String driverClassName = "com.mysql.cj.jdbc.Driver";

//    @Value("${jdbc.username}")
    private final static String username = "root";

//    @Value("${jdbc.password}")
    private final static String password = "liuhanxu87516150";


    @Bean
    DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        System.out.println(url);
        ds.setUrl(url);
        ds.setDriverClassName(driverClassName);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
    @Bean
    MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.icbc.sd.mybatis.mapper");
        return msc;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        //指定mybatis核心配置文件
//        sfb.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        return sfb;
    }

}