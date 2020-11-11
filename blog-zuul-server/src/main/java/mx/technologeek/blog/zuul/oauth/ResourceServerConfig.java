/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.blog.zuul.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * OAUTH2 Configuration.
 * 
 * @author rsalas - Technologeek Soft
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    /** the signing key. */
    @Value("${app.config.jwk.key}")
    private String signingKey;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * ResourceServerConfigurerAdapter#configure(org.springframework.security.
     * oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
     * ).
     */
    @Override
    public void configure(final ResourceServerSecurityConfigurer resources)
            throws Exception {
        resources.tokenStore(tokenStore());
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * ResourceServerConfigurerAdapter#configure(org.springframework.security.
     * config.annotation.web.builders.HttpSecurity).
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/security/oauth/**")
                .permitAll()
                .antMatchers(HttpMethod.GET,
                        "/api/blog/findByTitleLike/{title}",
                        "/api/blog/findByTitle/{title}", "/api/blog/findAll")
                .permitAll().antMatchers("/api/blog/{userId}").hasRole("ADMIN")
                .anyRequest().authenticated().and().cors()
                .configurationSource(corsConfigurationSource());
    }

    /**
     * CORS Configuration.
     * 
     * @return Spring bean.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("*");
        corsConfig.setAllowedMethods(
                Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(
                Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    /**
     * CORS filters.
     * 
     * @return Spring bean.
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }

    /**
     * Define the token store.
     * 
     * @return Spring bean.
     */
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * Define the token converter.
     * 
     * @return Spring bean.
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(signingKey);
        return tokenConverter;
    }

}
