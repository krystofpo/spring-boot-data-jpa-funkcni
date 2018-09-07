package kr.persistence;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="app.datasource")//spring boot vezme z application.properties vse co zacina na app.datasource a nasetuje to do Datasource bean
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
