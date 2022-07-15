package com.reytech.awsimageupload.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.reytech.awsimageupload.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js*/")
                .permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .antMatchers(HttpMethod.POST,"/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails Jhon = User.builder().username("jhon").password(passwordEncoder.encode("jhon123")).authorities(ADMIN.getGrantedAuthority()).build();
        UserDetails Smith= User.builder().username("smith").password(passwordEncoder.encode("smith123")).authorities(STUDENT.getGrantedAuthority()).build();
        UserDetails Jane = User.builder().username("jane").password(passwordEncoder.encode("jane123")).authorities(ADMINTRAINEE.getGrantedAuthority()).build();
        return new InMemoryUserDetailsManager(
                Jhon,Smith,Jane
        );
 }
}
