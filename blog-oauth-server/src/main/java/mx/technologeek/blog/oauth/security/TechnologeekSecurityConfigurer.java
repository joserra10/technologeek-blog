/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.blog.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security configuration.
 * 
 * @author rsalas - Technologeek Soft
 */
@Configuration
public class TechnologeekSecurityConfigurer
        extends WebSecurityConfigurerAdapter {

    /** the user detail service. */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Generates an instance to encode the user password.
     * 
     * @return Spring bean.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter#configure(org.springframework.security.
     * config.annotation.authentication.builders.AuthenticationManagerBuilder).
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter#authenticationManager().
     */
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
