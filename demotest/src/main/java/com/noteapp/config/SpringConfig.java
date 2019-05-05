package com.noteapp.config;

import com.noteapp.dao.UserDao;
import com.noteapp.dao.UserDaoImpl;
import com.noteapp.service.UserService;
import com.noteapp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {



    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/NoteApp?userSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("rootpasswordgiven");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;

    }


    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

}
