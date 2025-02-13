package com.boot.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().requestMatchers(HttpMethod.GET, "/student").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/student/name").hasRole("USER")
//                .and()
//                .httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(
                api -> api.requestMatchers(HttpMethod.GET, "/student").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/student/name").hasRole("USER")
        );
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails user1 = User.builder().username("ahmed").password("{noop}123").roles("ADMIN" , "MANAGER" , "USER").build();
//        UserDetails user2 = User.builder().username("osama").password("{noop}456").roles("ADMIN" , "MANAGER").build();
//        UserDetails user3 = User.builder().username("karim").password("{noop}789").roles("USER").build();
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }

}
