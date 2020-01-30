package com.theslipper.chargebackspecialist.chargebackspecialist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
                // Permit All could be added also for statics
                .antMatchers("/usrmanagement/**").hasRole("System Administrator")
                .antMatchers("/api/v1/**").hasRole("APIv1 User")
                .antMatchers("/chargebacks/**").hasAnyRole("Normal User", "System Administrator")
                .antMatchers("/**").authenticated()
                .antMatchers("/registration").permitAll()
                .antMatchers("/static/**").permitAll();
        httpSecurity.formLogin()
                .loginProcessingUrl("/login").usernameParameter("login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT system_user_login, system_user_password, system_user_enabled FROM system_users " +
                        "WHERE system_user_login = ?")
                .authoritiesByUsernameQuery("SELECT system_users.system_user_login, system_user_roles.system_user_role_permissions FROM system_users\n" +
                        "    INNER JOIN system_user_roles ON system_users.system_user_role_system_user_role_id = system_user_roles.system_user_role_id\n" +
                        "    WHERE system_users.system_user_login = ?;")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
