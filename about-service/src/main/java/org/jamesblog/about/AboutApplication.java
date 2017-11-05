package org.jamesblog.about;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author: James-CSH
 * @Date: 11/5/17 2:25 PM
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class AboutApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutApplication.class, args);
    }

}
