package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.Axe.Axe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "defaultAxe")
    public Axe defaultAxe(){
        return new Axe();
    }

    @Bean(name = "customAxe")
    public Axe customAxe(){
        return new Axe("自定义斧子");
    }

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("505066278");
        return dataSource;
    }
}
