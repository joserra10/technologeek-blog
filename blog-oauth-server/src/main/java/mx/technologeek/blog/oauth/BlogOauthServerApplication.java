package mx.technologeek.blog.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BlogOauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogOauthServerApplication.class, args);
    }

}
