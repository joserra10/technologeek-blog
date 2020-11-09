/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import mx.technologeek.blog.data.entity.Blog;
import mx.technologeek.blog.data.entity.User;

/**
 * Configuration that allow IDs will be visible in the rest response.
 * 
 * @author rsalas - Technologeek Soft
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            final RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class, Blog.class);
    }

}
