/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.blog.oauth.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Authorization server adapter.
 * 
 * @author rsalas - Technologeek Soft
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig
        extends AuthorizationServerConfigurerAdapter {

    /** the password encoder. */
    @Autowired
    private BCryptPasswordEncoder encoder;
    /** the authentication manager. */
    @Autowired
    private AuthenticationManager authenticationManager;

    /** the client id. */
    @Value("${app.config.client.id}")
    private String clientId;
    /** the client secret. */
    @Value("${app.config.client.secret}")
    private String clientSecret;
    /** the signing key. */
    @Value("${app.config.jwk.key}")
    private String signingKey;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.
     * security.oauth2.config.annotation.web.configurers.
     * AuthorizationServerSecurityConfigurer).
     */
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security)
            throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.
     * security.oauth2.config.annotation.configurers.
     * ClientDetailsServiceConfigurer).
     */
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory().withClient(clientId)
                .secret(encoder.encode(clientSecret)).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(60 * 60 * 24)
                .refreshTokenValiditySeconds(60 * 60 * 24);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * AuthorizationServerConfigurerAdapter#configure(org.springframework.
     * security.oauth2.config.annotation.web.configurers.
     * AuthorizationServerEndpointsConfigurer).
     */
    @Override
    public void configure(
            final AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain
                .setTokenEnhancers(Arrays.asList(accessTokenConverter()));
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain);
    }

    /**
     * token store configuration.
     * 
     * @return Spring bean.
     */
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * Access token converter configuration.
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
