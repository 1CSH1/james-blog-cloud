package org.jamesblog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jamescsh on 9/27/17.
 */
@SpringBootApplication
@EnableZuulProxy
//@EnableOAuth2Sso
public class JamesBlogWebApplication {
//} extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(JamesBlogWebApplication.class, args);
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("*//**")
//                .authorizeRequests()
//                .antMatchers("/index.html", "/login", "/", "/api/catalog*//**", "/user", "assets*//**")
//                .permitAll()
//                .anyRequest().authenticated().and().csrf().disable();
//    }
}
