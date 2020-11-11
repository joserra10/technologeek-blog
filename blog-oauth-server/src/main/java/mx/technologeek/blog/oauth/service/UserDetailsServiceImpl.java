/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.blog.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.blog.oauth.client.UserFeignClient;

/**
 * @author rsalas
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserDetailsServiceImpl.class);

    /** the client. */
    @Autowired
    private UserFeignClient client;

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String).
     */
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        try {
            final UserDTO userDetail = client.findByEmail(username);
            final List<GrantedAuthority> listRoles = userDetail.getListRole()
                    .stream().map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());
            LOGGER.info("Usuario autenticado {}", username);
            return new User(userDetail.getEmail(), userDetail.getPassword(),
                    userDetail.isEnabled(), true, true, true, listRoles);
        } catch (Exception e) {
            LOGGER.error("Error en la autenticacion del usuario: ", e);
            throw new UsernameNotFoundException(
                    "No se encontro al usuario con correo " + username);
        }

    }

}
