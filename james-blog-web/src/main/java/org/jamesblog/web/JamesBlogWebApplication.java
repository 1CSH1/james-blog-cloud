package org.jamesblog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("*")
//                        .allowedOrigins("*")
//                        .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
//                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH")
//                        .maxAge(3600)
//                        .exposedHeaders("Location");
//            }
//        };
//    }
    /*
            response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Expose-Headers", "Location");
     */

}
