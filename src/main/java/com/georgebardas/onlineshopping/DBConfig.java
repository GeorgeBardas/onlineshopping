package com.georgebardas.onlineshopping;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@ComponentScan
public class DBConfig {
    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties(prefix = "jdbc.batch")
    public DataSource primaryDatasource() throws URISyntaxException {
        URI dbUri = new URI("mysql://b924f951de54fc:96c7a844@eu-cdbr-west-03.cleardb.net/heroku_3173bab22ca3e96?reconnect=true");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        DataSourceBuilder basicDataSourceBuilder = DataSourceBuilder.create();
        basicDataSourceBuilder.url(dbUrl);
        basicDataSourceBuilder.username(username);
        basicDataSourceBuilder.password(password);

        return basicDataSourceBuilder.build();
    }
}
