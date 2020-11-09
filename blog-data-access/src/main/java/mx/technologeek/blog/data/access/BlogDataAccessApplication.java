/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author rsalas - Technologeek Soft
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "mx.technologeek.blog.data.entity" })
public class BlogDataAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogDataAccessApplication.class, args);
    }

}
