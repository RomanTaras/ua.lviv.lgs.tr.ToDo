package ua.lviv.lgs.tr.ToDo.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ua.lviv.lgs.tr", "ua.lviv.lgs.tr"})
public class SpringRootConfig {


    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jpa?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("8971013MOL138700pepe");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
