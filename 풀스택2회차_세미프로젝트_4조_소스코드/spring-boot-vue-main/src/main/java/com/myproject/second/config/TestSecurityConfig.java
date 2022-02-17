package com.myproject.second.config;
//package com.myproject.second.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@Slf4j
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//            .withUser("sunghs")
//            .password(passwordEncoder.encode("1234"))
//            .roles("ADMIN", "USER")
//            .and()
//            .withUser("user")
//            .password(passwordEncoder.encode("2345"))
//            .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/**").permitAll()
//            .antMatchers("/admin/**").hasAuthority("ADMIN")
//            .anyRequest()
//            .authenticated()
//            .and()
//            .csrf()
//            .disable()
//            .httpBasic();
//    }
//}