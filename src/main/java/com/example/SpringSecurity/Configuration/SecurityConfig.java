package com.example.SpringSecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean
    public SecurityFilterChain checkUrl(HttpSecurity http)
    {
        try
        {
            http.authorizeHttpRequests(xyz->{
                xyz.requestMatchers("/assets/**", "/image/**").permitAll();
                xyz.requestMatchers("/style.css").permitAll();

                xyz.requestMatchers("/*").permitAll();
                xyz.requestMatchers("/student/**").permitAll();
                xyz.requestMatchers("/faculty/**").permitAll();
                xyz.requestMatchers("/admin/**").permitAll();
            });
            http.formLogin().permitAll();
            http.csrf().disable();
            return http.build();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Bean
    public BCryptPasswordEncoder yeLoJiEncoder()
    {
        BCryptPasswordEncoder myecoder = new BCryptPasswordEncoder();
        return myecoder;
    }
}
