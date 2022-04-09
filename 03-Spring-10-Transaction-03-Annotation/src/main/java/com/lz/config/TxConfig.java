package com.lz.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lz.dao.AccountDao;
import com.lz.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

//用于指定 properties 文件的位置
@PropertySource("classpath:jdbc.properties")
//指定包扫描路径 会扫描指定包下的所有注解
@ComponentScan("com.lz")
//当前类是一个配置类
@Configuration
//开启注解
@EnableTransactionManagement
public class TxConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //@Bean注解用于将指定方法的返回值作为容器中的对象
    //id 就是方法名
    @Bean
    public DataSource dataSource(){
        Properties properties = new Properties();
        properties.setProperty("driverClassName",driverClassName);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);
        DataSource dataSource=null;
        try {
            //通过数据源工厂获取数据源并且加载Properties中的配置
           dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public AccountDao accountDao(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        accountDao.setDataSource(dataSource());
        return accountDao;
    }
}
